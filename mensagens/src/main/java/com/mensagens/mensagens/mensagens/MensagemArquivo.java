package com.mensagens.mensagens.mensagens;
import com.mensagens.mensagens.usuario.Usuario;


public class MensagemArquivo extends Mensagem {
    private String arquivo;

    public MensagemArquivo(Usuario usuario, String arquivo){
        super(usuario);
        this.arquivo = arquivo;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public String toString(){
        return "Mensagem Arquivo:" + getArquivo() + "\nUsuário:" + getUsuario().getNome() + "\nLikes:" + getLikes() + "\nData:" + getData();
    }
}
