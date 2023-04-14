package com.mensagens.mensagens.ususario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mensagens.mensagens.usuario.Usuario;
import com.mensagens.mensagens.usuario.UsuarioRepository;
import com.mensagens.mensagens.usuario.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @InjectMocks
    UsuarioService usuarioService;

    @Mock
    UsuarioRepository usuarioRepository;

    @Test
    void test_cria_usuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("tom");
        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
        Usuario usuarioCriado = usuarioService.saveUser(usuario);
        Assertions.assertEquals(usuarioCriado.getNome(), usuario.getNome());
    }

    @Test
    void test_todos_usuarios(){
        Usuario usuario_1 = new Usuario();
        Usuario usuario_2 = new Usuario();

        usuario_1.setNome("tom");
        usuario_2.setNome("joao");

        List<Usuario> usuarios = new ArrayList<>();

        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> usuariosEncontrados = usuarioService.getUsuarios();
        
        Assertions.assertEquals(usuariosEncontrados.size(), usuarios.size());
    }

    @Test
    void test_usuario_get_by_id(){
        Usuario usuario_1 = new Usuario();
        usuario_1.setNome("tom");
        usuario_1.setIdentifier("1");

        Mockito.when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario_1));

        Usuario usuarioEncontrado = usuarioService.buscaUsuario("1");

        Assertions.assertEquals(usuarioEncontrado.getNome(), usuario_1.getNome());
    }

    @Test
    void test_usuario_get_by_username(){
        Usuario usuario_1 = new Usuario();
        usuario_1.setNome("tom");


        Usuario usuarioEncontrado = usuarioService.getUsuario("tom");

        Assertions.assertEquals(usuarioEncontrado.getNome(), usuario_1.getNome());
    }

    
}