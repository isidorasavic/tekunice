package com.sbnz.tekunicebackend.repository;

import com.sbnz.tekunicebackend.model.AntropologicalFactor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntropologicalFactorRepository extends JpaRepository<AntropologicalFactor, Long>{
    
}
