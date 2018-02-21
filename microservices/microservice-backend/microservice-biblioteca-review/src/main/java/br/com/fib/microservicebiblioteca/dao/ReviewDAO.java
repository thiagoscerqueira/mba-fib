package br.com.fib.microservicebiblioteca.dao;

import br.com.fib.microservicebiblioteca.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Integer> {
}
