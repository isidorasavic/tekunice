package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.example.dto.HabitatDTO;
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
    public HabitatDTO getOptions(@RequestBody HabitatDTO habitatDTO){
        return habitatService.addNewHabitat(habitatDTO);

    }

//    @RequestMapping(value="/generateRules", method= RequestMethod.POST, produces = "application/json")
//    public void generateRules(){
//        habitatService.generateRules();
//
//    }

    @RequestMapping(value="/user/{username}/habitats", method= RequestMethod.GET, produces = "application/json")
    public List<HabitatDTO> getUserHabitats(@PathVariable("username") String username){
        return habitatService.getAllUserHabitats(username);

    }

    @RequestMapping(value="/habitat/{id}/recommendations", method= RequestMethod.GET, produces = "application/json")
    public RecommendationDTO getRecommendations(@PathVariable("id") long id){
        return habitatService.getRecommendations(id);

    }

}
