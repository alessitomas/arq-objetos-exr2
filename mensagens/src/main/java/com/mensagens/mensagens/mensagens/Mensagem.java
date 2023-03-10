package com.mensagens.mensagens.mensagens;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.mensagens.mensagens.usuario.Usuario;

public class Mensagem {
    private String id;
    private Usuario usuario;
    private Date data;
    private Integer likes;
    private List<Usuario> usuario_likes;

    public Mensagem(Usuario usuario){
        this.usuario = usuario;
        this.data = new Date();
        this.likes = 0;
        this.usuario_likes = new ArrayList<Usuario>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getData() {
        return data;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Usuario> getUsuario_likes() {
        return usuario_likes;
    }

    public void setUsuario_likes(List<Usuario> usuario_likes) {
        this.usuario_likes = usuario_likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
