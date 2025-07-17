package br.com.ctr.learn.repository;

import br.com.ctr.learn.entity.AddressEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void shouldPersistAddress() {
        AddressEntity address = new AddressEntity();
        address.setStreet("street");
        address.setCity("city");
        address.setState("state");
        address.setNumber(1);

        addressRepository.save(address);

        assertNotNull(address.getAddressId(), "Id gerado");
        assertTrue(addressRepository.findById(address.getAddressId()).isPresent(), "Id inserido");

        AddressEntity foundAddress = addressRepository.findById(address.getAddressId()).get();
        assertNotNull(foundAddress.getAddressId(), "Id gerado");
        assertEquals(address.getAddressId(), foundAddress.getAddressId());

    }
}