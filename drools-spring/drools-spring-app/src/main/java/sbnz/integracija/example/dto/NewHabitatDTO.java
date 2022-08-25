package sbnz.integracija.example.dto;

import lombok.*;
import sbnz.integracija.example.facts.Option;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class NewHabitatDTO {

    private String name;
    private Option label;
    private NaturalFactorsDTO naturalFactorsDTO;
    private String username;
    private AntropologicalFactorDTO anthropologicalFactorsDTO;

}
