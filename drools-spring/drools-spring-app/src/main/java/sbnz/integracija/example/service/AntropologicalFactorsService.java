package sbnz.integracija.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.AntropologicalFactorDTO;
import sbnz.integracija.example.dto.AntropologicalFactorsOptions;
import sbnz.integracija.example.dto.NaturalFactorsDTO;
import sbnz.integracija.example.facts.AntropologicalFactors;
import sbnz.integracija.example.facts.Option;
import sbnz.integracija.example.repository.AntropologicalFactorAndLevelRepository;
import sbnz.integracija.example.repository.AntropologicalFactorRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AntropologicalFactorsService {

    private static Logger log = LoggerFactory.getLogger(AntropologicalFactorsService.class);

    private final AntropologicalFactorAndLevelRepository antropologicalFactorLevelAndDescriptionRepository;

    private final AntropologicalFactorRepository antropologicalFactorRepository;

    @Autowired
    public AntropologicalFactorsService(AntropologicalFactorAndLevelRepository antropologicalFactorLevelRepository, AntropologicalFactorRepository antropologicalFactorRepository){
        this.antropologicalFactorLevelAndDescriptionRepository = antropologicalFactorLevelRepository;
        this.antropologicalFactorRepository = antropologicalFactorRepository;
    }

    public AntropologicalFactorsOptions getOptions() {
        AntropologicalFactorsOptions options = new AntropologicalFactorsOptions();
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("shrubbery").forEach(factor -> {
            options.getShrubberyOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("distanceToNeighbourhoodPopulation").forEach(factor -> {
            options.getDistanceToNeighbourhoodPopulationOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("disturbance").forEach(factor -> {
            options.getDisturbanceOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("roads").forEach(factor -> {
            options.getRoadsOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("agriculture").forEach(factor -> {
            options.getAgricultureOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("grazing").forEach(factor -> {
            options.getGrazingOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("grassRemoving").forEach(factor -> {
            options.getGrassRemovingOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("predators").forEach(factor -> {
            options.getPredatorsOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("protection").forEach(factor -> {
            options.getProtectionOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        antropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("purpose").forEach(factor -> {
            options.getPurposeOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });

        return options;
    }

    protected AntropologicalFactorDTO getDTO(AntropologicalFactors antropologicalFactors) {
        AntropologicalFactorDTO antropologicalFactorDTO = new AntropologicalFactorDTO();
        antropologicalFactorDTO.setShrubbery(new Option(antropologicalFactors.getShrubbery()));
        antropologicalFactorDTO.setDistanceToNeighbourhoodPopulation(new Option(antropologicalFactors.getDistanceToNeighbourhoodPopulation()));
        antropologicalFactorDTO.setDisturbance(new Option(antropologicalFactors.getDisturbance()));
        antropologicalFactorDTO.setRoads(new Option(antropologicalFactors.getRoads()));
        antropologicalFactorDTO.setAgriculture(new Option(antropologicalFactors.getAgriculture()));
        antropologicalFactorDTO.setGrazing(new Option(antropologicalFactors.getGrazing()));
        antropologicalFactorDTO.setGrassRemoving(new Option(antropologicalFactors.getGrassRemoving()));
        antropologicalFactorDTO.setPredators(new Option(antropologicalFactors.getPredators()));
        antropologicalFactorDTO.setProtection(new Option(antropologicalFactors.getProtection()));
        antropologicalFactorDTO.setPurpose(new Option(antropologicalFactors.getPurpose()));
        return antropologicalFactorDTO;

    }

    protected AntropologicalFactors getFactorsFromDTO(AntropologicalFactorDTO antropologicalFactorDTO){
        AntropologicalFactors factors = new AntropologicalFactors();
        factors.setShrubbery(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getShrubbery().getValue()), "shrubbery"));
        factors.setDistanceToNeighbourhoodPopulation(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getDistanceToNeighbourhoodPopulation().getValue()), "distanceToNeighbourhoodPopulation"));
        factors.setDisturbance(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getDisturbance().getValue()), "disturbance"));
        factors.setRoads(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getRoads().getValue()), "roads"));
        factors.setAgriculture(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getAgriculture().getValue()), "agriculture"));
        factors.setGrazing(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getGrazing().getValue()), "grazing"));
        factors.setGrassRemoving(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getGrassRemoving().getValue()), "grassRemoving"));
        factors.setPredators(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getPredators().getValue()), "predators"));
        factors.setProtection(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getProtection().getValue()), "protection"));
        factors.setPurpose(antropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getPurpose().getValue()), "purpose"));

        return factors;
    }

    public void saveAntropologicalFactors(AntropologicalFactors factors){
        antropologicalFactorRepository.saveAndFlush(factors);
    }
}
