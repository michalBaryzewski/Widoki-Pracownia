package pl.widokipracownia.widokipracownia.mapper

import org.mapstruct.factory.Mappers
import pl.widokipracownia.widokipracownia.entity.Project
import pl.widokipracownia.widokipracownia.web.dto.ProjectDto
import spock.lang.Shared
import spock.lang.Specification

class ProjectSpec extends Specification implements MapperUtils {

    @Shared
    ProjectMapper mapper = Mappers.getMapper(ProjectMapper.class)
    @Shared
    Project entity = new Project(1, "address", "voivodeship", 2.0, null, null)
    @Shared
    ProjectDto dto = new ProjectDto("adderss", "voivodeship", 1.0)

    def "should map entity to dto"() {
        when:
        ProjectDto projectDto = mapper.projectEntityToDto(entity)
        then:
        compareProjectEntityToDto(entity, projectDto)
    }

    def "should map dto to entity"() {
        when:
        Project project = mapper.dtoToProjectEntity(dto)
        then:
        compareProjectEntityToDto(project, dto)
    }
}
