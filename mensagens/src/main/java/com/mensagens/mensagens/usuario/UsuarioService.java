package com.mensagens.mensagens.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario salvarUsuario(Usuario usuario) {
        usuario.setId(UUID.randomUUID().toString());
        usuarios.add(usuario);
        return usuario;
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
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
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
}
