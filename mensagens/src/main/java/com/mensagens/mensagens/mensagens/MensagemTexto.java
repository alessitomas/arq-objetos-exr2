package com.mensagens.mensagens.mensagens;

import com.mensagens.mensagens.usuario.Usuario;

public class MensagemTexto extends Mensagem{
    private String texto;

    public MensagemTexto(Usuario usuario, String texto){
        super(usuario);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString(){
        return "Mensagem Texto:" + getTexto() + "\nUsuário:" + getUsuario().getNome() + "\nLikes:" + getLikes() + "\nData:" + getData();
    }
}
