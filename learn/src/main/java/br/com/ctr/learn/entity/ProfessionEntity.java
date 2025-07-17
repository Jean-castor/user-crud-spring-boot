package br.com.ctr.learn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_user_profession")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID professionId;

    @NotBlank
    private String professionName;

    @NotBlank
    private String professionLevel;

    @NotNull
    private Integer salary;

    @JsonIgnore
    @OneToOne(mappedBy = "profession")
    private UserEntity users;

}
