package com.example.demo.service;

import com.example.demo.dao.Persondaothink;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//it is a java(sprig) bean if we have only bean then we can use @Service otherwise @Autowired
@Service
public class PersonService {
    private final Persondaothink persondaothink;
    @Autowired
    public PersonService(@Qualifier("postgres") Persondaothink persondaothink) {
        this.persondaothink = persondaothink;
    }
    public Person addPerson(Person person) {
        return persondaothink.insertPerson(person);
    }
    public List<Person> selectAllPeople() {
        return persondaothink.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return persondaothink.getPersonById(id);
    }

   public Optional<Person> deleteUserService(UUID id) {
         return Optional.ofNullable(persondaothink.deleteUserById(id));
    }

    public Optional<Person> UpdateUserService(UUID id,Person person) {
        return  Optional.ofNullable(persondaothink.UpdateUser(id,person));
    }


}
