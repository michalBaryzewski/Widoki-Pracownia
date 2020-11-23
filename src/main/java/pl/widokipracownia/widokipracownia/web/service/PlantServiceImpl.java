package pl.widokipracownia.widokipracownia.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.widokipracownia.widokipracownia.entity.Plant;
import pl.widokipracownia.widokipracownia.repository.PlantRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Override
    public Plant save(Plant plant) {
        log.info("Created plant: " + plant.toString());
        return plantRepository.save(plant);
    }

    @Override
    public Optional<Plant> findById(Integer id) {
        log.info("Found the plant with id: " + id);
        return plantRepository.findById(id);
    }

    @Override
    public List<Plant> findAll() {
        log.info("All plants listed");
        return plantRepository.findAll();
    }

    @Override
    public void delete(Plant plant) {
        log.info("Deleted: " + plant.toString());
        plantRepository.delete(plant);
    }


}
