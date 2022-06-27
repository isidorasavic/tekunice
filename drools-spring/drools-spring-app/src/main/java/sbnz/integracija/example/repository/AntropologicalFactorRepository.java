package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sbnz.integracija.example.facts.AntropologicalFactors;

import java.util.List;

@Repository
public interface AntropologicalFactorRepository extends JpaRepository<AntropologicalFactors, Long> {

}
