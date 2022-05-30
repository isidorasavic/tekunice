package com.sbnz.tekunicebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbnz.tekunicebackend.model.Habitat;
import com.sbnz.tekunicebackend.service.HabitatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping(value="/api/test", produces=MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @Autowired
    private HabitatService habitatService;

    @ResponseBody
    @GetMapping("/nagib")
    public Habitat getPatientsAppointments() {
        return  habitatService.getHabitat();

        
    }
}
