package sbnz.integracija.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class HabitatDTO {

    private String name;
    private String label;
    private NaturalFactorsDTO naturalFactorsDTO;
    // TODO: antropological factors
}
