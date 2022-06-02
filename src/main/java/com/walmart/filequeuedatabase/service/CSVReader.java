package com.walmart.filequeuedatabase.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.walmart.filequeuedatabase.model.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;


public class CSVReader {

    public List<People> readCsvFile() throws FileNotFoundException {
        URL resource = getClass().getResource("people.csv");
        FileReader reader = new FileReader("src/main/resources/people.csv");
        CsvToBean<People> csvtobean = new CsvToBeanBuilder<People>(reader)
                .withType(People.class)
                .withSeparator(',')
                .build();
        List<People> result = csvtobean.parse();
        return result;
    }


}
