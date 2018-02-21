package br.com.fib.microservicebiblioteca.controller;

import br.com.fib.microservicebiblioteca.dao.LivroAutorDAO;
import br.com.fib.microservicebiblioteca.model.LivroAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(LivroAutorController.PATH)
public class LivroAutorController {
	
	public static final String PATH = "/livro-autor";

    @Autowired
    private LivroAutorDAO livroAutorDAO;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<LivroAutor>> get () {
		return new ResponseEntity<>(livroAutorDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<LivroAutor> get (@PathVariable("id") int id) {
        LivroAutor livroAutor = livroAutorDAO.findOne(id);
        if (livroAutor == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(livroAutor, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public HttpStatus delete (@PathVariable("id") int id) {
		livroAutorDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<LivroAutor> save(@RequestBody final LivroAutor livroAutorEntity){
		return new ResponseEntity<>(livroAutorDAO.save(livroAutorEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<LivroAutor> alter (@PathVariable("id") int id, @RequestBody final LivroAutor livroAutorEntity) {

	    if (!livroAutorDAO.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

	    livroAutorEntity.setId(id);
		return new ResponseEntity<>(livroAutorDAO.save(livroAutorEntity), HttpStatus.OK);
	}
	
}
