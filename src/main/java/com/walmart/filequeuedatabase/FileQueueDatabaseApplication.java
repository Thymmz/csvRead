package com.walmart.filequeuedatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.filequeuedatabase.model.People;
import com.walmart.filequeuedatabase.service.CSVReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
@EnableJms
public class FileQueueDatabaseApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(FileQueueDatabaseApplication.class, args);
//		CSVReader csvReader = new CSVReader();
//		List<People> people = csvReader.readCsvFile();
//		System.out.println(people.get(1));
	}

	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}


}
