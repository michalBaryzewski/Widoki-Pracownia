package pl.widokipracownia.widokipracownia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.widokipracownia.widokipracownia.entity.Project;
import pl.widokipracownia.widokipracownia.web.model.ProjectDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {

    ProjectDto projectEntityToDto(Project project);

    Project dtoToProjectEntity(ProjectDto projectDto);

    List<ProjectDto> entityListToDtoList(List<Project> projects);
}
