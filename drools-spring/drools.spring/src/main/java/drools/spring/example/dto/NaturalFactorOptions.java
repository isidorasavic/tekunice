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
public class NaturalFactorOptions {

    private String habitatName;
    private Type habitatType;
    private List<String> elevationOptions;
    private List<String> mjtOptions;
    private List<String> slopeOptions;
    private List<String> floodingOptions;
    private List<String> expositionOptions;

    public NaturalFactorOptions() {
        this.habitatName = "";
        this.setHabitatType(Type.NO_TYPE);
        this.elevationOptions = new ArrayList<>();
        this.mjtOptions = new ArrayList<>();
        this.slopeOptions = new ArrayList<>();
        this.floodingOptions = new ArrayList<>();
        this.expositionOptions = new ArrayList<>();
    }


    public void addElevationOption(String option) {
        this.elevationOptions.add(option);
    }

    public void addMjtOption(String option) {
        this.mjtOptions.add(option);
    }
    public void addSloopeOption(String option) {
        this.slopeOptions.add(option);
    }
    public void addFloodingOption(String option) {
        this.floodingOptions.add(option);
    }
    public void addExpositionOption(String option) {
        this.expositionOptions.add(option);
    }

    public String getHabitatName() {
        return habitatName;
    }

    public void setHabitatName(String habitatName) {
        this.habitatName = habitatName;
    }
}
