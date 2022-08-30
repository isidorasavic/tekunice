package sbnz.integracija.example.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbnz.integracija.example.dto.AntropologicalFactorDTO;
import sbnz.integracija.example.dto.AntropologicalFactorsOptions;
import sbnz.integracija.example.dto.RecommendationDTO;
import sbnz.integracija.example.exception.InvalidArgumentException;
import sbnz.integracija.example.facts.AnthropologicalFactors;
import sbnz.integracija.example.facts.Habitat;
import sbnz.integracija.example.facts.Option;
import sbnz.integracija.example.repository.AnthropologicalFactorAndLevelRepository;
import sbnz.integracija.example.repository.AnthropologicalFactorRepository;
import sbnz.integracija.example.repository.HabitatRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnthropologicalFactorsService {

    private static Logger log = LoggerFactory.getLogger(AnthropologicalFactorsService.class);

    private final AnthropologicalFactorAndLevelRepository anthropologicalFactorLevelAndDescriptionRepository;

    private final AnthropologicalFactorRepository anthropologicalFactorRepository;

    private final HabitatRepository habitatRepository;

    private final KieContainer kieContainer;

    @Autowired
    public AnthropologicalFactorsService(AnthropologicalFactorAndLevelRepository anthropologicalFactorLevelRepository, AnthropologicalFactorRepository anthropologicalFactorRepository, KieContainer kieContainer, HabitatRepository habitatRepository){
        this.anthropologicalFactorLevelAndDescriptionRepository = anthropologicalFactorLevelRepository;
        this.anthropologicalFactorRepository = anthropologicalFactorRepository;
        this.kieContainer = kieContainer;
        this.habitatRepository = habitatRepository;
    }

    public AntropologicalFactorsOptions getOptions() {
        AntropologicalFactorsOptions options = new AntropologicalFactorsOptions();
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("shrubbery").forEach(factor -> {
            options.getShrubberyOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("distanceToNeighbourhoodPopulation").forEach(factor -> {
            options.getDistanceToNeighbourhoodPopulationOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("disturbance").forEach(factor -> {
            options.getDisturbanceOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("roads").forEach(factor -> {
            options.getRoadsOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("agriculture").forEach(factor -> {
            options.getAgricultureOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("grazing").forEach(factor -> {
            options.getGrazingOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("grassRemoving").forEach(factor -> {
            options.getGrassRemovingOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("predators").forEach(factor -> {
            options.getPredatorsOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("protection").forEach(factor -> {
            options.getProtectionOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });
        anthropologicalFactorLevelAndDescriptionRepository.findAllByFactorName("purpose").forEach(factor -> {
            options.getPurposeOptions().add(new Option(factor.getLevel()+"", factor.getDescription(), factor.getFactorName()));
        });

        return options;
    }

    protected AntropologicalFactorDTO getDTO(AnthropologicalFactors antropologicalFactors) {
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

    public AnthropologicalFactors addNewAnthropologicalFactors(AntropologicalFactorDTO antropologicalFactorDTO, long habitatId){

        Optional<Habitat> optHabitat = habitatRepository.findById(habitatId);
        if (!optHabitat.isPresent())
            throw new InvalidArgumentException("Habitat doesn't exist!");

        AnthropologicalFactors factors = new AnthropologicalFactors();
        factors.setShrubbery(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getShrubbery().getValue()), "shrubbery"));
        factors.setDistanceToNeighbourhoodPopulation(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getDistanceToNeighbourhoodPopulation().getValue()), "distanceToNeighbourhoodPopulation"));
        factors.setDisturbance(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getDisturbance().getValue()), "disturbance"));
        factors.setRoads(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getRoads().getValue()), "roads"));
        factors.setAgriculture(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getAgriculture().getValue()), "agriculture"));
        factors.setGrazing(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getGrazing().getValue()), "grazing"));
        factors.setGrassRemoving(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getGrassRemoving().getValue()), "grassRemoving"));
        factors.setPredators(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getPredators().getValue()), "predators"));
        factors.setProtection(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getProtection().getValue()), "protection"));
        factors.setPurpose(anthropologicalFactorLevelAndDescriptionRepository.getAntropologicalFactorLevelAndDescriptionByLevelAndFactorName(Integer.parseInt(antropologicalFactorDTO.getPurpose().getValue()), "purpose"));
        factors.setHabitat(optHabitat.get());
        factors.setDateCreated(LocalDate.now());
        saveAnthropologicalFactors(factors);
        return factors;
    }

    public void saveAnthropologicalFactors(AnthropologicalFactors factors){
        anthropologicalFactorRepository.saveAndFlush(factors);
    }

    public RecommendationDTO getRecommendations(long id){

        RecommendationDTO recommendationDTO = new RecommendationDTO();
        Optional<AnthropologicalFactors> anthropologicalFactorsOpt = anthropologicalFactorRepository.findById(id);
        if(!anthropologicalFactorsOpt.isPresent()) throw new InvalidArgumentException("Anthropological factors not found!");
        AnthropologicalFactors anthropologicalFactors = anthropologicalFactorsOpt.get();
        recommendationDTO.setSuccessRate(0);
        recommendationDTO.setSuccessMessage("");

        List<Option> options = new ArrayList<>();
        options.add(new Option(anthropologicalFactors.getShrubbery().getLevel()+"", anthropologicalFactors.getShrubbery().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getDistanceToNeighbourhoodPopulation().getLevel()+"", anthropologicalFactors.getDistanceToNeighbourhoodPopulation().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getDisturbance().getLevel()+"", anthropologicalFactors.getDisturbance().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getRoads().getLevel()+"", anthropologicalFactors.getRoads().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getAgriculture().getLevel()+"", anthropologicalFactors.getAgriculture().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getGrazing().getLevel()+"", anthropologicalFactors.getGrazing().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getGrassRemoving().getLevel()+"", anthropologicalFactors.getGrassRemoving().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getPredators().getLevel()+"", anthropologicalFactors.getPredators().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getProtection().getLevel()+"", anthropologicalFactors.getProtection().getRecommendation(), "a"));
        options.add(new Option(anthropologicalFactors.getPurpose().getLevel()+"", anthropologicalFactors.getPurpose().getRecommendation(), "a"));

        recommendationDTO.setRecommendations(options);
        KieSession kieSession = kieContainer.newKieSession();
        recommendationDTO.getRecommendations().forEach(kieSession::insert);
        kieSession.fireAllRules();
        QueryResults results =
                kieSession.getQueryResults( "doesHaveRecommendations", "0", "Nije potrebno preduzeti nikakve akcije." );

        if (results.size() != 10) recommendationDTO.setSuccessRate(-1);
        kieSession.insert(recommendationDTO);
        kieSession.fireAllRules();
        kieSession.dispose();
        recommendationDTO.getRecommendations().removeIf(o -> o.getLabel().equals("Nije potrebno preduzeti nikakve akcije."));
        log.info(recommendationDTO.toString());
        return recommendationDTO;

    }

    public List<AntropologicalFactorDTO> getFactorsForHabitat (long habitatId){
        List<AntropologicalFactorDTO> anthropologicalFactorsDOS = new ArrayList<>();
        anthropologicalFactorRepository.findAllByHabitatId(habitatId).forEach(anthropologicalFactor -> {
            AntropologicalFactorDTO op = new AntropologicalFactorDTO(anthropologicalFactor);
            log.info(op.toString());
            anthropologicalFactorsDOS.add(op);
        });
        return anthropologicalFactorsDOS;
    }

}
