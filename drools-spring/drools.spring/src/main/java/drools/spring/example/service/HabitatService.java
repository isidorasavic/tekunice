package drools.spring.example.service;

import drools.spring.example.SampleAppService;
import drools.spring.example.dto.HabitatDTO;
import drools.spring.example.dto.NaturalFactorOptions;
import drools.spring.example.model.AntropologicalFactors;
import drools.spring.example.model.Habitat;
import drools.spring.example.model.NaturalFactors;
import drools.spring.example.model.enums.Exposition;
import drools.spring.example.model.enums.Flooding;
import drools.spring.example.model.enums.Label;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitatService {

    private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

    private final KieContainer kieContainer;

    @Autowired
    public HabitatService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Habitat addNewHabitat(HabitatDTO habitatDTO) {

        NaturalFactors naturalFactors = new NaturalFactors(habitatDTO.getNaturalFactorsDTO());
        Habitat newHabitat = new Habitat();
        newHabitat.setLabel(Label.NO_LABEL);
        newHabitat.setName(habitatDTO.getName());
        newHabitat.setNaturalFactors(naturalFactors);
        newHabitat.setAntropologicalFactors(new AntropologicalFactors());


        KieSession kieSession = kieContainer.newKieSession("ExampleSession");
        kieSession.insert(newHabitat);
        kieSession.fireAllRules();
        kieSession.dispose();


        return newHabitat;
    }

}
