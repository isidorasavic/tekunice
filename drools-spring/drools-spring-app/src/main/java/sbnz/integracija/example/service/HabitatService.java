package sbnz.integracija.example.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.HabitatDTO;
import sbnz.integracija.example.facts.AntropologicalFactors;
import sbnz.integracija.example.facts.Habitat;

@Service
public class HabitatService {

    private static Logger log = LoggerFactory.getLogger(HabitatService.class);

    private final KieContainer kieContainer;

    @Autowired
    public HabitatService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Habitat generateRules(HabitatDTO habitatDTO) {

        Habitat habitat = new Habitat(habitatDTO);
        habitat.setAntropologicalFactors(new AntropologicalFactors());
        KieSession kieSession = kieContainer.newKieSession("TemplateSession");
        kieSession.insert(habitat);
        kieSession.fireAllRules();
        kieSession.dispose();
        return habitat;
    }

    public Habitat addNewHabitat(HabitatDTO habitatDTO) {

        Habitat newHabitat = new Habitat(habitatDTO);
        newHabitat.setAntropologicalFactors(new AntropologicalFactors());

        KieSession kieSession = kieContainer.newKieSession("ExampleSession");
        kieSession.insert(newHabitat);
        kieSession.fireAllRules();
        kieSession.dispose();

        return newHabitat;
    }

}
