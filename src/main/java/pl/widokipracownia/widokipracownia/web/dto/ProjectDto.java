package pl.widokipracownia.widokipracownia.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.widokipracownia.widokipracownia.entity.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private String address;
    private String voivodeship;
    private Double projectArea;
    private File file;

}
