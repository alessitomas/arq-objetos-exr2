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
import com.mensagens.mensagens.usuario.UsuarioRepository;


@Service
public class MensagemService {
    private List<Mensagem> mensagens = new ArrayList<>();
    
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MensagemRepository mensagemRepository;

    public List<Mensagem> getMensagens() {
        return mensagemRepository.findAll();
    }

    public MensagemTexto salvaMensagemText(MensagemTexto mensagemTexto ) {
        mensagemTexto.setIdentifier(UUID.randomUUID().toString());
        Usuario user = usuarioService.buscaUsuario(mensagemTexto.getUsuario().getIdentifier());
        mensagemTexto.setUsuario(user);
        return mensagemRepository.save(mensagemTexto);
    }


    public MensagemArquivo salvaMensagemArquivo(MensagemArquivo mensagemArquivo) {
        mensagemArquivo.setIdentifier(UUID.randomUUID().toString());
        Usuario user = usuarioService.buscaUsuario(mensagemArquivo.getUsuario().getIdentifier());
        mensagemArquivo.setUsuario(user);
        return mensagemRepository.save(mensagemArquivo);
    }

    public Mensagem getMensagemById(String id) {
       return mensagemRepository.findByIdentifier(id);
    }

    public List<Mensagem> getMensagens_user(String id) {
        Usuario usuario = usuarioService.buscaUsuario(id);
        return mensagemRepository.findByUsuario(usuario);   
    } 
}
