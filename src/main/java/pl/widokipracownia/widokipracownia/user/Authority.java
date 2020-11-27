package pl.widokipracownia.widokipracownia.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private AuthorityType name;

}
