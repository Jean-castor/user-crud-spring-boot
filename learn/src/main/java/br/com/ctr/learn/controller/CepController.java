package br.com.ctr.learn.controller;

import br.com.ctr.learn.cepResponse.CepResponse;
import br.com.ctr.learn.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zipCode")
public class CepController {
    @Autowired
    private CepService cepService;

    @GetMapping("/{zipCode}")
    public CepResponse getCep(@PathVariable("zipCode") String zipCode) {
        return cepService.checkZipCode(zipCode);
    }
}
