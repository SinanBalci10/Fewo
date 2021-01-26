package com.example.application.data.service.controller;

import com.example.application.data.entity.Person;
import com.example.application.data.service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @RequestMapping("/hallo")
    public String sayHi(){
        return "hi";
    }

@Autowired
    PersonRepository personRepository;

    public List<Person> getPerson() { //gibt Liste der angelegten Personen zurück
        List<Person> personList = personRepository.findAll();
        return personList;
    }

}
