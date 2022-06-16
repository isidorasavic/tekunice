package drools.spring.example.repository;

import drools.spring.example.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {

    Optional<Option> findByLabelAndType(@Param("label") String label, @Param("type") String type);
}
