package sbnz.integracija.example.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.NaturalFactorOptions;
import sbnz.integracija.example.model.Option;
import sbnz.integracija.example.model.enums.*;
import sbnz.integracija.example.repository.OptionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NaturalFactorsService {

    private static Logger log = LoggerFactory.getLogger(NaturalFactorsService.class);

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private OptionRepository optionRepository;
//
//    private final KieContainer kieContainer;
//    private final OptionRepository optionRepository;
//
//    @Autowired
//    public NaturalFactorsService(KieContainer kieContainer, OptionRepository optionRepository) {
//        this.kieContainer = kieContainer;
//        this.optionRepository = optionRepository;
//    }

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

    public List<Option> getTypeOptions(){

        List<Option> options = new ArrayList<>();
        for(Type value : Type.values()) {
            if (value == Type.NO_TYPE) continue;
//            Optional<Option> option = optionRepository.findByLabelAndType(value.name(), "type");
//            option.ifPresent(option1 -> options.add(new Option(value.name(), option1.getLabel(), "type")));
            options.add(new Option(value.name(), ":)", "type"));
            //TODO: kad proradi baza
        }
        return options;
    }
}
