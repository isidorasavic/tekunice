package com.sbnz.tekunicebackend.repository;

import java.util.List;

import com.sbnz.tekunicebackend.model.Habitat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long> {

    List<Habitat> findAllByUserId(@Param("id") long id);
    
}
