package com.example.demo.dao;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface Persondaothink{
    Person insertPerson(UUID id, Person person);
    default Person insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> selectAllPeople();

    Optional<Person> getPersonById(UUID id);
    Person UpdateUser(UUID id,Person person);
    Person deleteUserById(UUID id);
}