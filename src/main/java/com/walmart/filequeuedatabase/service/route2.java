package com.walmart.filequeuedatabase.service;

import com.walmart.filequeuedatabase.model.PeopleModel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class route2 extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("mq:queue:INPUT")
                .unmarshal().json(JsonLibrary.Jackson, PeopleModel.class)
                .log("${body}");
    }
}
