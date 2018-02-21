package br.com.fib.microservicebiblioteca.dao;

import br.com.fib.microservicebiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroDAO extends JpaRepository<Livro, Integer> {
}
