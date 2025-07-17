package br.com.ctr.learn.service;

import br.com.ctr.learn.dto.UserRequestDto;
import br.com.ctr.learn.dto.UserResponseDto;
import br.com.ctr.learn.entity.UserEntity;
import br.com.ctr.learn.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_shouldReturnUserResponseDto() {
        String userName = "string";
        String surName = "string";
        int age = 1;

        // DTO de entrada
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername(userName);
        userRequestDto.setSurname(surName);
        userRequestDto.setAge(age);

        // Simula a entidade criada no mapper (poderia usar spy em UserMapper para teste integral)
        UserEntity savedUser = new UserEntity();
        savedUser.setUsername(userName);
        savedUser.setSurname(surName);
        savedUser.setAge(age);

        when(userRepository.save(savedUser)).thenReturn(savedUser);

        UserResponseDto userResponseDto = userService.createUser(userRequestDto);

        // Assert
        assertNotNull(userResponseDto);
        assertEquals(userName, userResponseDto.getUsername());
        assertEquals(surName, userResponseDto.getSurname());
        assertEquals(age, userResponseDto.getAge());

        // Verifica se o save foi chamado uma vez
        verify(userRepository, times(1)).save(ArgumentMatchers.any(UserEntity.class));

    }

    @Test
    void createUser_withNullValues(){
        // DTO de entrada com valores nulos
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername(null);
        userRequestDto.setSurname(null);
        userRequestDto.setAge(null);

        // Simula a entidade criada no mapper
        UserEntity savedUser = new UserEntity();
        savedUser.setUsername(null);
        savedUser.setSurname(null);
        savedUser.setAge(null);

        // Mock do repositório
        when(userRepository.save(ArgumentMatchers.any(UserEntity.class))).thenReturn(savedUser);

        UserResponseDto userResponseDto = userService.createUser(userRequestDto);

        assertNotNull(userResponseDto);
        verify(userRepository, times(1)).save(ArgumentMatchers.any(UserEntity.class));

    }

}















