package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public Person addPerson(@Valid @NonNull @RequestBody Person person) {
        Person addedUser = personService.addPerson(person);
        return addedUser;
    }
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.selectAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonByID(@PathVariable("id") UUID id) {
        return personService.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public Person deleteUserById(@PathVariable("id") UUID id) {
        return personService.deleteUserService(id).orElse(null);
    }

    @PutMapping(path = "{id}")
        public Person UpdateUser(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Person person) {
            return personService.UpdateUserService(id,person).orElse(null);
    }
}
