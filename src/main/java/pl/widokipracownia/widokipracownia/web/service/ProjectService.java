package pl.widokipracownia.widokipracownia.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.entity.Project;
import pl.widokipracownia.widokipracownia.web.model.ProjectDto;

import java.util.List;

@Service
public interface ProjectService {

    Project save(ProjectDto projectDto, MultipartFile file);
    Project findById(Integer id);
    List<Project> findAll();
    void delete(Project project);
}
