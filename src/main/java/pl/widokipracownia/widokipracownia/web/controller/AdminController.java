package pl.widokipracownia.widokipracownia.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.widokipracownia.widokipracownia.entity.Plant;
import pl.widokipracownia.widokipracownia.mapper.UserMapper;
import pl.widokipracownia.widokipracownia.repository.UserRepository;
import pl.widokipracownia.widokipracownia.user.AppUser;
import pl.widokipracownia.widokipracownia.user.service.UserManager;
import pl.widokipracownia.widokipracownia.web.dto.AppUserDto;
import pl.widokipracownia.widokipracownia.web.service.PlantService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor
@Api(value = "admin")
public class AdminController {

    private final PlantService plantService;
    private final UserManager userManager;

    UserMapper userMapper;

    @ApiOperation(value = "Endpoint allowing to create a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created User"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "Not found")})
    @PostMapping("/user")
    public AppUserDto createUser() {
        AppUser user = new AppUser();
        user.setCreated(LocalDateTime.now());
        userManager.save(user);
        return userMapper.userEntityToDto(user);
    }

    @ApiOperation(value = "Endpoint allowing to find a user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created User"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/user/{id}")
    public AppUser findUserById(@PathVariable Integer id) {
        AppUser user;
        if (userManager.findById(id).isPresent()) {
            user = userManager.findById(id).get();
        } else {
          throw new RuntimeException("Not found!");
        }
//        AppUserDto user2 = userMapper.userEntityToDto(user);
//        log.info(user2.toString());
        return user;
    }

    @PostMapping("/plant")
    public Plant addPlant() {
        return new Plant();
    }
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
//        service.save(plant);
        return plant;
    }

//    @GetMapping("/2")
//    public List<Plant> getAll() {
//        return list;
//    }
}
