package pl.widokipracownia.widokipracownia.web.service;

import pl.widokipracownia.widokipracownia.entity.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantService {

    Plant save(Plant plant);
    Optional<Plant> findById(Integer id);
    List<Plant> findAll();
    void delete(Plant plant);
}
