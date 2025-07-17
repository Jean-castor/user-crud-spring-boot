package br.com.ctr.learn.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResponseDto implements Serializable {

    private UUID addressId;

    private String city;

    private String state;

    private String street;

    private Integer number;

    public AddressResponseDto(long id, String city, String state, String street, Integer number) {
        this.addressId = UUID.randomUUID();
        this.city = city;
        this.state = state;
        this.street = street;
        this.number = number;
    }
}
