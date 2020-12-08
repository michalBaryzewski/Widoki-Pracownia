package pl.widokipracownia.widokipracownia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.entity.File;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FileMapper {

    File multipartToFile(MultipartFile file);
}
