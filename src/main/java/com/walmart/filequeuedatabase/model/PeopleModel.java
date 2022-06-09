package com.walmart.filequeuedatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleModel implements Serializable {
    @Id
    @Column(name = "personid")
    private String personid;

    @Column(name = "name")
    private String name;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;

    @Column(name = "middle")
    private String middle;

    @Column(name = "email")
    public String email;

    @Column(name = "phone")
    public String phone;

    @Column(name = "fax")
    public String fax;

    @Column(name = "title")
    public String title;
}
