package com.mensagens.mensagens.mensagens;
import com.mensagens.mensagens.mensagens.MensagemArquivo;
import com.mensagens.mensagens.mensagens.MensagemTexto;
import com.mensagens.mensagens.usuario.UsuarioService;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensagens.mensagens.usuario.Usuario;

@Service
public class MensagemService {
    private List<Mensagem> mensagens = new ArrayList<>();
    @Autowired
    private UsuarioService usuarioService;
    
    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public MensagemTexto salvaMensagemText(String id_user, String texto) {
        Usuario usuario =usuarioService.buscaUsuario(id_user);
        if (usuario != null) {
            MensagemTexto mensagem = new MensagemTexto(usuario, texto);
            mensagem.setId(UUID.randomUUID().toString());
            mensagens.add(mensagem);
            return mensagem;
        } else{
            return null;
        }

    }

    public MensagemArquivo salvaMensagemArquivo(String id_user, String texto) {
        Usuario usuario =usuarioService.buscaUsuario(id_user);
        if (usuario != null) {
            MensagemArquivo mensagem = new MensagemArquivo(usuario, texto);
            mensagem.setId(UUID.randomUUID().toString());
            mensagens.add(mensagem);
            return mensagem;
        } else{
            return null;
        }

    }

    public Mensagem getMensagemById(String id) {
        for (Mensagem mensagem : mensagens) {
            if (mensagem.getId().equals(id)) {
                return mensagem;
            }
        }
        return null;
    }

    public List<Mensagem> getMensagens_user(String id) {
        List<Mensagem> mensagens_user = new ArrayList<>();
        for (Mensagem mensagem : mensagens) {
            if (mensagem.getUsuario().getId().equals(id)) {
                mensagens_user.add(mensagem);
            }
        }
        return mensagens_user;
    }

    
}
