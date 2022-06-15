package drools.spring.example.service;

import drools.spring.example.SampleAppService;
import drools.spring.example.dto.AntropologicalFactorsOptions;
//import drools.spring.example.repository.AntropologicalFactorLevelAndDescriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AntropologicalFactorsService {

    private static Logger log = LoggerFactory.getLogger(SampleAppService.class);


    public AntropologicalFactorsOptions getOptions() {
        log.info(":)");
        return null;
//        AntropologicalFactorsOptions options = new AntropologicalFactorsOptions();
//        options.setPredatorsOptions(antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("predators"));
//        return options;
    }

}
