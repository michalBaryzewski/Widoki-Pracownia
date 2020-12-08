package pl.widokipracownia.widokipracownia.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.entity.Project;
import pl.widokipracownia.widokipracownia.mapper.ProjectMapper;
import pl.widokipracownia.widokipracownia.repository.ProjectRepository;
import pl.widokipracownia.widokipracownia.web.model.ProjectDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public Project save(ProjectDto projectDto, MultipartFile file) {
        Project project = projectMapper.dtoToProjectEntity(projectDto);
        projectRepository.save(project);
        log.info("Created plant: " + project.toString());
        return project;
    }

    @Override
    public Project findById(Integer id) {
        if (projectRepository.findById(id).isPresent()) {
            return projectRepository.findById(id).get();
        } else {
            throw new RuntimeException("Not found!");
        }
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
