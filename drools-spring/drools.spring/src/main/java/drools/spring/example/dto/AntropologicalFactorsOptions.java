package drools.spring.example.dto;

import drools.spring.example.model.enums.Type;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AntropologicalFactorsOptions {

    private List<String> shrubberyOptions;
    private List<String> distanceToNeighbourhoodPopulationOptions;
    private List<String> disturbanceOptions;
    private List<String> roadsOptions;
    private List<String> agricultureOptions;
    private List<String> grazingOptions;
    private List<String> grassRemovingOptions;
    private List<String> predatorsOptions;
    private List<String> protectionOptions;
    private List<String> purpouseOptions;

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
        this.purpouseOptions = new ArrayList<>();
    }


}
