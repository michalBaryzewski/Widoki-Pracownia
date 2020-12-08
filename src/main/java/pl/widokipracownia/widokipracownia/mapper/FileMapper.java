package pl.widokipracownia.widokipracownia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.widokipracownia.widokipracownia.entity.File;
import pl.widokipracownia.widokipracownia.web.model.FileWrapper;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FileMapper {

    File wrapperToEntity(FileWrapper fileWrapper);
    FileWrapper entityToWrapper(File file);
}
