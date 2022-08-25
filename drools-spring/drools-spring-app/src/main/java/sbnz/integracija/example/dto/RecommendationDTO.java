package sbnz.integracija.example.dto;

import lombok.*;
import sbnz.integracija.example.facts.Habitat;
import sbnz.integracija.example.facts.Option;

import java.util.Dictionary;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDTO {

    private Dictionary<String, String> recommendations;
    private double successRate;
    private String successMessage;
}
