package br.com.fib.microservicebiblioteca.controller;

import br.com.fib.microservicebiblioteca.dao.LivroDAO;
import br.com.fib.microservicebiblioteca.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(LivroController.PATH)
public class LivroController {
	
	public static final String PATH = "/livro";

    @Autowired
    private LivroDAO livroDAO;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Livro>> get () {
		return new ResponseEntity<>(livroDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Livro> get (@PathVariable("id") int id) {
        Livro livro = livroDAO.findOne(id);
        if (livro == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(livro, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public HttpStatus delete (@PathVariable("id") int id) {
		livroDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Livro> save (@RequestBody final Livro livroEntity){
		return new ResponseEntity<>(livroDAO.save(livroEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Livro> alter (@PathVariable("id") int id, @RequestBody final Livro livroEntity) {

	    if (!livroDAO.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

	    livroEntity.setId(id);
		return new ResponseEntity<>(livroDAO.save(livroEntity), HttpStatus.OK);
	}
	
}
