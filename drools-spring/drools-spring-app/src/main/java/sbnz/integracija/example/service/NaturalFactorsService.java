package sbnz.integracija.example.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.controller.AuthenticationController;
import sbnz.integracija.example.dto.NaturalFactorOptions;
import sbnz.integracija.example.exception.InvalidArgumentException;
import sbnz.integracija.example.facts.NaturalFactors;
import sbnz.integracija.example.dto.NaturalFactorsDTO;
import sbnz.integracija.example.facts.Option;
import sbnz.integracija.example.facts.enums.Exposition;
import sbnz.integracija.example.facts.enums.Flooding;
import sbnz.integracija.example.facts.enums.Type;
import sbnz.integracija.example.repository.NaturalFactorRepository;
import sbnz.integracija.example.repository.OptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NaturalFactorsService {

    private static Logger log = LoggerFactory.getLogger(NaturalFactorsService.class);

    private final KieContainer kieContainer;
    private final OptionRepository optionRepository;
    private final NaturalFactorRepository naturalFactorRepository;

    @Autowired
    public NaturalFactorsService(KieContainer kieContainer, OptionRepository optionRepository,  NaturalFactorRepository naturalFactorRepository) {
        this.kieContainer = kieContainer;
        this.optionRepository = optionRepository;
        this.naturalFactorRepository = naturalFactorRepository;
    }

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationController.class);

    public NaturalFactorOptions getAllOptions(NaturalFactorOptions naturalFactorOptions) {
        LOG.info("Entered service for getting options!");
        LOG.info(naturalFactorOptions.toString());
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

    protected NaturalFactorsDTO getDTO(NaturalFactors naturalFactors) {
        NaturalFactorsDTO naturalFactorsDTO = new NaturalFactorsDTO();
        naturalFactorsDTO.setType(optionRepository.findByValueAndType(naturalFactors.getType().toString(), "type").get().getLabel());
        naturalFactorsDTO.setExposition(optionRepository.findByValueAndType(naturalFactors.getExposition().toString(), "exposition").get().getLabel());
        naturalFactorsDTO.setElevation(optionRepository.findByValueAndType(naturalFactors.getElevation().toString(), "elevation").get().getLabel());
        naturalFactorsDTO.setMjt(optionRepository.findByValueAndType(naturalFactors.getMjt().toString(), "mjt").get().getLabel());
        naturalFactorsDTO.setSlope(optionRepository.findByValueAndType(naturalFactors.getSlope().toString(), "slope").get().getLabel());
        naturalFactorsDTO.setFlooding(optionRepository.findByValueAndType(naturalFactors.getFlooding().toString(), "flooding").get().getLabel());
        return naturalFactorsDTO;
    }

    public NaturalFactorsDTO getById(long id){
        Optional<NaturalFactors> optionalNaturalFactors = naturalFactorRepository.findById(id);
        if(optionalNaturalFactors.isPresent()){
            return getDTO(optionalNaturalFactors.get());
        }
        throw new InvalidArgumentException("Invalid natural factors!");
    }

    public List<Option> getTypeOptions(){

        return optionRepository.findAllByType("type");
    }

    public void saveNaturalFactors(NaturalFactors factors){
        naturalFactorRepository.saveAndFlush(factors);

    }
}
