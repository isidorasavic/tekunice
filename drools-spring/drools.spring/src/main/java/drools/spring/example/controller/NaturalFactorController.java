package drools.spring.example.controller;

import drools.spring.example.dto.NaturalFactorOptions;
import drools.spring.example.model.enums.Type;
import drools.spring.example.service.NaturalFactorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaturalFactorController {

    private final NaturalFactorsService naturalFactorsService;

    @Autowired
    public NaturalFactorController(NaturalFactorsService naturalFactorsService) {
        this.naturalFactorsService = naturalFactorsService;
    }

    @RequestMapping(value="/getOptions", method= RequestMethod.GET, produces = "application/json")
    public NaturalFactorOptions getOptions(@RequestParam("name") String name, @RequestParam("type") String type){
        NaturalFactorOptions options = new NaturalFactorOptions();
        options.setHabitatName(name);
        options.setHabitatType(Type.valueOf(type));
        return naturalFactorsService.getAllOptions(options);

    }

}
