package br.com.fib.microservicebiblioteca.dao;

import br.com.fib.microservicebiblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoDAO extends JpaRepository<Emprestimo, Integer> {
}
