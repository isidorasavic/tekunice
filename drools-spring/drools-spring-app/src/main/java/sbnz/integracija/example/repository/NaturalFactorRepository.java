package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbnz.integracija.example.facts.NaturalFactors;

@Repository
public interface NaturalFactorRepository extends JpaRepository<NaturalFactors, Long> {
}
