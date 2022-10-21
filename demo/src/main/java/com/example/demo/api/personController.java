package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class personController {
    private final PersonService personService;
    @Autowired
    public personController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person) {
    personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getALlPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonByid(@PathVariable("id") UUID id){
        return personService.getPersonbyID(id).orElse(null);
    }


}
