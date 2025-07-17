package br.com.ctr.learn.repository;

import br.com.ctr.learn.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldPersistUser() {
        UserEntity user = new UserEntity();
        user.setUsername("username");
        user.setSurname("surname");
        user.setAge(20);

        userRepository.save(user);

        assertNotNull(user.getUserId(), "Id gerado");
        assertTrue(userRepository.findById(user.getUserId()).isPresent(), "Id inserido");

        UserEntity foudnUser = userRepository.findById(user.getUserId()).get();
        assertEquals(user.getUserId(), foudnUser.getUserId());
    }

}