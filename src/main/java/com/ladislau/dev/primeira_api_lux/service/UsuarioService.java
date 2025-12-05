package com.ladislau.dev.primeira_api_lux.service; // Seu pacote

import com.ladislau.dev.primeira_api_lux.model.UsuarioModel;
import com.ladislau.dev.primeira_api_lux.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioModel salvarUsuario(UsuarioModel usuario) {
        return repository.save(usuario);
    }
}