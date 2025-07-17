package br.com.ctr.learn.service;

import br.com.ctr.learn.cepResponse.CepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    @Autowired
    private RestTemplate restTemplate;

    public CepResponse checkZipCode(String zipCode) {
        String url = "https://viacep.com.br/ws/" + zipCode + "/json/";
        ResponseEntity<CepResponse> response = restTemplate.getForEntity(url, CepResponse.class);
        return response.getBody();
    }
}


