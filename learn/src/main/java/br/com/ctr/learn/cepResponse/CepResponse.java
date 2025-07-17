package br.com.ctr.learn.cepResponse;

import lombok.Data;
@Data
public class CepResponse {
    private String zipCode;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

}
