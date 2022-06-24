package sbnz.integracija.example.dto;

import lombok.*;
import sbnz.integracija.example.facts.Habitat;
import sbnz.integracija.example.facts.NaturalFactors;
import sbnz.integracija.example.facts.Option;
import sbnz.integracija.example.facts.enums.Label;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class HabitatDTO {

    private String name;
    private Option label;
    private NaturalFactorsDTO naturalFactorsDTO;
    private String username;

    private String dateCreated;
    // TODO: antropological factors


    public HabitatDTO(String name, Option label, NaturalFactorsDTO naturalFactorsDTO, String username, String dateCreated) {
        this.name = name;
        this.label = label;
        this.naturalFactorsDTO = naturalFactorsDTO;
        this.username = username;
        this.dateCreated = dateCreated;
    }

    public HabitatDTO() {
    }

//    public HabitatDTO(Habitat habitat) {
//        this.name = habitat.getName();
//        this.label = habitat.getLabel().name();
//        this.naturalFactorsDTO = new NaturalFactorsDTO(habitat.getNaturalFactors());
//        //TODO: antropological facrots
//        this.username = habitat.getUser().getUsername();
//        this.dateCreated = habitat.getDateCreated().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//    }
}
