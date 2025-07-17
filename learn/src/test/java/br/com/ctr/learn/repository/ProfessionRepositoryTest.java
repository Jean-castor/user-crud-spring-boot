package br.com.ctr.learn.repository;

import br.com.ctr.learn.entity.ProfessionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProfessionRepositoryTest {

    @Autowired
    private ProfessionRepository professionRepository;

    @Test
    void shouldPersistProfession() {
        ProfessionEntity profession = new ProfessionEntity();
        profession.setProfessionName("profession");
        profession.setProfessionLevel("level");
        profession.setSalary(1);

        professionRepository.save(profession);

        assertNotNull(profession.getProfessionId(), "Id gerado");
        assertTrue(professionRepository.findById(profession.getProfessionId()).isPresent(), "Id inserido");

        ProfessionEntity foundProfession = professionRepository.findById(profession.getProfessionId()).get();
        assertEquals("profession", foundProfession.getProfessionName());
    }

}