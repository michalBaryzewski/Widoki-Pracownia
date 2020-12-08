package pl.widokipracownia.widokipracownia.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.mapper.FileMapper;
import pl.widokipracownia.widokipracownia.mapper.ProjectMapper;
import pl.widokipracownia.widokipracownia.mapper.UserMapper;
import pl.widokipracownia.widokipracownia.user.service.UserManager;
import pl.widokipracownia.widokipracownia.web.dto.AppUserDto;
import pl.widokipracownia.widokipracownia.web.dto.FileWrapper;
import pl.widokipracownia.widokipracownia.web.dto.ProjectDto;
import pl.widokipracownia.widokipracownia.web.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor
@Api(value = "admin")
public class AdminController {

    private final ProjectService projectService;
    private final UserManager userManager;

    private final UserMapper userMapper;
    private final ProjectMapper projectMapper;
    private final FileMapper fileMapper;

    @ApiOperation(value = "View a list of users", response = AppUserDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received list"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @GetMapping("/user")
    public List<AppUserDto> getAllUsers() {
        return userMapper.entityListToDtoList(userManager.findAll());
    }

    @ApiOperation(value = "Endpoint allowing to find a user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received User"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/user/{id}")
    public AppUserDto findUserById(@PathVariable Integer id) {
        return userMapper.userEntityToDto(userManager.findById(id));
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
        return userMapper.userEntityToDto(userManager.createUser(userDto, password, authority));
    }

    @ApiOperation(value = "View a list of projects", response = ProjectDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received list"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @GetMapping("/project")
    public List <ProjectDto> getAllProjects() {
        return projectMapper.entityListToDtoList(projectService.findAll());
    }

    @ApiOperation(value = "Endpoint allowing to find a project by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received User"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "Not found")})
    @GetMapping("/project/{id}")
    public ProjectDto getProjectById(@PathVariable Integer id) {
        return projectMapper.projectEntityToDto(projectService.findById(id));
    }

    @ApiOperation(value = "Endpoint allowing to create a project")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created Project"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "No authorization"),
            @ApiResponse(code = 403, message = "No permission to access here"),
            @ApiResponse(code = 404, message = "Not found")})
    @PostMapping(value = "/project")
    public ProjectDto createProject(@RequestPart("file") MultipartFile file, @RequestParam String address, @RequestParam String voivodeship, @RequestParam Double projectArea){
        FileWrapper wrapper = FileWrapper.wrapper(file);
        ProjectDto projectDto = new ProjectDto(address, voivodeship, projectArea, fileMapper.wrapperToEntity(wrapper));
        projectService.save(projectDto, file);
        return projectDto;
    }

}
