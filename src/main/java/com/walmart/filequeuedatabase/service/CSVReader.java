package com.walmart.filequeuedatabase.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.walmart.filequeuedatabase.model.People;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CSVReader {

    @Value("${csv.file.location}")
    private Resource csvLocation;

    @Bean
    public List<People> readCsvFile() throws IOException {

        //Read csv file and convert it to a list of objects
        //FileReader reader = new FileReader("src/main/resources/people.csv");
        CsvToBean<People> csvtobean = new CsvToBeanBuilder<People>(new InputStreamReader(csvLocation.getInputStream()))
                .withType(People.class)
                .withSeparator(',')
                .build();

        List<People> result = csvtobean.parse();

        //Remove header line
        result.remove(0);
        return result;
    }


}
