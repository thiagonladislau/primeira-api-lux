package com.ladislau.dev.primeira_api_lux; // Use seu pacote principal ou .controller

import com.ladislau.dev.primeira_api_lux.model.UsuarioModel;
import com.ladislau.dev.primeira_api_lux.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping; // Verbo POST (CREATE)
import org.springframework.web.bind.annotation.RequestBody; // Recebe o JSON do corpo
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios") // Mapeia todos os métodos desta classe para a URL /usuarios
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Injeta o Service
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
}