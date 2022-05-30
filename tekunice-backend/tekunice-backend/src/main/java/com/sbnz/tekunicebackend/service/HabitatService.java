package com.sbnz.tekunicebackend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sbnz.tekunicebackend.model.AntropologicalFactor;
import com.sbnz.tekunicebackend.model.Habitat;
import com.sbnz.tekunicebackend.model.NaturalFactor;
import com.sbnz.tekunicebackend.model.enums.Elevation;
import com.sbnz.tekunicebackend.model.enums.Exposition;
import com.sbnz.tekunicebackend.model.enums.Flooding;
import com.sbnz.tekunicebackend.model.enums.Label;
import com.sbnz.tekunicebackend.model.enums.MJT;
import com.sbnz.tekunicebackend.model.enums.Slope;
import com.sbnz.tekunicebackend.model.enums.Type;
import com.sbnz.tekunicebackend.repository.HabitatRepository;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitatService {

    private static Logger log = LoggerFactory.getLogger(HabitatService.class);

    @Autowired
    private HabitatRepository habitatRepository;

    @Autowired
    private KieContainer kieContainer;


    public Habitat getHabitat(){
        NaturalFactor naturalFactors = new NaturalFactor(Type.BM, Elevation.ExtraLarge, MJT.Cold, Exposition.East, Slope.Great, Flooding.None);
        AntropologicalFactor antropologicalFactor = new AntropologicalFactor(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, LocalDate.now() );
        List<AntropologicalFactor> list = new ArrayList<>();
        list.add(antropologicalFactor);
        Habitat habitat = new Habitat(Label.NoLabel, naturalFactors, list);
        
        KieSession kieSession = kieContainer.newKieSession("ExampleSession");
        kieSession.insert(habitat);
        kieSession.fireAllRules();
        kieSession.dispose();
        return habitat;
    }
    
}
