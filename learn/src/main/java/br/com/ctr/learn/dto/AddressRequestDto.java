package br.com.ctr.learn.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto implements Serializable {

    @NotBlank(message = "O nome ou número da rua é obrigatório")
    private String street;

    @NotBlank(message = "O da cidade é obrigatório")
    private String city;

    @NotBlank(message = "O nome do estado é obrigatório")
    private String state;

    @NotNull(message = "O número da casa obrigatório")
    private Integer number;

}
