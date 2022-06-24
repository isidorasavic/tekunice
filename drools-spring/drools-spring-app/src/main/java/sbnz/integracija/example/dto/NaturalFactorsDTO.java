package sbnz.integracija.example.dto;

import lombok.*;
import org.apache.poi.hssf.record.chart.AxisOptionsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import sbnz.integracija.example.facts.NaturalFactors;
import sbnz.integracija.example.repository.OptionRepository;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class NaturalFactorsDTO {

    private long id;
    private String type;
    private String elevation;
    private String mjt;
    private String exposition;
    private String slope;
    private String flooding;

//    public NaturalFactorsDTO(NaturalFactors naturalFactors){
//        this.id = naturalFactors.getId();
//        this.type = naturalFactors.getType().name();
//        this.elevation = naturalFactors.getElevation().name();
//        this.mjt = naturalFactors.getMjt().name();
//        this.exposition = naturalFactors.getExposition().name();
//        this.slope = naturalFactors.getSlope().name();
//        this.flooding = naturalFactors.getFlooding().name();
//    }

}
