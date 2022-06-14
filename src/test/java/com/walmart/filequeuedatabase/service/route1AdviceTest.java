package com.walmart.filequeuedatabase.service;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.test.junit5.params.Test;

import static org.apache.camel.builder.AdviceWith.adviceWith;

public class route1AdviceTest extends CamelTestSupport {

    @Override
    public boolean isUseAdviceWith() {
        return true;
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new route1();
    }

    @Test
    public void testMockEndpoints() throws Exception {
        RouteDefinition route = context.getRouteDefinition("route1");

        adviceWith(route, context,
                new AdviceWithRouteBuilder() {
                    @Override
                    public void configure() throws Exception {
                        weaveAddLast().to("mock:finishGreeting");
                    }
                });

        context.start();

        MockEndpoint mock = getMockEndpoint("mock:finishGreeting");
        mock.expectedMessageCount(1);

        template.sendBody("direct:in", "\"3130,\\\"Burks, Rosella \\\",Rosella,Burks,,BurksR@univ.edu,963.555.1253,963.777.4065,Professor\"");

        mock.assertIsSatisfied();
    }
}