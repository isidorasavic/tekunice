package sbnz.integracija.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.model.Option;

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
