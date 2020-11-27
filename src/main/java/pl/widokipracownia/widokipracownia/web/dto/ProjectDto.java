package pl.widokipracownia.widokipracownia.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private String address;
    private String voivodeship;
    private Double projectArea;

}
