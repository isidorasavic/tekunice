package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.example.dto.HabitatDTO;
import sbnz.integracija.example.facts.Habitat;
import sbnz.integracija.example.service.HabitatService;

import java.util.List;

@RestController
public class HabitatController {
    private final HabitatService habitatService;

    @Autowired
    public HabitatController(HabitatService habitatService) {
        this.habitatService = habitatService;
    }

    @RequestMapping(value="/addHabitat", method= RequestMethod.POST, produces = "application/json")
    public Habitat getOptions(@RequestBody HabitatDTO habitatDTO){
        return habitatService.addNewHabitat(habitatDTO);

    }

    @RequestMapping(value="/getHabitatLabel", method= RequestMethod.GET, produces = "application/json")
    public Habitat getHabitatLabel(@RequestBody HabitatDTO habitatDTO){
        return habitatService.generateRules(habitatDTO);

    }

    @RequestMapping(value="/user/{username}/habitats", method= RequestMethod.GET, produces = "application/json")
    public List<HabitatDTO> getUserHabitats(@PathVariable("username") String username){
        return habitatService.getAllUserHabitats(username);

    }

}
