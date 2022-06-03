package com.walmart.filequeuedatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import java.io.FileNotFoundException;

@SpringBootApplication
@EnableJms
public class FileQueueDatabaseApplication {

	public static void main(String[] args) throws FileNotFoundException {SpringApplication.run(FileQueueDatabaseApplication.class, args);}

	//Object Mapper bean
	@Bean
	public ObjectMapper objectMapper(){return new ObjectMapper();}


}
