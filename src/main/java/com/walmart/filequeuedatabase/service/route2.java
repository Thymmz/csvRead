package com.walmart.filequeuedatabase.service;

import com.walmart.filequeuedatabase.model.PeopleModel;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class route2 extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("mq:queue:INPUT")
                .unmarshal().json(JsonLibrary.Jackson, PeopleModel.class)
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .to("http://localhost:9041/api/v1/people/")
                .log("${body}");
    }
}
