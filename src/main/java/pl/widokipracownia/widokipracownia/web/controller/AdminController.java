package pl.widokipracownia.widokipracownia.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.entity.File;
import pl.widokipracownia.widokipracownia.entity.Plant;
import pl.widokipracownia.widokipracownia.entity.Project;
import pl.widokipracownia.widokipracownia.mapper.ProjectMapper;
import pl.widokipracownia.widokipracownia.mapper.UserMapper;
import pl.widokipracownia.widokipracownia.user.AppUser;
import pl.widokipracownia.widokipracownia.user.Authority;
import pl.widokipracownia.widokipracownia.user.service.UserManager;
import pl.widokipracownia.widokipracownia.web.dto.AppUserDto;
import pl.widokipracownia.widokipracownia.web.dto.ProjectDto;
import pl.widokipracownia.widokipracownia.web.service.FileService;
import pl.widokipracownia.widokipracownia.web.service.PlantService;
import pl.widokipracownia.widokipracownia.web.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor
@Api(value = "admin")
public class AdminController {

    private final PlantService plantService;
    private final ProjectService projectService;
    private final FileService fileService;

    private final UserManager userManager;

    private final UserMapper userMapper;
    private final ProjectMapper projectMapper;

    @ApiOperation(value = "View a list of users", response = AppUserDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received list"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @GetMapping("/user")
    public List<AppUserDto> getAllUsers() {
        List<AppUserDto> list = new ArrayList<>();
        for (AppUser user : userManager.findAll()) {
            list.add(userMapper.userEntityToDto(user));
        }
        return list;
    }

    @ApiOperation(value = "Endpoint allowing to find a user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created User"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/user/{id}")
    public AppUserDto findUserById(@PathVariable Integer id) {
        AppUser user;
        if (userManager.findById(id).isPresent()) {
            user = userManager.findById(id).get();
        } else {
          throw new RuntimeException("Not found!");
        }
        return userMapper.userEntityToDto(user);
    }

    @ApiOperation(value = "Endpoint allowing to create a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created User"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "Not found")})
    @PostMapping("/user")
    public AppUserDto createUser(@RequestBody AppUserDto userDto, @RequestParam String password, @RequestParam String authority) {
        AppUser user = userMapper.dtoToUserEntity(userDto);
        user.setPassword(password);
        user.setCreated(LocalDateTime.now());
        userManager.setAuthority(authority, user);
        userManager.save(user);
        return userMapper.userEntityToDto(user);
    }

    @GetMapping("/project")
    public List <ProjectDto> getAllProjects() {
        List<ProjectDto> list = new ArrayList<>();
        for (Project project : projectService.findAll()) {
            list.add(projectMapper.projectEntityToDto(project));
        }
        return list;
    }

    @GetMapping("/project/{id}")
    public ProjectDto getProjectById(@PathVariable Integer id) {
        Project project;
        if (projectService.findById(id).isPresent()){
            project = projectService.findById(id).get();
        } else {
            throw new RuntimeException("Not found!");
        }
        return projectMapper.projectEntityToDto(project);
    }

    @PostMapping("/project")
    public ProjectDto createProject(@RequestBody ProjectDto projectDto, @RequestParam MultipartFile file) throws IOException {
        File upload = fileService.save(file);
        //todo create project with file in db
        Project project = projectMapper.dtoToProjectEntity(projectDto);
        project.setFile(upload);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        projectService.save(project);
        return projectDto;
    }

}
