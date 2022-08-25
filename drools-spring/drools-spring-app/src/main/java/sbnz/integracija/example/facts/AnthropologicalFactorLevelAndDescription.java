package sbnz.integracija.example.facts;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="anthropological_factor_level_and_description")
public class AnthropologicalFactorLevelAndDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="factor_name", nullable=false)
    private String factorName;
    @Column(name="description", nullable=false)
    private String description;
    @Column(name="level", nullable=false)
    private int level;
    @Column(name="recommendation", nullable=false)
    private String recommendation;

    public AnthropologicalFactorLevelAndDescription(Option option) {
        this.factorName = option.getType();
        this.description = option.getLabel();
        this.level = Integer.parseInt(option.getValue());
        this.recommendation = "";
    }

    public AnthropologicalFactorLevelAndDescription(String factorName, String description, int level, String recommendation) {
        this.factorName = factorName;
        this.description = description;
        this.level = level;
        this.recommendation = recommendation;
    }

    public AnthropologicalFactorLevelAndDescription() {
    }
}
