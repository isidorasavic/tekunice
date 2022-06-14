package drools.spring.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class HabitatDTO {

    private String name;
    private NaturalFactorsDTO naturalFactorsDTO;
    // TODO: antropological factors
}
