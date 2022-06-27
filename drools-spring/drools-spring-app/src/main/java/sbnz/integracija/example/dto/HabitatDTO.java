package sbnz.integracija.example.dto;

import lombok.*;
import sbnz.integracija.example.facts.Habitat;
import sbnz.integracija.example.facts.NaturalFactors;
import sbnz.integracija.example.facts.Option;
import sbnz.integracija.example.facts.enums.Label;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class HabitatDTO {

    private String name;
    private Option label;
    private NaturalFactorsDTO naturalFactorsDTO;
    private String username;

    private AntropologicalFactorDTO antropologicalFactorDTO;

    private String dateCreated;


    public HabitatDTO(String name, Option label, NaturalFactorsDTO naturalFactorsDTO, String username, AntropologicalFactorDTO antropologicalFactorDTO, String dateCreated) {
        this.name = name;
        this.label = label;
        this.naturalFactorsDTO = naturalFactorsDTO;
        this.username = username;
        this.dateCreated = dateCreated;
        this.antropologicalFactorDTO = antropologicalFactorDTO;
    }

    public HabitatDTO() {
    }

}
