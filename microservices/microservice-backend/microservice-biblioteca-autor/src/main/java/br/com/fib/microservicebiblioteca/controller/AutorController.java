package br.com.fib.microservicebiblioteca.controller;

import br.com.fib.microservicebiblioteca.dao.AutorDAO;
import br.com.fib.microservicebiblioteca.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(AutorController.PATH)
public class AutorController {
	
	public static final String PATH = "/autor";

    @Autowired
    private AutorDAO autorDAO;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Autor>> get () {
		return new ResponseEntity<>(autorDAO.findAll(), HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Autor> get (@PathVariable("id") int id) {
        Autor autor = autorDAO.findOne(id);
        if (autor == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(autor, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public HttpStatus delete (@PathVariable("id") int id) {
		autorDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Autor> save (@RequestBody final Autor autor){
		return new ResponseEntity<>(autorDAO.save(autor), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Autor> alter (@PathVariable("id") int id, @RequestBody final Autor autor) {

	    if (!autorDAO.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

	    autor.setId(id);
		return new ResponseEntity<>(autorDAO.save(autor), HttpStatus.OK);
	}
	
}
