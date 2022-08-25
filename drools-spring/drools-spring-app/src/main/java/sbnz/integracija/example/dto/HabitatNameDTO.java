package sbnz.integracija.example.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sbnz.integracija.example.facts.Habitat;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class HabitatNameDTO {

    private long id;
    private String name;

    public HabitatNameDTO () {}

    public HabitatNameDTO(long id, String name){
        this.id = id;
        this.name = name;
    }

    public HabitatNameDTO(Habitat habitat){
        this.id = habitat.getId();
        this.name = habitat.getName();
    }

}
