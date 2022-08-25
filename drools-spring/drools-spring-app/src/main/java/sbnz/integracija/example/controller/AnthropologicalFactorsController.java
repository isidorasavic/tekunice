package sbnz.integracija.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.example.dto.AntropologicalFactorDTO;
import sbnz.integracija.example.dto.AntropologicalFactorsOptions;
import sbnz.integracija.example.dto.NewHabitatDTO;
import sbnz.integracija.example.dto.RecommendationDTO;
import sbnz.integracija.example.exception.InvalidArgumentException;
import sbnz.integracija.example.facts.AnthropologicalFactors;
import sbnz.integracija.example.service.AnthropologicalFactorsService;

@RestController
public class AnthropologicalFactorsController {

    private final AnthropologicalFactorsService anthropologicalFactorsService;

    @Autowired
    public AnthropologicalFactorsController(AnthropologicalFactorsService anthropologicalFactorsService) {
        this.anthropologicalFactorsService = anthropologicalFactorsService;
    }

    @RequestMapping(value="/anthropologicalFactorsOptions", method= RequestMethod.GET, produces = "application/json")
    public AntropologicalFactorsOptions getOptions(){
        return anthropologicalFactorsService.getOptions();
    }

    @RequestMapping(value="/anthropologicalFactors/{id}/recommendations", method= RequestMethod.GET, produces = "application/json")
    public RecommendationDTO getRecommendations(@PathVariable("id") long id){
        return anthropologicalFactorsService.getRecommendations(id);
    }

    @RequestMapping(value="/habitat/{habitatId}/updateAnthropologicalFactors", method= RequestMethod.PUT, produces = "application/json")
    public AnthropologicalFactors updateAnthropologicalFactors(@PathVariable("habitatId") long habitatId, @RequestBody AntropologicalFactorDTO antropologicalFactorDTO){
        if (habitatId != antropologicalFactorDTO.getHabitatId())
            throw new InvalidArgumentException("Habitat id mismatch!");
        return anthropologicalFactorsService.addNewAnthropologicalFactors(antropologicalFactorDTO, habitatId);
    }
}
