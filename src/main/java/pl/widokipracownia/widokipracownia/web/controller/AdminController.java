package pl.widokipracownia.widokipracownia.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.widokipracownia.widokipracownia.entity.Plant;
import pl.widokipracownia.widokipracownia.user.AppUser;
import pl.widokipracownia.widokipracownia.web.service.PlantService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final List<Plant> list = new ArrayList<>();
    private final PlantService service;

    @PostMapping("/user")
    public AppUser createUser() {
        return new AppUser();
    }

//
//    @GetMapping("/test")
//    public Plant test() {
//        PlantDetails plantDetails = new PlantDetails();
//        plantDetails.setPlantId(1);
//        plantDetails.setPlantDescription("desc");
//        plantDetails.setAdditionalDetails("addDesc");
//        Plant plant = new Plant();
//        plant.setLatinName("latinName");
//        plant.setPlantDetails(plantDetails);
//        list.add(plant);
//        log.info(plant.toString());
//        return plant;
//    }
//
    @PostMapping("/project")
    public Plant createPlant() {
//        PlantDetails plantDetails = new PlantDetails();
//        plantDetails.setPlantId(1);
//        plantDetails.setPlantDescription("desc");
//        plantDetails.setAdditionalDetails("addDesc");
        Plant plant = new Plant();
        plant.setPolishName("Widzisz Robert?");
        plant.setLatinName("Aplikacja dodaje");
        plant.setVariety("Nowy rekord do bazy");
//        plant.setPlantDetails(plantDetails);
        service.save(plant);
        return plant;
    }

    @GetMapping("/2")
    public List<Plant> getAll() {
        return list;
    }
}
