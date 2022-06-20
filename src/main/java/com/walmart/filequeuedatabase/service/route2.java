package com.walmart.filequeuedatabase.service;

import com.walmart.filequeuedatabase.model.PeopleModel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class route2 extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("mq:queue:INPUT")
                .unmarshal().json(JsonLibrary.Jackson, PeopleModel.class)
                .process(new Processor() {
                    public void process(Exchange xchg) throws Exception {
                        //Take the Employee object from the exchange and create the insert query
                        PeopleModel person = xchg.getIn().getBody(PeopleModel.class);
                        String query = "INSERT INTO people(personid,name, first, last, middle, email, phone, fax, title)values" +
                                "('" + person.getPersonid() + "','"
                                + person.getName() + "','"
                                + person.getFirst() +"','"
                                + person.getLast() +"','"
                                + person.getMiddle() +"','"
                                + person.getEmail() +"','"
                                + person.getPhone() +"','"
                                + person.getFax() +"','"
                                + person.getTitle() +"')";
                        // Set the insert query in body and call camel jdbc
                        xchg.getIn().setBody(query);
                    }
                })
                .to("jdbc:datasource");
    }
}
