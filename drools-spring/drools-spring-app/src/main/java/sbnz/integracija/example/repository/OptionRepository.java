package sbnz.integracija.example.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sbnz.integracija.example.facts.Option;
import sbnz.integracija.example.facts.enums.Type;

import java.util.List;
import java.util.Optional;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

    Optional<Option> findByLabelAndType(@Param("label") String label, @Param("type") String type);

    List<Option> findAllByType(@Param("type") String type);

}
