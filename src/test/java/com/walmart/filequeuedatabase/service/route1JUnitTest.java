package com.walmart.filequeuedatabase.service;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class route1JUnitTest extends CamelTestSupport {

    protected RouteBuilder createRouteBuilder() throws Exception{
        return new route1();
    }

    @Test
    public void testRoutesAreValid() throws InterruptedException{
        System.out.println("Sending 1");
        template.sendBody("file:src/main/resources/files?noop=true", "3130,\"Burks, Rosella \",Rosella,Burks,,BurksR@univ.edu,963.555.1253,963.777.4065,Professor");
    }
}
