package pl.widokipracownia.widokipracownia.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.widokipracownia.widokipracownia.entity.Plant;
import pl.widokipracownia.widokipracownia.entity.PlantDetails;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    private final List<Plant> list = new ArrayList<>();

    @GetMapping("/test")
    public Plant test() {
        PlantDetails plantDetails = new PlantDetails();
        plantDetails.setPlantId(1);
        plantDetails.setPlantDescription("desc");
        plantDetails.setAdditionalDetails("addDesc");
        Plant plant = new Plant();
        plant.setLatinName("latinName");
        plant.setPlantDetails(plantDetails);
        list.add(plant);
        log.info(plant.toString());
        return plant;
    }

    @PostMapping("/project")
    public Plant createPlant() {
        PlantDetails plantDetails = new PlantDetails();
        plantDetails.setPlantId(1);
        plantDetails.setPlantDescription("desc");
        plantDetails.setAdditionalDetails("addDesc");
        Plant plant = new Plant();
        plant.setLatinName("latinName");
        plant.setPlantDetails(plantDetails);
        list.add(plant);
        return plant;
    }

    @GetMapping("/2")
    public List<Plant> getAll() {
        return list;
    }
}
