package com.example.application.data.service.controller;

import com.example.application.data.entity.Fewo;
import com.example.application.data.service.repository.FewoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

public class FewoController {
    @Autowired
    FewoRepository fewoRepository;

    public List<Fewo> getFewo() {
        List<Fewo> fewoList = fewoRepository.findAll();
        return fewoList;
    }
}
