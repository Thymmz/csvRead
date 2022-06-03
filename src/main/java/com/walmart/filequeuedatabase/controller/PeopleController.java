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
import java.util.List;

@RestController
@RequestMapping("/api/v1/peoplecsv")

public class PeopleController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    public CSVReader csvReader;

    @PostMapping
    public void sendCSVtoqueue() throws FileNotFoundException, JMSException, JsonProcessingException {
        MQQueue destination = new MQQueue("INPUT");
        //List<People> people = csvReader.readCsvFile();
//        people.forEach(person ->
//                jmsTemplate.send(destination, new MessageCreator() {
//                    @Override
//                    public Message createMessage(Session session) throws JMSException {
//                        ObjectMessage objectMessage = session.createObjectMessage(person);
//
//                        return objectMessage;
//                    }
//                })
//                );
        People person = csvReader.readCsvFile();
        ObjectMapper objectMapper = new ObjectMapper();
        String personString = objectMapper.writeValueAsString(person);
        System.out.println(personString);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(personString);
                return textMessage;
            }
        });
    }

}
