package com.mensagens.mensagens.usuario;
import com.mensagens.mensagens.usuario.UsuarioService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // listar tds usuarios
    @GetMapping("")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    // listar usuario por id
    @GetMapping("/{id}")
    public Usuario getUsuariosbyid(@PathVariable String id) {
        return usuarioService.buscaUsuario(id);
    }

    // criar usuario
    @PostMapping
    public Usuario criaUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUser(usuario);
    }


    
}

