package pl.widokipracownia.widokipracownia.mapper

trait MapperUtils {

    void compareAppUserEntityToDto(appUser, dto) {
        assert appUser.email == dto.email
        assert appUser.firstName == dto.firstName
        assert appUser.lastName == dto.lastName
        assert appUser.username == dto.username
    }

}