package br.com.fib.microservicebiblioteca.dao;

import br.com.fib.microservicebiblioteca.model.LivroAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroAutorDAO extends JpaRepository<LivroAutor, Integer> {
}
