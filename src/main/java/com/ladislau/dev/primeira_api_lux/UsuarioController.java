package com.ladislau.dev.primeira_api_lux; // Use seu pacote principal ou .controller

import com.ladislau.dev.primeira_api_lux.model.UsuarioModel;
import com.ladislau.dev.primeira_api_lux.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa todos os métodos HTTP
import java.util.List; // Import necessário
import java.util.Optional; // Import necessário

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // ... Construtor e método POST existentes ...
    private final UsuarioService usuarioService; // <--- Variável de INSTÂNCIA

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Endpoint POST: http://localhost:8080/usuarios
    @PostMapping
    public ResponseEntity<UsuarioModel> criarUsuario(@RequestBody UsuarioModel usuario) {

        UsuarioModel novoUsuario = usuarioService.salvarUsuario(usuario);

        // Retorna o objeto salvo e o Status 201 CREATED (Padrão REST para criação)
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    // NOVO ENDPOINT 1: GET - Busca todos os usuários
    // URL: http://localhost:8080/usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> buscarTodos() {
        List<UsuarioModel> usuarios = usuarioService.buscarTodos();
        // Retorna a lista e o Status 200 OK
        return ResponseEntity.ok(usuarios);
    }

    // NOVO ENDPOINT 2: GET - Busca um usuário por ID
    // URL: http://localhost:8080/usuarios/1
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id) {

        // O Service retorna um Optional<UsuarioModel>
        Optional<UsuarioModel> usuarioOptional = usuarioService.buscarPorId(id);

        // Se o usuário existir, retorna o usuário com Status 200 OK.
        // Caso contrário (ifPresentOrElse), retorna 404 NOT FOUND (Melhor prática REST).
        return usuarioOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}