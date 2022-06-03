package com.walmart.filequeuedatabase.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class People implements Serializable {
    @CsvBindByPosition(position = 0)

    private String personid;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String first;

    @CsvBindByPosition(position = 3)
    private String last;

    @CsvBindByPosition(position = 4)
    private String middle;

    @CsvBindByPosition(position = 5)
    public String email;

    @CsvBindByPosition(position = 6)
    public String phone;

    @CsvBindByPosition(position = 7)
    public String fax;

    @CsvBindByPosition(position = 8)
    public String title;
}
