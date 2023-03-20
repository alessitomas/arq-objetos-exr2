package com.mensagens.mensagens.mensagens;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.mensagens.mensagens.usuario.Usuario;

public interface MensagemRepository extends JpaRepository<Mensagem,Integer>{
    Mensagem findByIdentifier(String identifier);   
    List<Mensagem> findByUsuario(Usuario usuario); 
}
