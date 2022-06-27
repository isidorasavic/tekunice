package sbnz.integracija.example.dto;

import lombok.*;
import sbnz.integracija.example.facts.Habitat;
import sbnz.integracija.example.facts.Option;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDTO {

    private List<Option> recommendations;
    private double successRate;
    private String successMessage;
}
