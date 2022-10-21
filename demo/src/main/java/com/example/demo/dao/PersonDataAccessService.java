package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakedao")
public class PersonDataAccessService implements PersonDao{
    private  static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> SelectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> SelectPersonbyID(UUID id) {
        return DB.stream()
                .filter(Person -> Person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonbyID(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonbyID(UUID id, Person person) {
        return 0;
    }
}
