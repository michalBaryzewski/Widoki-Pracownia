package pl.widokipracownia.widokipracownia.web.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.widokipracownia.widokipracownia.entity.Plant;
import pl.widokipracownia.widokipracownia.repository.PlantRepository;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Override
    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }
}
