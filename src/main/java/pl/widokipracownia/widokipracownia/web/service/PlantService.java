package pl.widokipracownia.widokipracownia.web.service;

import pl.widokipracownia.widokipracownia.entity.Plant;

import java.util.List;

public interface PlantService {

    Plant save(Plant plant);
    Plant findById(Integer id);
    List<Plant> findAll();
    void delete(Plant plant);
}
