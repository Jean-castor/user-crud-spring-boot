package br.com.ctr.learn.service;

import br.com.ctr.learn.entity.ProfessionEntity;
import br.com.ctr.learn.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionService {

    @Autowired
    ProfessionRepository professionRepository;

    public List<ProfessionEntity> getAllProfessions() {
        return professionRepository.findAll().stream().toList();
    }
}
