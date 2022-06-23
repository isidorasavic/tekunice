package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sbnz.integracija.example.facts.AntropologicalFactorLevelAndDescription;

import java.util.List;

@Repository
public interface AntropologicalFactorAndLevelRepository extends JpaRepository<AntropologicalFactorLevelAndDescription, Long> {

    List<AntropologicalFactorLevelAndDescription> findAllByFactorName(@Param("factor_name") String factor_name);
}
