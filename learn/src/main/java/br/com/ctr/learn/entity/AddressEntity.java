package br.com.ctr.learn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user_address")
@Getter
@Setter
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID addressId;

    @NotBlank
    @Column(name = "user_address")
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

//    @NotNull
    private Integer number;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<UserEntity> users;
}
