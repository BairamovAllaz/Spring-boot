package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccess implements Persondaothink{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Person insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person(id,name) VALUES(?,?)";
        int per = jdbcTemplate.update(sql,id,person.getName());
        return null;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id,name FROM person";
        List<Person> person = jdbcTemplate.query(sql, (result, id) -> {
            return new Person(
                    UUID.fromString(result.getString("id")),
                    result.getString("name")
            );
        });
        return person;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        final String sql = "SELECT id,name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (result, personId) -> {
            return new Person(
                    UUID.fromString(result.getString("id")),
                    result.getString("name")
            );
        });
        return Optional.ofNullable(person);
    }

    @Override
    public Person UpdateUser(UUID id, Person person) {
        final String sql = "UPDATE person set name = ? WHERE id = ?";
        int status = jdbcTemplate.update(sql,person.getName(),id);
        return null;
    }

    @Override
    public Person deleteUserById(UUID id) {
        final String sql = "DELETE FROM person WHERE id = ?";
        int per = jdbcTemplate.update(sql,id);
        return null;
    }
}
