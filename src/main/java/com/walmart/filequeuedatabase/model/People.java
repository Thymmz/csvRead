package com.walmart.filequeuedatabase.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    @CsvBindByPosition(position = 0)
    //@Id
    //@Column(name = "person_ID")
    private String person_ID;

    @CsvBindByPosition(position = 1)
    //@Column(name = "name")
    private String name;

    @CsvBindByPosition(position = 2)
    //@Column(name = "first")
    private String first;

    @CsvBindByPosition(position = 3)
    //@Column(name = "last")
    private String last;

    @CsvBindByPosition(position = 4)
    //@Column(name = "middle")
    private String middle;

    @CsvBindByPosition(position = 5)
    //@Column(name = "email")
    public String email;

    @CsvBindByPosition(position = 6)
    //@Column(name = "phone")
    public String phone;

    @CsvBindByPosition(position = 7)
    //@Column(name = "fax")
    public String fax;

    @CsvBindByPosition(position = 8)
    //@Column(name = "title")
    public String title;
}
