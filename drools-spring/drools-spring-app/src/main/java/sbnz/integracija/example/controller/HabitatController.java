package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sbnz.integracija.example.dto.HabitatDTO;
import sbnz.integracija.example.facts.Habitat;
import sbnz.integracija.example.service.HabitatService;

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

}
