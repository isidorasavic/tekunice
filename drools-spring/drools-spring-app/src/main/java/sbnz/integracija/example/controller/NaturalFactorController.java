package sbnz.integracija.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sbnz.integracija.example.dto.NaturalFactorOptions;
import sbnz.integracija.example.facts.Option;
import sbnz.integracija.example.facts.enums.Type;
import sbnz.integracija.example.service.NaturalFactorsService;

import java.util.List;

@RestController
public class NaturalFactorController {
    private final NaturalFactorsService naturalFactorsService;

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationController.class);


    @Autowired
    public NaturalFactorController(NaturalFactorsService naturalFactorsService) {
        this.naturalFactorsService = naturalFactorsService;
    }

    @RequestMapping(value="/naturalFactorOptions", method= RequestMethod.GET, produces = "application/json")
    public NaturalFactorOptions getNaturalFactorOptions(@RequestParam("type") String type){
        LOG.info("Recieved request for options for type: "+type);
        NaturalFactorOptions options = new NaturalFactorOptions();
        options.setHabitatType(Type.valueOf(type));
        return naturalFactorsService.getAllOptions(options);
    }

    @RequestMapping(value="/typeOptions", method= RequestMethod.GET, produces = "application/json")
    public List<Option> getTypeOptions() {
        return naturalFactorsService.getTypeOptions();
    }

}
