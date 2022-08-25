package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sbnz.integracija.example.facts.AnthropologicalFactors;

import java.util.List;

@Repository
public interface AnthropologicalFactorRepository extends JpaRepository<AnthropologicalFactors, Long> {

    List<AnthropologicalFactors> findAllByHabitatId(@Param("habitat_id") long habitat_id);
}
