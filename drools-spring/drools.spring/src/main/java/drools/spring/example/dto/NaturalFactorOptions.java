package drools.spring.example.dto;

import drools.spring.example.model.Option;
import drools.spring.example.model.enums.Type;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NaturalFactorOptions {

    private Type habitatType;
    private List<Option> elevationOptions;
    private List<Option> mjtOptions;
    private List<Option> slopeOptions;
    private List<Option> floodingOptions;
    private List<Option> expositionOptions;

    public NaturalFactorOptions() {
        this.setHabitatType(Type.NO_TYPE);
        this.elevationOptions = new ArrayList<>();
        this.mjtOptions = new ArrayList<>();
        this.slopeOptions = new ArrayList<>();
        this.floodingOptions = new ArrayList<>();
        this.expositionOptions = new ArrayList<>();
    }


    public void addElevationOption(String option) {
        this.elevationOptions.add(new Option((option)));
    }

    public void addMjtOption(String option) {
        this.mjtOptions.add(new Option((option)));
    }
    public void addSloopeOption(String option) {
        this.slopeOptions.add(new Option((option)));
    }
    public void addFloodingOption(String option) {
        this.floodingOptions.add(new Option((option)));
    }
    public void addExpositionOption(String option) {
        this.expositionOptions.add(new Option((option)));
    }
}
