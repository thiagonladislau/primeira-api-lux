package com.ladislau.dev.primeira_api_lux;

import com.ladislau.dev.primeira_api_lux.service.SaudacaoService; //Importar o Serviço
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// 1. Anotação essencial: Diz ao Spring que esta classe vai gerenciar requisições HTTP
@RestController
public class SaudacaoController {

    //Variavel para guardar o Serviço injetado.
    private final SaudacaoService service;

    //O Contrutor O Spring INJETA a instancia do Service aqui.
    public SaudacaoController(SaudacaoService service) {
        this.service = service;
    }

    // 2. Anotação essencial: Mapeia a requisição GET para a URL "/ola"
    @GetMapping("/ola")
    public String enviarSaudacao() {
        //return "Olá, Dev! Sua primeira API REST em Spring Boot está funcionando!";
        return service.obterSaudacao();
    }

    //NOVO ENDPOINT O {nome} na URL é a varável.
    @GetMapping("/ola/{nome}")
    public String enviarSaudacaoPersonalizada(@PathVariable String nome) {
        //@PAthVariable mapeia oque está na URL {nom} para a variável String 'nome'
        return service.obterSaudacaoPersonalizada(nome);
    }
}