package sbnz.integracija.example.service;

import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.HabitatDTO;
import sbnz.integracija.example.dto.HabitatNameDTO;
import sbnz.integracija.example.dto.NewHabitatDTO;
import sbnz.integracija.example.exception.InvalidArgumentException;
import sbnz.integracija.example.facts.*;
import sbnz.integracija.example.facts.enums.Label;
import sbnz.integracija.example.repository.HabitatRepository;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HabitatService {

    private static Logger log = LoggerFactory.getLogger(HabitatService.class);

    private final KieContainer kieContainer;

    private final CustomUserDetailsService userService;

    private final HabitatRepository habitatRepository;

    private final NaturalFactorsService naturalFactorsService;

    private final AnthropologicalFactorsService anthropologicalFactorsService;

    @Autowired
    public HabitatService(KieContainer kieContainer, CustomUserDetailsService userService,HabitatRepository habitatRepository, NaturalFactorsService naturalFactorsService, AnthropologicalFactorsService anthropologicalFactorsService) {
        this.habitatRepository = habitatRepository;
        this.kieContainer = kieContainer;
        this.userService = userService;
        this.naturalFactorsService = naturalFactorsService;
        this.anthropologicalFactorsService = anthropologicalFactorsService;
    }

    public KieSession generateRules() {

        InputStream template = HabitatService.class.getResourceAsStream("/habitat-classify-template.drt");

        DataProvider dataProvider = new ArrayDataProvider(new String[][]{
                new String[]{"PZS", "South", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PZS", "South", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PZS", "South", "NoElevation", "VeryHot", "OPTIMAL"},
                new String[]{"PZS", "South", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PZS", "South", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PZS", "South", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PZS", "SouthEast", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PZS", "SouthEast", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PZS", "SouthEast", "NoElevation", "VeryHot", "OPTIMAL"},
                new String[]{"PZS", "SouthEast", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PZS", "SouthEast", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PZS", "SouthEast", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PZS", "SouthWest", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PZS", "SouthWest", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PZS", "SouthWest", "NoElevation", "VeryHot", "OPTIMAL"},
                new String[]{"PZS", "SouthWest", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PZS", "SouthWest", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PZS", "SouthWest", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PZS", "NoExposition", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PZS", "NoExposition", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PZS", "NoExposition", "NoElevation", "VeryHot", "OPTIMAL"},
                new String[]{"PZS", "NoExposition", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PZS", "NoExposition", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PZS", "NoExposition", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PZS", "NorthEast", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PZS", "NorthEast", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PZS", "NorthEast", "NoElevation", "VeryHot", "SUBOPTIMAL"},
                new String[]{"PZS", "NorthEast", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PZS", "NorthEast", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PZS", "NorthEast", "ExtraSmall", "VeryHot", "OPTIMAL"},

                new String[]{"PZS", "East", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PZS", "East", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PZS", "East", "NoElevation", "VeryHot", "SUBOPTIMAL"},
                new String[]{"PZS", "East", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PZS", "East", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PZS", "East", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PZS", "West", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PZS", "West", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PZS", "West", "NoElevation", "VeryHot", "SUBOPTIMAL"},
                new String[]{"PZS", "West", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PZS", "West", "ExtraSmall", "Hot", "SUBOPTIMAL"},
                new String[]{"PZS", "West", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"SPKP", "South", "NoElevation", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "South", "NoElevation", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "South", "NoElevation", "Hot", "SUBOPTIMAL"},
                new String[]{"SPKP", "South", "NoElevation", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "South", "ExtraSmall", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "South", "ExtraSmall", "Medium", "MODERATE"},
                new String[]{"SPKP", "South", "ExtraSmall", "Hot", "MODERATE"},
                new String[]{"SPKP", "South", "ExtraSmall", "VeryHot", "MODERATE"},

                new String[]{"SPKP", "SouthEast", "NoElevation", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "SouthEast", "NoElevation", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "SouthEast", "NoElevation", "Hot", "SUBOPTIMAL"},
                new String[]{"SPKP", "SouthEast", "NoElevation", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "SouthEast", "ExtraSmall", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "SouthEast", "ExtraSmall", "Medium", "MODERATE"},
                new String[]{"SPKP", "SouthEast", "ExtraSmall", "Hot", "MODERATE"},
                new String[]{"SPKP", "SouthEast", "ExtraSmall", "VeryHot", "MODERATE"},

                new String[]{"SPKP", "SouthWest", "NoElevation", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "SouthWest", "NoElevation", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "SouthWest", "NoElevation", "Hot", "SUBOPTIMAL"},
                new String[]{"SPKP", "SouthWest", "NoElevation", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "SouthWest", "ExtraSmall", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "SouthWest", "ExtraSmall", "Medium", "MODERATE"},
                new String[]{"SPKP", "SouthWest", "ExtraSmall", "Hot", "MODERATE"},
                new String[]{"SPKP", "SouthWest", "ExtraSmall", "VeryHot", "MODERATE"},

                new String[]{"SPKP", "NoExposition", "NoElevation", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "NoExposition", "NoElevation", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "NoExposition", "NoElevation", "Hot", "SUBOPTIMAL"},
                new String[]{"SPKP", "NoExposition", "NoElevation", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "NoExposition", "ExtraSmall", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "NoExposition", "ExtraSmall", "Medium", "MODERATE"},
                new String[]{"SPKP", "NoExposition", "ExtraSmall", "Hot", "MODERATE"},
                new String[]{"SPKP", "NoExposition", "ExtraSmall", "VeryHot", "MODERATE"},

                new String[]{"SPKP", "NorthEast", "NoElevation", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "NoElevation", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "NoElevation", "Hot", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "NoElevation", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "NorthEast", "ExtraSmall", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "ExtraSmall", "Hot", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "ExtraSmall", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "NorthEast", "Small", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "Small", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "Small", "Hot", "SUBOPTIMAL"},
                new String[]{"SPKP", "NorthEast", "Small", "VeryHot", "MODERATE"},

                new String[]{"SPKP", "East", "NoElevation", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "East", "NoElevation", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "East", "NoElevation", "Hot", "MODERATE"},
                new String[]{"SPKP", "East", "NoElevation", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "East", "ExtraSmall", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "East", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "East", "ExtraSmall", "Hot", "SUBOPTIMAL"},
                new String[]{"SPKP", "East", "ExtraSmall", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "East", "Small", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "East", "Small", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "East", "Small", "Hot", "MODERATE"},
                new String[]{"SPKP", "East", "Small", "VeryHot", "MODERATE"},

                new String[]{"SPKP", "West", "NoElevation", "Cold", "SUBOPTIMAL"},
                new String[]{"SPKP", "West", "NoElevation", "Medium", "SUBOPTIMAL"},
                new String[]{"SPKP", "West", "NoElevation", "Hot", "MODERATE"},
                new String[]{"SPKP", "West", "NoElevation", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "West", "ExtraSmall", "Cold", "MODERATE"},
                new String[]{"SPKP", "West", "ExtraSmall", "Medium", "MODERATE"},
                new String[]{"SPKP", "West", "ExtraSmall", "Hot", "MODERATE"},
                new String[]{"SPKP", "West", "ExtraSmall", "VeryHot", "MODERATE"},
                new String[]{"SPKP", "West", "Small", "Cold", "MODERATE"},
                new String[]{"SPKP", "West", "Small", "Medium", "MODERATE"},
                new String[]{"SPKP", "West", "Small", "Hot", "MODERATE"},
                new String[]{"SPKP", "West", "Small", "VeryHot", "MODERATE"},

                new String[]{"PSPNL", "South", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PSPNL", "South", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "South", "NoElevation", "VeryHot", "OPTIMAL"},
                new String[]{"PSPNL", "South", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PSPNL", "South", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "South", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PSPNL", "SouthEast", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PSPNL", "SouthEast", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "SouthEast", "NoElevation", "VeryHot", "OPTIMAL"},
                new String[]{"PSPNL", "SouthEast", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PSPNL", "SouthEast", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "SouthEast", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PSPNL", "SouthWest", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PSPNL", "SouthWest", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "SouthWest", "NoElevation", "VeryHot", "OPTIMAL"},
                new String[]{"PSPNL", "SouthWest", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PSPNL", "SouthWest", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "SouthWest", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PSPNL", "NoExposition", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PSPNL", "NoExposition", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "NoExposition", "NoElevation", "VeryHot", "OPTIMAL"},
                new String[]{"PSPNL", "NoExposition", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PSPNL", "NoExposition", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "NoExposition", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PSPNL", "NorthEast", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PSPNL", "NorthEast", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "NorthEast", "NoElevation", "VeryHot", "SUBOPTIMAL"},
                new String[]{"PSPNL", "NorthEast", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PSPNL", "NorthEast", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "NorthEast", "ExtraSmall", "VeryHot", "OPTIMAL"},

                new String[]{"PSPNL", "East", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PSPNL", "East", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "East", "NoElevation", "VeryHot", "SUBOPTIMAL"},
                new String[]{"PSPNL", "East", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PSPNL", "East", "ExtraSmall", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "East", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PSPNL", "West", "NoElevation", "Medium", "OPTIMAL"},
                new String[]{"PSPNL", "West", "NoElevation", "Hot", "OPTIMAL"},
                new String[]{"PSPNL", "West", "NoElevation", "VeryHot", "SUBOPTIMAL"},
                new String[]{"PSPNL", "West", "ExtraSmall", "Medium", "SUBOPTIMAL"},
                new String[]{"PSPNL", "West", "ExtraSmall", "Hot", "SUBOPTIMAL"},
                new String[]{"PSPNL", "West", "ExtraSmall", "VeryHot", "SUBOPTIMAL"},

                new String[]{"PP", "NorthEast", "Large", "ExtraCold", "MODERATE"},
                new String[]{"PP", "NorthEast", "Large", "VeryCold", "MODERATE"},
                new String[]{"PP", "NorthEast", "Large", "Cold", "INADEQUATE"},
                new String[]{"PP", "NorthEast", "ExtraLarge", "ExtraCold", "INADEQUATE"},
                new String[]{"PP", "NorthEast", "ExtraLarge", "VeryCold", "MODERATE"},
                new String[]{"PP", "NorthEast", "ExtraLarge", "Cold", "MODERATE"},

                new String[]{"PP", "East", "Large", "ExtraCold", "MODERATE"},
                new String[]{"PP", "East", "Large", "VeryCold", "MODERATE"},
                new String[]{"PP", "East", "Large", "Cold", "INADEQUATE"},
                new String[]{"PP", "East", "ExtraLarge", "ExtraCold", "INADEQUATE"},
                new String[]{"PP", "East", "ExtraLarge", "VeryCold", "MODERATE"},
                new String[]{"PP", "East", "ExtraLarge", "Cold", "INADEQUATE"},

                new String[]{"PP", "West", "Large", "ExtraCold", "MODERATE"},
                new String[]{"PP", "West", "Large", "VeryCold", "MODERATE"},
                new String[]{"PP", "West", "Large", "Cold", "INADEQUATE"},
                new String[]{"PP", "West", "ExtraLarge", "ExtraCold", "INADEQUATE"},
                new String[]{"PP", "West", "ExtraLarge", "VeryCold", "INADEQUATE"},
                new String[]{"PP", "West", "ExtraLarge", "Cold", "INADEQUATE"},


        });

        DataProviderCompiler converter = new DataProviderCompiler();
        String drl = converter.compile(dataProvider, template);

        System.out.println(drl);

        return createKieSessionFromDRL(drl);

    }

    private KieSession createKieSessionFromDRL(String drl){
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);

        Results results = kieHelper.verify();

        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: "+message.getText());
            }

            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }

        return kieHelper.build().newKieSession();
    }

    public HabitatDTO addNewHabitat(NewHabitatDTO habitatDTO) {

        User user = (User) userService.loadUserByUsername(habitatDTO.getUsername());

        Habitat newHabitat = new Habitat(habitatDTO.getName(), Label.NO_LABEL,
                new NaturalFactors(habitatDTO.getNaturalFactorsDTO()), user, LocalDate.now());

        naturalFactorsService.saveNaturalFactors(newHabitat.getNaturalFactors());
        habitatRepository.saveAndFlush(newHabitat);
        habitatDTO.getAnthropologicalFactorsDTO().setDateAdded(LocalDate.now().toString());
        AnthropologicalFactors anthropologicalFactors = anthropologicalFactorsService.addNewAnthropologicalFactors(habitatDTO.getAnthropologicalFactorsDTO(),
                                                                                                newHabitat.getId());

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(newHabitat);
        kieSession.insert(anthropologicalFactors);
        kieSession.fireAllRules();
        kieSession.dispose();

        if (newHabitat.getLabel() == Label.NO_LABEL){
            kieSession = generateRules();
            kieSession.insert(newHabitat);
            kieSession.fireAllRules();
            kieSession.dispose();
        }

        if (newHabitat.getLabel() == Label.NO_LABEL){
            throw new InvalidArgumentException("Something went wrong! :(");
        }
        habitatRepository.saveAndFlush(newHabitat);

        return getHabitatById(newHabitat.getId());
    }

    public List<HabitatNameDTO> getAllUserHabitats(String username) {
        User user = (User) userService.loadUserByUsername(username);
        List<HabitatNameDTO> habitats = new ArrayList<>();
        habitatRepository.findAllByUserId(user.getId()).forEach(habitat -> {
            habitats.add(new HabitatNameDTO(habitat));
        });
        return habitats;
    }

    public Habitat findHabitatById(long id){
        Optional<Habitat> optHabitat = habitatRepository.findById(id);
        if (!optHabitat.isPresent())
            throw new InvalidArgumentException("Habitat with id " + id + " not found!");
        return optHabitat.get();
    }

    public HabitatDTO getHabitatById(long id){
        Optional<Habitat> optHabitat = habitatRepository.findById(id);
        if (!optHabitat.isPresent())
            throw new InvalidArgumentException("Habitat with id " + id + " not found!");

        Habitat habitat = optHabitat.get();
        HabitatDTO habitatDTO = new HabitatDTO();
        habitatDTO.setId(habitat.getId());
        habitatDTO.setName(habitat.getName());
        habitatDTO.setUsername(habitat.getUser().getUsername());
        habitatDTO.setLabel(new Option(habitat.getLabel().toString(), habitat.getLabel().getName(), "label"));
        habitatDTO.setDateCreated(habitat.getDateCreated().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        habitatDTO.setNaturalFactorsDTO(naturalFactorsService.getDTO(habitat.getNaturalFactors()));
        habitatDTO.setAnthropologicalFactorDTO(anthropologicalFactorsService.getFactorsForHabitat(habitat.getId()));

        return habitatDTO;

    }
}
