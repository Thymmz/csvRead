package com.walmart.filequeuedatabase.service;

import com.ibm.mq.jms.MQQueue;
import com.walmart.filequeuedatabase.model.People;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class route1 extends RouteBuilder{

//    @Value("${csv.file.location}")
//    private String csvLocation;

    @Override
    public void configure() throws Exception {
        DataFormat bind = new BindyCsvDataFormat(People.class);
        MQQueue queue = new MQQueue("INPUT");
        from("{{route.start}}")
                .id("route1")
                .unmarshal(bind)
                .split(body())
                .marshal().json(JsonLibrary.Jackson, true)
                .convertBodyTo(String.class)
                //.to("log:body");
    //.to("mq:queue");
                .to("mq:queue:INPUT");

    }

}
