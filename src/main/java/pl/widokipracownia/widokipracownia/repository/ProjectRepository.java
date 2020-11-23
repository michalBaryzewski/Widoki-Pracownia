package pl.widokipracownia.widokipracownia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.widokipracownia.widokipracownia.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
