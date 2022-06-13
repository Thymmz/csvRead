package com.walmart.filequeuedatabase.service;

import com.walmart.filequeuedatabase.model.People;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.test.spring.junit5.MockEndpoints;
import org.junit.jupiter.api.Test;

@MockEndpoints()
class route1Test extends CamelTestSupport {

    protected RouteBuilder createTestRouteBuilder() throws Exception{
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                DataFormat bind = new BindyCsvDataFormat(People.class);
                from("{{route.start}}")
                        .unmarshal(bind)
                        .split(body())
                        .marshal().json(JsonLibrary.Jackson, true)
                        .convertBodyTo(String.class)
                        .to("{{route.end}}");
            }
        };
    }

    @Test
    public void testMocksAreValid() throws InterruptedException {
        MockEndpoint mock = getMockEndpoint("mock:out");
        mock.expectedMessageCount(1);
        template.sendBody("direct:in", "3130,\"Burks, Rosella \",Rosella,Burks,,BurksR@univ.edu,963.555.1253,963.777.4065,Professor");
        assertMockEndpointsSatisfied();
    }
}