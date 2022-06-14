package drools.spring.example.controller;

import drools.spring.example.dto.AntropologicalFactorsOptions;
import drools.spring.example.dto.NaturalFactorOptions;
import drools.spring.example.model.enums.Type;
import drools.spring.example.service.AntropologicalFactorsService;
import drools.spring.example.service.NaturalFactorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AntropologicalFactorsController {

    private final AntropologicalFactorsService antropologicalFactorsService;

    @Autowired
    public AntropologicalFactorsController(AntropologicalFactorsService antropologicalFactorsService) {
        this.antropologicalFactorsService = antropologicalFactorsService;
    }

    @RequestMapping(value="/antropologicalFactorsOptions", method= RequestMethod.GET, produces = "application/json")
    public AntropologicalFactorsOptions getOptions(){
        return antropologicalFactorsService.getOptions();
    }
}
