package com.walmart.filequeuedatabase.service;

import com.walmart.filequeuedatabase.model.People;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class route extends RouteBuilder{

    @Value("${csv.file.location}")
    private String csvLocation;

    @Autowired
    private CSVReader csvReader;

    @Override
    public void configure() throws Exception {
        DataFormat bind = new BindyCsvDataFormat(People.class);

        from("file:src/main/resources/files?noop=true")
                .unmarshal(bind)
                .split(body())
                .marshal().json(JsonLibrary.Jackson, true)
                .convertBodyTo(String.class)
                //.log("${body}")
                .to("mq:queue:INPUT");
    }

}
