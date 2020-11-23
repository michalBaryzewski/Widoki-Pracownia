package pl.widokipracownia.widokipracownia.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String latinName;
    private String polishName;
    private String variety;
    private String startOfBlooming;
    private String endOfBlooming;
    private String monthOfFertilization;
    private String typeOfFertilizer;
    private String monthOfCutting;
    private String cuttingType;
    private String plantDescription;
}
