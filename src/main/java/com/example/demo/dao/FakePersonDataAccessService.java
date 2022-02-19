package com.example.demo.dao;
import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository("FakeDao")
public class FakePersonDataAccessService implements  Persondaothink{
    private static List<Person> DB  = new ArrayList<>();
    @Override
    public Person insertPerson(UUID id, Person person) {
        Person aman = new Person(id,person.getName());
        DB.add(aman);
        return aman;
    }
    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }
    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst();
    }
    @Override
    public Person UpdateUser(UUID id, Person person) {
       return getPersonById(id).map(p -> {
           int index = DB.indexOf(p);
           if(index >= 0) {
                DB.set(index,new Person(id,person.getName()));
                return person;
           }
           return null;
       }).orElse(null);
    }
    @Override
    public Person deleteUserById(UUID id) {
        Optional<Person> Myperson = getPersonById(id);
        if(Myperson.isEmpty()) {
            return null;
        }
        DB.remove(Myperson.get());
        return Myperson.orElse(null);
    }
}
