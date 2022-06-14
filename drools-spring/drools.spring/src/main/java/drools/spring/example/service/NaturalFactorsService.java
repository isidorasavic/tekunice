package drools.spring.example.service;

import drools.spring.example.SampleAppService;
import drools.spring.example.dto.NaturalFactorOptions;
import drools.spring.example.model.NaturalFactors;
import drools.spring.example.model.enums.Exposition;
import drools.spring.example.model.enums.Flooding;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaturalFactorsService {

    private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

    private final KieContainer kieContainer;

    @Autowired
    public NaturalFactorsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public NaturalFactorOptions getAllOptions(NaturalFactorOptions naturalFactorOptions) {
        KieSession kieSession = kieContainer.newKieSession("ExampleSession");
        kieSession.insert(naturalFactorOptions);
        kieSession.fireAllRules();
        kieSession.dispose();

        for (Exposition exp : Exposition.values()) {
            naturalFactorOptions.addExpositionOption(exp.name());
        }

        for (Flooding fl : Flooding.values()) {
            naturalFactorOptions.addFloodingOption(fl.name());
        }


        return naturalFactorOptions;
    }
}