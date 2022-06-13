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

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@MockEndpoints()
class route1Test extends CamelTestSupport {

    protected RouteBuilder createTestRouteBuilder() throws Exception{
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                DataFormat bind = new BindyCsvDataFormat(People.class);
                from("file:src/main/resources/files?noop=true&fileName=people.csv")
                        .unmarshal(bind)
                        .split(body())
                        .marshal().json(JsonLibrary.Jackson, true)
                        .convertBodyTo(String.class)
                        .to("mock:mq:queue:INPUT");
            }
        };
    }

    @Test
    public void testMocksAreValid() throws InterruptedException {
        MockEndpoint mock = getMockEndpoint("mock:mq:queue:INPUT");
        mock.expectedMessageCount(1);
        assertMockEndpointsSatisfied();

        List line1 = (List) mock.getReceivedExchanges().get(0).getIn()
                .getBody();
        Map map1 = (Map) line1.get(0);

    }
}