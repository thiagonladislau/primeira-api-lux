package com.ladislau.dev.primeira_api_lux.repository; // Seu pacote .repository

import com.ladislau.dev.primeira_api_lux.model.UsuarioModel; // Importa o Model
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface base

// 1. O Spring fará a MÁGICA aqui. JpaRepository é a base.
// 2. Parâmetros: <Qual Model será gerenciado, Tipo da Chave Primária>
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    // TODO: Não precisamos adicionar código. O Spring já gerou os métodos CRUD (Create, Read, Update, Delete)
}

/**/