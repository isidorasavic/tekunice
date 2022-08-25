package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.example.dto.HabitatDTO;
import sbnz.integracija.example.dto.HabitatNameDTO;
import sbnz.integracija.example.dto.NewHabitatDTO;
import sbnz.integracija.example.dto.RecommendationDTO;
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
    public HabitatDTO getOptions(@RequestBody NewHabitatDTO habitatDTO){
        return habitatService.addNewHabitat(habitatDTO);

    }

//    @RequestMapping(value="/generateRules", method= RequestMethod.POST, produces = "application/json")
//    public void generateRules(){
//        habitatService.generateRules();
//
//    }

    @RequestMapping(value="/user/{id}/habitats", method= RequestMethod.GET, produces = "application/json")
    public List<HabitatNameDTO> getUserHabitats(@PathVariable("id") long id){
        return habitatService.getAllUserHabitats(id);
    }

    @RequestMapping(value="/habitat/{id}", method= RequestMethod.GET, produces = "application/json")
    public HabitatDTO getHabitat(@PathVariable("id") long id){
        return habitatService.getHabitatById(id);
    }

}
