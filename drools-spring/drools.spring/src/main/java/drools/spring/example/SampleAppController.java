package drools.spring.example;

import drools.spring.example.dto.NaturalFactorOptions;
import drools.spring.example.model.enums.Type;
import drools.spring.example.service.NaturalFactorsService;
import org.kie.api.definition.type.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import drools.spring.example.facts.Item;

@RestController
public class SampleAppController {
	private static Logger log = LoggerFactory.getLogger(SampleAppController.class);

	private final SampleAppService sampleService;
	private final NaturalFactorsService naturalFactorsService;

	@Autowired
	    public SampleAppController(SampleAppService sampleService, NaturalFactorsService naturalFactorsService) {
	        this.sampleService = sampleService;
			this.naturalFactorsService = naturalFactorsService;
	    }

	@RequestMapping(value = "/item", method = RequestMethod.GET, produces = "application/json")
	public Item getQuestions(@RequestParam(required = true) String id, @RequestParam(required = true) String name, @RequestParam(required = true) double cost, @RequestParam(required = true) double salePrice) {

		Item newItem = new Item(Long.parseLong(id), name, cost, salePrice);

		log.debug("Item request received for: " + newItem);

		Item i2 = sampleService.getClassifiedItem(newItem);

		return i2;
	}

//	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
//	public NaturalFactorOptions getQuestions(@RequestParam(required = true) String name, @RequestParam(required = true) String type) {
//
//		NaturalFactorOptions options = new NaturalFactorOptions();
//		options.setHabitatName(name);
//		options.setHabitatType(Type.valueOf(type));
//		return naturalFactorsService.getAllOptions(options);
//	}
}
