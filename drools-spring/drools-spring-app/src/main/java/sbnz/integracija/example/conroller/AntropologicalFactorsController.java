package sbnz.integracija.example.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sbnz.integracija.example.dto.AntropologicalFactorsOptions;
import sbnz.integracija.example.service.AntropologicalFactorsService;

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
