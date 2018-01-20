package br.edu.fib.bibliotecajavamvc.service;

import br.edu.fib.bibliotecajavamvc.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    void save(Usuario usuario);

    Usuario findByUsername(String username);

    List<Usuario> findAll();
}
