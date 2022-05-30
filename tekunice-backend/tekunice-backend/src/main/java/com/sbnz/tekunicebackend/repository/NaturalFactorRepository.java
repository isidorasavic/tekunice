package com.sbnz.tekunicebackend.repository;

import com.sbnz.tekunicebackend.model.NaturalFactor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaturalFactorRepository extends JpaRepository<NaturalFactor, Long> {
    
}
