package br.com.fib.microservicebiblioteca.controller;

import br.com.fib.microservicebiblioteca.dao.UsuarioDAO;
import br.com.fib.microservicebiblioteca.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(UsuarioController.PATH)
public class UsuarioController {
	
	public static final String PATH = "/usuario";

    @Autowired
    private UsuarioDAO usuarioDAO;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Usuario>> get () {
		return new ResponseEntity<>(usuarioDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> get (@PathVariable("id") int id) {
        Usuario usuario = usuarioDAO.findOne(id);
        if (usuario == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public HttpStatus delete (@PathVariable("id") int id) {
		usuarioDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Usuario> save (@RequestBody final Usuario usuarioEntity){
		return new ResponseEntity<>(usuarioDAO.save(usuarioEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alter (@PathVariable("id") int id, @RequestBody final Usuario usuarioEntity) {

	    if (!usuarioDAO.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

	    usuarioEntity.setId(id);
		return new ResponseEntity<>(usuarioDAO.save(usuarioEntity), HttpStatus.OK);
	}
	
}
