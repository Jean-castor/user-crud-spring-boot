package br.com.ctr.learn.dto;

import br.com.ctr.learn.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto implements Serializable {

    private UUID userId;

    private String username;

    private String surname;

    private Integer age;

    private AddressResponseDto addressDto;

    private ProfessionResponseDto professionDto;

    public UserResponseDto(long id, String name, String surname, int age) {
        this.userId = UUID.randomUUID();
        this.username = name;
        this.surname = surname;
        this.age = age;
    }

    public void setPosition(int i) {
    }
}
