package com.ladislau.dev.primeira_api_lux.model;

import jakarta.persistence.Entity; // Importa JPA (Java Persistence API)
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // Importa Lombok (Substitui @Getter, @Setter, @RequiredArgsConstructor)

// 1. Anotação JPA: Diz ao Spring que esta classe é uma tabela no banco.
@Entity
// 2. Anotação Lombok: Gera Getters, Setters, toString, equals e hashCode.
@Data
public class UsuarioModel {

    // --- Atributos de Mapeamento JPA (Obrigatórios) ---

    // 3. @Id: Define que este campo é a chave primária da tabela.
    @Id
    // 4. @GeneratedValue: Define que o valor do ID será gerado automaticamente pelo banco.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // --- Atributos da Entidade ---
    private String nome;
    private String email;
    private String cargo; // Ex: Desenvolvedor, Analista de Dados
}