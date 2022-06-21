package sbnz.integracija.example.dto;

import lombok.*;
import sbnz.integracija.example.model.Option;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AntropologicalFactorsOptions {

    private List<Option> shrubberyOptions;
    private List<Option> distanceToNeighbourhoodPopulationOptions;
    private List<Option> disturbanceOptions;
    private List<Option> roadsOptions;
    private List<Option> agricultureOptions;
    private List<Option> grazingOptions;
    private List<Option> grassRemovingOptions;
    private List<Option> predatorsOptions;
    private List<Option> protectionOptions;
    private List<Option> purposeOptions;

    public AntropologicalFactorsOptions() {
        this.shrubberyOptions = new ArrayList<>();
        this.distanceToNeighbourhoodPopulationOptions = new ArrayList<>();
        this.disturbanceOptions = new ArrayList<>();
        this.roadsOptions = new ArrayList<>();
        this.agricultureOptions = new ArrayList<>();
        this.grazingOptions = new ArrayList<>();
        this.grassRemovingOptions = new ArrayList<>();
        this.predatorsOptions = new ArrayList<>();
        this.protectionOptions = new ArrayList<>();
        this.purposeOptions = new ArrayList<>();
    }


}
