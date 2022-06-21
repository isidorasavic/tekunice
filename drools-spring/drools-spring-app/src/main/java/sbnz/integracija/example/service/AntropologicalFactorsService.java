package sbnz.integracija.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.AntropologicalFactorsOptions;

@Service
public class AntropologicalFactorsService {

    private static Logger log = LoggerFactory.getLogger(AntropologicalFactorsService.class);


    public AntropologicalFactorsOptions getOptions() {
        log.info(":)");
        return null;
//        AntropologicalFactorsOptions options = new AntropologicalFactorsOptions();
//        options.setPredatorsOptions(antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("predators"));
//        return options;
    }

}
