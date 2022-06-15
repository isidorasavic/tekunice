package drools.spring.example.controller;

import drools.spring.example.dto.HabitatDTO;
import drools.spring.example.dto.NaturalFactorOptions;
import drools.spring.example.model.Habitat;
import drools.spring.example.model.enums.Type;
import drools.spring.example.service.HabitatService;
import drools.spring.example.service.NaturalFactorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
