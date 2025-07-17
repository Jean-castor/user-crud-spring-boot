package br.com.ctr.learn.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionRequestDto implements Serializable {

    @NotBlank(message = "O nome da profissão é obrigatório")
    private String professionName;

    @NotBlank(message = "O nível da profissão é obrigatório")
    private String professionLevel;

    @NotNull(message = "O salário é obrigatório")
    @DecimalMin(value = "1518,00", message = "O salário deve ser no mínimo R$1518,00")
    private Integer salary;

}
