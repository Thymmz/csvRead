package com.walmart.filequeuedatabase.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class People implements Serializable {
    //@CsvBindByPosition(position = 0)
    @DataField(pos = 1, columnName = "person_ID")
    private String personid;

    //@CsvBindByPosition(position = 1)
    @DataField(pos = 2, columnName = "name")
    private String name;

    //@CsvBindByPosition(position = 2)
    @DataField(pos = 3, columnName = "first")
    private String first;

    //@CsvBindByPosition(position = 3)
    @DataField(pos = 4, columnName = "last")
    private String last;

    //@CsvBindByPosition(position = 4)
    @DataField(pos = 5, columnName = "middle")
    private String middle;

    //@CsvBindByPosition(position = 5)
    @DataField(pos = 6, columnName = "email")
    public String email;

    //@CsvBindByPosition(position = 6)
    @DataField(pos = 7, columnName = "phone")
    public String phone;

    //@CsvBindByPosition(position = 7)
    @DataField(pos = 8, columnName = "fax")
    public String fax;

    //@CsvBindByPosition(position = 8)
    @DataField(pos = 9, columnName = "title")
    public String title;
}
