package sbnz.integracija.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbnz.integracija.example.model.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

//    Optional<Option> findByLabelAndType(@Param("label") String label, @Param("type") String type);
}
