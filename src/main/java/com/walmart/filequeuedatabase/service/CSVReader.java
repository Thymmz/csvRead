package com.walmart.filequeuedatabase.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.walmart.filequeuedatabase.model.People;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

@Service
public class CSVReader {

    public List<People> readCsvFile() throws FileNotFoundException {
        URL resource = getClass().getResource("people.csv");
        FileReader reader = new FileReader("src/main/resources/people.csv");
        CsvToBean<People> csvtobean = new CsvToBeanBuilder<People>(reader)
                .withType(People.class)
                .withSeparator(',')
                .build();
        List<People> result = csvtobean.parse();
        result.remove(0);
        return result;
    }


}
