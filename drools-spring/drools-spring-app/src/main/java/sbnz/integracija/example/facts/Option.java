package sbnz.integracija.example.facts;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="factor_options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "value")
    private String value;

    @Column(name = "label")
    private String label;

    @Column(name = "type")
    private String type;

    public Option() {
    }

    public Option(String value, String label, String type) {
        this.value = value;
        this.label = label;
        this.type = type;
    }

    public Option(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Option{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    public Option(AntropologicalFactorLevelAndDescription antropologicalFactor) {
        this.value = antropologicalFactor.getLevel()+"";
        this.label = antropologicalFactor.getDescription();
        this.type = antropologicalFactor.getFactorName();
    }

}