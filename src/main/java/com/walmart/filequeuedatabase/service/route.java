package com.walmart.filequeuedatabase.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class route extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("mq:queue:INPUT")
                .log("${body}");
    }
}
