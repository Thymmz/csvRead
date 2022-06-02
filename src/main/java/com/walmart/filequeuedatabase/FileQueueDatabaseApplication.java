package com.walmart.filequeuedatabase;

import com.walmart.filequeuedatabase.service.CSVReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class FileQueueDatabaseApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(FileQueueDatabaseApplication.class, args);
//		CSVReader csvReader = new CSVReader();
//		csvReader.readCsvFile();
	}



}
