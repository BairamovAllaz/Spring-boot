package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class FakePersonDataAccessService implements  Persondao{
    private static List<Person> DB  = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        Person aman = new Person(id,person.getName());
        DB.add(aman);
        return 1;
    }
}
