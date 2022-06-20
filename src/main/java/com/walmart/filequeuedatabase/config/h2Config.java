//package com.walmart.filequeuedatabase.config;
//
//import org.h2.server.web.WebServlet;
//import org.springframework.boot.context.embedded.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class h2Config {
//    @Bean
//    ServletRegistrationBean h2servletRegistration(){
//        ServletRegistrationBean registration = new ServletRegistrationBean( new org.h2.server.web.WebServlet());
//        registration.addUrlMappings("/h2-console/*");
//        registration.addInitParameter("webAllowOthers", "true");
//        registration.addInitParameter("webPort", "7777");// <-- the port your wish goes here
//
//        return registration;
//    }
//}
