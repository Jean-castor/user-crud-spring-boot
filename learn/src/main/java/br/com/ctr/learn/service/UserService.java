package br.com.ctr.learn.service;

import br.com.ctr.learn.controller.UserMapper;
import br.com.ctr.learn.dto.UserRequestDto;
import br.com.ctr.learn.dto.UserResponseDto;
import br.com.ctr.learn.entity.UserEntity;
import br.com.ctr.learn.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = UserMapper.toEntity(userRequestDto);
        userRepository.save(userEntity);
        return UserMapper.toResponseDto(userEntity);
    }

    public Page<UserResponseDto> getAllUsers(Pageable pageable) {
    Page<UserEntity> usersPage = userRepository.findAll(pageable);
    
    // Calcular a posição de cada usuário
    List<UserResponseDto> usersWithPosition = new ArrayList<>();
    int baseIndex = pageable.getPageNumber() * pageable.getPageSize();
    
    List<UserEntity> users = usersPage.getContent();
    for (int i = 0; i < users.size(); i++) {
        UserResponseDto dto = UserMapper.toResponseDto(users.get(i));
        dto.setPosition(baseIndex + i + 1); // Posição global começando de 1
        usersWithPosition.add(dto);
    }
    
    return new PageImpl<>(usersWithPosition, pageable, usersPage.getTotalElements());
}

    public UserResponseDto getUserById(UUID id) {
        return UserMapper.toResponseDto(userRepository.findById(id).orElse(null));
    }

    @Transactional
    public boolean deleUserById(UUID id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public UserEntity updateUser( UUID id, UserRequestDto userRequestDto) {
        UserEntity user = userRepository.findById(id).orElseThrow(null);
        UserEntity userEntity = UserMapper.upadateEntityFromDto(userRequestDto, user);
        userRepository.save(user);
        return userEntity;
    }

}