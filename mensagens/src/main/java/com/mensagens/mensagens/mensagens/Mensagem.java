package com.mensagens.mensagens.mensagens;
import com.mensagens.mensagens.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identifier;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

}