package pl.widokipracownia.widokipracownia.entity;

import lombok.Data;

@Data
public class PlantDetails {
    private int plantId;
    private String plantDescription;
    private String additionalDetails;
}