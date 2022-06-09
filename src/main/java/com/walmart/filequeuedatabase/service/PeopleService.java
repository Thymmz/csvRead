package com.walmart.filequeuedatabase.service;

import com.walmart.filequeuedatabase.dao.PeopleDao;
import com.walmart.filequeuedatabase.model.PeopleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    public PeopleService(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    public PeopleModel getPersonById(String personid){
        return peopleDao.findById(personid).orElseThrow(()-> new RuntimeException("Person not found with id :" + personid));
    }

    public List<PeopleModel> getAllPeople(){
        return peopleDao.findAll();
    }

    public void savePersontoDb(PeopleModel person){
        peopleDao.save(person);
    }

    public void deletePersonFromDb(String personid){
        PeopleModel person = peopleDao.findById(personid).orElseThrow(()-> new RuntimeException("Person not found with id :" + personid));
        peopleDao.delete(person);
    }

    public void clearDb(){
        peopleDao.deleteAll();
    }
}
