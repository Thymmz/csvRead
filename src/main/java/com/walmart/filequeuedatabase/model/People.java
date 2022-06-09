package com.walmart.filequeuedatabase.model;

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
    @DataField(pos = 1, columnName = "person_ID")
    private String personid;

    @DataField(pos = 2, columnName = "name")
    private String name;

    @DataField(pos = 3, columnName = "first")
    private String first;

    @DataField(pos = 4, columnName = "last")
    private String last;

    @DataField(pos = 5, columnName = "middle")
    private String middle;

    @DataField(pos = 6, columnName = "email")
    public String email;

    @DataField(pos = 7, columnName = "phone")
    public String phone;

    @DataField(pos = 8, columnName = "fax")
    public String fax;

    @DataField(pos = 9, columnName = "title")
    public String title;
}
