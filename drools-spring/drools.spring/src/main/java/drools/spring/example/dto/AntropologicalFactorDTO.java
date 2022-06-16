package drools.spring.example.dto;

import drools.spring.example.model.Option;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AntropologicalFactorDTO {

    private Option shrubbery;
    private Option distanceToNeighbourhoodPopulation;
    private Option disturbance;
    private Option roads;
    private Option agriculture;
    private Option grazing;
    private Option grassRemoving;
    private Option predators;
    private Option protection;
    private Option purpose;


}
