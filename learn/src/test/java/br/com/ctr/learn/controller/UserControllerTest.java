package br.com.ctr.learn.controller;

import br.com.ctr.learn.dto.AddressRequestDto;
import br.com.ctr.learn.dto.ProfessionRequestDto;
import br.com.ctr.learn.dto.UserRequestDto;
import br.com.ctr.learn.dto.UserResponseDto;
import br.com.ctr.learn.repository.ProfessionRepository;
import br.com.ctr.learn.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserControllerTest {

    // Classe de dependência
    @Mock
    private UserService userService;

    // Classe a ser testada
    @InjectMocks
    private UserController userController;

    @Test
    void  createUser_returnsCreatedUser() {
        var request = getUserRequestDto();

        // Saída esperada:
        var response = new UserResponseDto(1L, "Jony", "Santos", 22);

        when(userService.createUser(request)).thenReturn(response);

        ResponseEntity<UserResponseDto> responseEntity = userController.createUser(request);

        // then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(response, responseEntity.getBody());
        verify(userService).createUser(request);

    }

    private static UserRequestDto getUserRequestDto() {
        var request = new UserRequestDto();
        request.setUsername("John");
        request.setSurname("Doe");
        request.setAge(25);

        var addressDto = new AddressRequestDto();
        // Preenchendo a classe AddressRequestDto com dados;
        addressDto.setState("SP");
        addressDto.setCity("Guarulhos");
        addressDto.setStreet("Rua X");
        addressDto.setNumber(123);
        request.setAddressDto(addressDto);

        var professionDto = new ProfessionRequestDto();
        professionDto.setProfessionName("Dev");
        professionDto.setProfessionLevel("JUNIOR");
        request.setProfessionDto(professionDto);
        return request;
    }

}








