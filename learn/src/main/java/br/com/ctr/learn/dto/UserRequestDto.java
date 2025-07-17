package br.com.ctr.learn.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto implements Serializable {

    @NotBlank(message = "O nome é obrigatório")
    private String username;

    @NotBlank(message = "O sobrenome é obrigatório")
    private String surname;

    @NotNull(message = "A idade é obrigatória")
    private Integer age;

    private AddressRequestDto addressDto;

    private ProfessionRequestDto professionDto;
}
