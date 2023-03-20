package com.mensagens.mensagens.mensagens;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MensagemTexto extends Mensagem {
    private String texto;
}
