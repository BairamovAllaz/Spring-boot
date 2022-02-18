package com.example.demo.api;

import com.example.demo.dao.Persondao;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

public class PersonController {
    private final PersonService personService;

    PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        personService.addPerson(person);
    }






}
