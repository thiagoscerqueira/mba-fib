package br.edu.fib.bibliotecajavamvc.model;

import javax.persistence.*;

@Entity
@Table(name="USUARIO_GRUPO")
public class UsuarioGrupo {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Grupo grupo;

    public UsuarioGrupo() {
    }

    public UsuarioGrupo(Usuario usuario, Grupo grupo) {
        this.usuario = usuario;
        this.grupo = grupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
