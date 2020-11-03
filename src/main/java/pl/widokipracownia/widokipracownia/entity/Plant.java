package pl.widokipracownia.widokipracownia.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Plant {

    @Id
    @GeneratedValue
    private Long id;
    private int plantId;
    private String latinName;
    private String polishName;
    private String variety;
    private String startOfBlooming;
    private String endOfBlooming;
    private String monthOfFertilization;
    private String typeOfFertilizer;
    private String monthOfCutting;
    private String cuttingType;
    private PlantDetails plantDetails;
}
