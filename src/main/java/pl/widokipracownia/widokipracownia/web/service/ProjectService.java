package pl.widokipracownia.widokipracownia.web.service;

import org.springframework.stereotype.Service;
import pl.widokipracownia.widokipracownia.entity.Project;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {

    Project save(Project project);
    Optional<Project> findById(Integer id);
    List<Project> findAll();
    void delete(Project project);
}
