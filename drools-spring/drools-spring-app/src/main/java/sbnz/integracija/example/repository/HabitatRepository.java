package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sbnz.integracija.example.facts.Habitat;

import java.util.List;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long> {

    List<Habitat> findAllByUserId(@Param("user_id") long user_id);
}
