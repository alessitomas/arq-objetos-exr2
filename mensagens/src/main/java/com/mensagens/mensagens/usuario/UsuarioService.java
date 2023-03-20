package com.mensagens.mensagens.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUser(Usuario user) {
        user.setIdentifier(UUID.randomUUID().toString());
        return usuarioRepository.save(user);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
  
    
    public Usuario getUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscaUsuario(String id) {
        return usuarioRepository.findByIdentifier(id);
    }
}
