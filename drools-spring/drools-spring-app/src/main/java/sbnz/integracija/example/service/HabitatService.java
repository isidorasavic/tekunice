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
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.repository.HabitatRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class HabitatService {

    private static Logger log = LoggerFactory.getLogger(HabitatService.class);

    private final KieContainer kieContainer;

    private final CustomUserDetailsService userService;

    private final HabitatRepository habitatRepository;

    private final NaturalFactorsService naturalFactorsService;
    @Autowired
    public HabitatService(KieContainer kieContainer, CustomUserDetailsService userService,HabitatRepository habitatRepository, NaturalFactorsService naturalFactorsService) {
        this.habitatRepository = habitatRepository;
        this.kieContainer = kieContainer;
        this.userService = userService;
        this.naturalFactorsService = naturalFactorsService;
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
        User user = (User) userService.loadUserByUsername(habitatDTO.getUsername());

        Habitat newHabitat = new Habitat(habitatDTO);
        newHabitat.setUser(user);
        newHabitat.setAntropologicalFactors(new AntropologicalFactors());

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(newHabitat);
        kieSession.fireAllRules();
        kieSession.dispose();

        newHabitat.setDateCreated(LocalDate.now());

        return newHabitat;
    }

    public List<HabitatDTO> getAllUserHabitats(String username) {
        User user = (User) userService.loadUserByUsername(username);
        List<HabitatDTO> habitats = new ArrayList<>();
        habitatRepository.findAllByUserId(user.getId()).forEach(habitat -> {
            HabitatDTO habitatDTO = new HabitatDTO();
            habitatDTO.setName(habitat.getName());
            habitatDTO.setUsername(habitat.getUser().getUsername());
            habitatDTO.setLabel( habitat.getLabel().getName());
            habitatDTO.setDateCreated(habitat.getDateCreated().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            habitatDTO.setNaturalFactorsDTO(naturalFactorsService.getDTO(habitat.getNaturalFactors()));
            habitats.add(habitatDTO);
        });
        return habitats;
    }

}
