package br.com.ctr.learn.controller;

import br.com.ctr.learn.dto.UserRequestDto;
import br.com.ctr.learn.dto.UserResponseDto;
import br.com.ctr.learn.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<UserResponseDto>  getUsers(
            @RequestParam(defaultValue = "0",required = false) int page,
            @RequestParam(defaultValue = "6",required = false) int size){
        Pageable pageable = PageRequest.of(page, size);
        System.out.println("Página:" + " " + page + "\nItens:" + " " + size);
        return userService.getAllUsers(pageable);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        var user = userService.createUser(userRequestDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById( @PathVariable UUID id) {
        var user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleUserById( @PathVariable UUID id) {
        var user = userService.deleUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable UUID id, @Valid @RequestBody UserRequestDto userRequestDto) {
        var user = userService.updateUser(id, userRequestDto);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}




















