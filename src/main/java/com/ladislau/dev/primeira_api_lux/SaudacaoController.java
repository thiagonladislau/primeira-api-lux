package com.ladislau.dev.primeira_api_lux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. Anotação essencial: Diz ao Spring que esta classe vai gerenciar requisições HTTP
@RestController
public class SaudacaoController {

    // 2. Anotação essencial: Mapeia a requisição GET para a URL "/ola"
    @GetMapping("/ola")
    public String enviarSaudacao() {
        return "Olá, Dev! Sua primeira API REST em Spring Boot está funcionando!";
    }
}