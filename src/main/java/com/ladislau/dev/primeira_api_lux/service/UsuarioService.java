package com.ladislau.dev.primeira_api_lux.service; // Seu pacote

import com.ladislau.dev.primeira_api_lux.model.UsuarioModel;
import com.ladislau.dev.primeira_api_lux.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List; // Import necessário
import java.util.Optional; // Import necessário

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioModel salvarUsuario(UsuarioModel usuario) {
        return repository.save(usuario);
    }

    // NOVO MÉTODO 1: Busca todos os usuários
    public List<UsuarioModel> buscarTodos() {
        // O findAll() vem do JpaRepository
        return repository.findAll();
    }

    // NOVO MÉTODO 2: Busca um usuário pelo ID
    public Optional<UsuarioModel> buscarPorId(Long id) {
        // O findById() retorna um Optional (um padrão do Java para lidar com dados que podem não existir)
        return repository.findById(id);
    }
}