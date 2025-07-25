package br.com.ctr.learn.controller;

import br.com.ctr.learn.dto.*;
import br.com.ctr.learn.entity.AddressEntity;
import br.com.ctr.learn.entity.ProfessionEntity;
import br.com.ctr.learn.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserResponseDto toResponseDto(UserEntity userEntity) {
        if(userEntity == null) return null;

        var userResponseDto = new UserResponseDto();

        /*
            PAssando as infos de utilizador para DTO
        */
        userResponseDto.setUserId(userEntity.getUserId());
        userResponseDto.setUsername(userEntity.getUsername());
        userResponseDto.setSurname(userEntity.getSurname());
        userResponseDto.setAge(userEntity.getAge());


        if(userEntity.getAddress() != null) {
            userResponseDto.setAddressDto(toDto(userEntity.getAddress()));
        }

        if(userEntity.getProfession() != null) {
            userResponseDto.setProfessionDto(professionToDto(userEntity.getProfession()));
        }

        return userResponseDto;
    }

    public static UserEntity toEntity(UserRequestDto userRequestDto) {
        if (userRequestDto == null) return null;

        var entity = new UserEntity();
        entity.setUsername(userRequestDto.getUsername());
        entity.setSurname(userRequestDto.getSurname());
        entity.setAge(userRequestDto.getAge());

        if (userRequestDto.getAddressDto() != null) {
            entity.setAddress(toAddressEntity(userRequestDto.getAddressDto()));
        }

        if(userRequestDto.getProfessionDto() != null){
            entity.setProfession(toEntityProfession(userRequestDto.getProfessionDto()));
        }
        return entity;
    }

    public static List<UserResponseDto> toDtoList(List<UserEntity> entities) {
        return entities.stream()
                .map(UserMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public static AddressResponseDto toDto(AddressEntity addressEntity) {
        if (addressEntity == null) return null;
        var addresResponseDto = new AddressResponseDto();
        addresResponseDto.setAddressId(addressEntity.getAddressId());
        addresResponseDto.setCity(addressEntity.getCity());
        addresResponseDto.setState(addressEntity.getState());
        addresResponseDto.setStreet(addressEntity.getStreet());
        addresResponseDto.setNumber(addressEntity.getNumber());
        addresResponseDto.setZipCode(addressEntity.getZipCode());

        return addresResponseDto;
    }

    public static AddressEntity toAddressEntity(AddressRequestDto addressRequestDto) {
        if (addressRequestDto == null) return null;

        AddressEntity entity = new AddressEntity();
        entity.setCity(addressRequestDto.getCity());
        entity.setState(addressRequestDto.getState());
        entity.setNumber(addressRequestDto.getNumber());
        entity.setStreet(addressRequestDto.getStreet());
        entity.setCity(addressRequestDto.getCity());

        return entity;
    }

    public static ProfessionResponseDto professionToDto(ProfessionEntity professionEntity) {
        if (professionEntity == null) return null;

        var professionResponse = new ProfessionResponseDto();
        professionResponse.setProfessionId(professionEntity.getProfessionId());
        professionResponse.setProfessionName(professionEntity.getProfessionName());
        professionResponse.setProfessionLevel(professionEntity.getProfessionLevel());
        professionResponse.setSalary(professionEntity.getSalary());

        return professionResponse;
    }

    public static ProfessionEntity toEntityProfession(ProfessionRequestDto professionRequestDto) {
        if (professionRequestDto == null) return null;

        var professionEntity = new ProfessionEntity();
        professionEntity.setProfessionName(professionRequestDto.getProfessionName()); // Convertendo name do DTO para profession da entidade
        professionEntity.setProfessionLevel(professionRequestDto.getProfessionLevel());
        professionEntity.setSalary(professionRequestDto.getSalary());

        return professionEntity;
    }

    public static UserEntity upadateEntityFromDto(UserRequestDto userRequestDto, UserEntity userEntity) {
        if(userRequestDto == null || userEntity == null) return null;

        if(userRequestDto.getUsername() != null){
            userEntity.setUsername(userRequestDto.getUsername());
        }

        if(userRequestDto.getSurname() != null){
            userEntity.setSurname(userRequestDto.getSurname());
        }

        if(userRequestDto.getAge() != null){
            userEntity.setAge(userRequestDto.getAge());
        }

        if (userRequestDto.getAddressDto() != null) {
            userEntity.setAddress(toAddressEntity(userRequestDto.getAddressDto()));
        }

        if(userRequestDto.getProfessionDto() != null){
            userEntity.setProfession(toEntityProfession(userRequestDto.getProfessionDto()));
        }

        return userEntity;
    }

}
