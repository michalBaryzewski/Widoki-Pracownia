package pl.widokipracownia.widokipracownia.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="file")
@Data
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    @Lob
    private byte[] data;

    public File(String name, String type, byte[] data){
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
