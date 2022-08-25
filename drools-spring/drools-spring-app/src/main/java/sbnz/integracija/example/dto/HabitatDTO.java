package sbnz.integracija.example.dto;

import lombok.*;
import sbnz.integracija.example.facts.Option;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class HabitatDTO {

    private long id;
    private String name;
    private Option label;
    private NaturalFactorsDTO naturalFactorsDTO;
    private String username;

    private List<AntropologicalFactorDTO> anthropologicalFactorDTO;

    private String dateCreated;


    public HabitatDTO(long id, String name, Option label, NaturalFactorsDTO naturalFactorsDTO, String username, List<AntropologicalFactorDTO> anthropologicalFactorDTO, String dateCreated) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.naturalFactorsDTO = naturalFactorsDTO;
        this.username = username;
        this.dateCreated = dateCreated;
        this.anthropologicalFactorDTO = anthropologicalFactorDTO;
    }

    public HabitatDTO() {
    }

}
