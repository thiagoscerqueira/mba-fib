package br.com.fib.microservicebiblioteca.dao;

import br.com.fib.microservicebiblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDAO extends JpaRepository<Autor, Integer> {
}
