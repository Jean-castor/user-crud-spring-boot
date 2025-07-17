package br.com.ctr.learn.service;

import br.com.ctr.learn.entity.AddressEntity;
import br.com.ctr.learn.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(name = "/addresses")
@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    public List<AddressEntity> getAllAddresses() {
        return addressRepository.findAll();
    }
}
