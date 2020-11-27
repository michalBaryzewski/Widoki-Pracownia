package pl.widokipracownia.widokipracownia.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="file")
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final String name;
    private final String type;
    @Lob
    private final byte[] data;
}
