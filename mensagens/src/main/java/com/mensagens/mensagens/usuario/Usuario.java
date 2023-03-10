package com.mensagens.mensagens.usuario;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String id;
    private List<Usuario> lista_seguidores;
    private Integer seguidores;


    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.lista_seguidores = new ArrayList<Usuario>();
        this.seguidores = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Usuario> getLista_seguidores() {
        return lista_seguidores;
    }

    public void setLista_seguidores(List<Usuario> lista_seguidores) {
        this.lista_seguidores = lista_seguidores;
    }

    public Integer getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Integer seguidores) {
        this.seguidores = seguidores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
