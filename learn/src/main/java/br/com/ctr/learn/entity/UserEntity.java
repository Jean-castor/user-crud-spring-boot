package br.com.ctr.learn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @NotBlank
    @Column(name = "name")
    private String username;

    @NotBlank
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "age")
    private Integer age;

    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private AddressEntity address;
    
    @JoinColumn(name = "profession_id", referencedColumnName = "professionId")
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ProfessionEntity profession;
}
