package com.example.demo.service;

import com.example.demo.dao.Persondao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final Persondao persondao;
    @Autowired
    public PersonService(Persondao persondao) {
        this.persondao = persondao;
    }
    public int addPerson(Person person) {
        return persondao.insertPerson(person);
    }
}
//25