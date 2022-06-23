package sbnz.integracija.example.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.NaturalFactorOptions;
import sbnz.integracija.example.facts.Option;
import sbnz.integracija.example.facts.enums.Exposition;
import sbnz.integracija.example.facts.enums.Flooding;
import sbnz.integracija.example.facts.enums.Type;
import sbnz.integracija.example.repository.OptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NaturalFactorsService {

    private static Logger log = LoggerFactory.getLogger(NaturalFactorsService.class);

    private final KieContainer kieContainer;
    private final OptionRepository optionRepository;

    @Autowired
    public NaturalFactorsService(KieContainer kieContainer, OptionRepository optionRepository) {
        this.kieContainer = kieContainer;
        this.optionRepository = optionRepository;
    }

    public NaturalFactorOptions getAllOptions(NaturalFactorOptions naturalFactorOptions) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(naturalFactorOptions);
        kieSession.fireAllRules();
        kieSession.dispose();

        NaturalFactorOptions allOptions = getOptionsFromValues(naturalFactorOptions);
        allOptions.setHabitatType(naturalFactorOptions.getHabitatType());

        allOptions.setExpositionOptions(optionRepository.findAllByType("exposition"));
        allOptions.setFloodingOptions(optionRepository.findAllByType("flooding"));

        return allOptions;
    }

    private NaturalFactorOptions getOptionsFromValues(NaturalFactorOptions naturalFactorsOptions){
        NaturalFactorOptions editedOptions = new NaturalFactorOptions();
        List<Option> optionContainer = new ArrayList<>();

        //mjt
        for (Option o : naturalFactorsOptions.getMjtOptions()){
            optionRepository.findByValueAndType(o.getValue(), "mjt").ifPresent(optionContainer::add);
        }
        editedOptions.setMjtOptions(optionContainer);

        optionContainer = new ArrayList<>();
        //sloope
        for (Option o : naturalFactorsOptions.getSlopeOptions()){
            optionRepository.findByValueAndType(o.getValue(), "slope").ifPresent(optionContainer::add);
        }
        editedOptions.setSlopeOptions(optionContainer);

        optionContainer = new ArrayList<>();
        //elevation
        for (Option o : naturalFactorsOptions.getElevationOptions()){
            optionRepository.findByValueAndType(o.getValue(), "elevation").ifPresent(optionContainer::add);
        }
        editedOptions.setElevationOptions(optionContainer);

        return editedOptions;
    }


    public List<Option> getTypeOptions(){

        return optionRepository.findAllByType("type");
    }
}
