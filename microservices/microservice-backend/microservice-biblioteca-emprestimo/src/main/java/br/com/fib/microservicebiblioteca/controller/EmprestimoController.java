package br.com.fib.microservicebiblioteca.controller;

import br.com.fib.microservicebiblioteca.dao.EmprestimoDAO;
import br.com.fib.microservicebiblioteca.model.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(EmprestimoController.PATH)
public class EmprestimoController {
	
	public static final String PATH = "/emprestimo";

    @Autowired
    private EmprestimoDAO emprestimoDAO;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Emprestimo>> get () {
		return new ResponseEntity<>(emprestimoDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> get (@PathVariable("id") int id) {
        Emprestimo emprestimo = emprestimoDAO.findOne(id);
        if (emprestimo == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(emprestimo, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public HttpStatus delete (@PathVariable("id") int id) {
		emprestimoDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Emprestimo> save (@RequestBody final Emprestimo emprestimoEntity){
		return new ResponseEntity<>(emprestimoDAO.save(emprestimoEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Emprestimo> alter (@PathVariable("id") int id, @RequestBody final Emprestimo emprestimoEntity) {

	    if (!emprestimoDAO.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

	    emprestimoEntity.setId(id);
		return new ResponseEntity<>(emprestimoDAO.save(emprestimoEntity), HttpStatus.OK);
	}
	
}
