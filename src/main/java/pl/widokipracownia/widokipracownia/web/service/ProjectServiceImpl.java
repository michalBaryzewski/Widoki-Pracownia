package pl.widokipracownia.widokipracownia.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.entity.File;
import pl.widokipracownia.widokipracownia.entity.Plant;
import pl.widokipracownia.widokipracownia.entity.Project;
import pl.widokipracownia.widokipracownia.mapper.ProjectMapper;
import pl.widokipracownia.widokipracownia.repository.ProjectRepository;
import pl.widokipracownia.widokipracownia.web.dto.ProjectDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final FileService fileService;
    private final ProjectMapper projectMapper;

    @Override
    public Project save(ProjectDto projectDto, MultipartFile file) {
        try {
            fileService.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Project project = projectMapper.dtoToProjectEntity(projectDto);
        projectRepository.save(project);
        log.info("Created plant: " + project.toString());
        return project;
    }

    @Override
    public Optional<Project> findById(Integer id) {
        log.info("Found the project with id: " + id);
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> findAll() {
        log.info("All projects listed");
        return projectRepository.findAll();
    }

    @Override
    public void delete(Project project) {
        log.info("Deleted: " + project.toString());
        projectRepository.delete(project);
    }
}
