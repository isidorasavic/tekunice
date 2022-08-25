package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sbnz.integracija.example.facts.AnthropologicalFactorLevelAndDescription;

import java.util.List;

@Repository
public interface AnthropologicalFactorAndLevelRepository extends JpaRepository<AnthropologicalFactorLevelAndDescription, Long> {

    List<AnthropologicalFactorLevelAndDescription> findAllByFactorName(@Param("factor_name") String factor_name);

    AnthropologicalFactorLevelAndDescription getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(@Param("level") int level, @Param("factor_name") String factor_name);
}
