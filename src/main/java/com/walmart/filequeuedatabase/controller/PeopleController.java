package com.walmart.filequeuedatabase.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.mq.jms.MQQueue;
import com.walmart.filequeuedatabase.model.People;
import com.walmart.filequeuedatabase.service.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/peoplecsv")

public class PeopleController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    public CSVReader csvReader;

    @Autowired
    public ObjectMapper mapper;

    @PostMapping
    public void sendCSVtoqueue() throws IOException, JMSException {
        //Jms destination
        MQQueue destination = new MQQueue("INPUT");

        //Get list of people from csv file
        List<People> people = csvReader.readCsvFile();

        //Send a message for each row in the csv file
        people.forEach(person ->
                jmsTemplate.send(destination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        TextMessage textMessage = session.createTextMessage();

                        //Map people object to csv file
                        String personString = null;
                        try {
                            personString = mapper.writeValueAsString(person);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                        textMessage.setText(personString);
                        return textMessage;
                    }
                })
                );
//        People person = csvReader.readCsvFile();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String personString = objectMapper.writeValueAsString(person);
//        System.out.println(personString);
//        jmsTemplate.send(destination, new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                TextMessage textMessage = session.createTextMessage();
//                textMessage.setText(personString);
//                return textMessage;
//            }
//        });
    }

}
