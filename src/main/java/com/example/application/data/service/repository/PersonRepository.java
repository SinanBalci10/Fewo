package com.example.application.data.service.repository;

import com.example.application.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//von person, id ist integer
public interface PersonRepository extends JpaRepository<Person, Integer> {

}