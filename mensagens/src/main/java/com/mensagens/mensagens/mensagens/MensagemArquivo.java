package com.mensagens.mensagens.mensagens;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MensagemArquivo extends Mensagem {
    private String extensao;
}