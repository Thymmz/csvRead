package com.walmart.filequeuedatabase.controller;

import com.walmart.filequeuedatabase.model.PeopleModel;
import com.walmart.filequeuedatabase.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleRestController {
    @Autowired
    private PeopleService peopleService;

    public PeopleRestController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/{personid}")
    public PeopleModel getPersonbyId(@PathVariable("personid") String personid){
        return peopleService.getPersonById(personid);
    }

    @GetMapping("/")
    public List<PeopleModel> getAllPeople(){
        return peopleService.getAllPeople();
    }

    @DeleteMapping("/{personid}")
    public void deletePerson(@PathVariable("personid") String personid){
        peopleService.deletePersonFromDb(personid);
    }

    @DeleteMapping()
    public void clearDb(){
        peopleService.clearDb();
    }

    @PostMapping("/")
    public void savePerson(@RequestBody PeopleModel person){
        peopleService.savePersontoDb(person);
    }
}
