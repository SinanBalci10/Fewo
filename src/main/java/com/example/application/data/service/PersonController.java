package com.example.application.data.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping("/hallo")
    public String sayHi(){
        return "hi";
    }



}
