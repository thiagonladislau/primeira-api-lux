package com.ladislau.dev.primeira_api_lux.service; // USE SEU PACOTE AQUI

import org.springframework.stereotype.Service;

// Anotação ESSENCIAL que diz ao Spring para gerenciar esta classe como lógica de negócio.
@Service
public class SaudacaoService {

    public String obterSaudacao() {
        // Nova lógica, agora residindo na camada de Service
        return "Olá do Service! Seu Back-end está arquitetado corretamente.";
    }

    //NOVO METODO Aceitar nome como Parâmetro
    public String obterSaudacaoPersonalizada(String nome) {
        return "Olá, " + nome + " A sua API está aceitando dados dinâmicos.";
    }
}