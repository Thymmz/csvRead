package com.walmart.filequeuedatabase.dao;

import com.walmart.filequeuedatabase.model.PeopleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao extends JpaRepository<PeopleModel, String> {
}
