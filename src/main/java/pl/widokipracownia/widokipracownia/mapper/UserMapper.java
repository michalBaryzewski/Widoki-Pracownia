package pl.widokipracownia.widokipracownia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.widokipracownia.widokipracownia.user.AppUser;
import pl.widokipracownia.widokipracownia.web.model.AppUserDto;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    AppUserDto userEntityToDto(AppUser appUser);

    AppUser dtoToUserEntity(AppUserDto appUserDto);

    List<AppUserDto> entityListToDtoList(List<AppUser> appUserList);
}
