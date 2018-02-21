package br.com.fib.microservicebiblioteca.controller;

import br.com.fib.microservicebiblioteca.dao.ReviewDAO;
import br.com.fib.microservicebiblioteca.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(ReviewController.PATH)
public class ReviewController {
	
	public static final String PATH = "/review";

    @Autowired
    private ReviewDAO reviewDAO;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Review>> get () {
		return new ResponseEntity<>(reviewDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Review> get (@PathVariable("id") int id) {
        Review review = reviewDAO.findOne(id);
        if (review == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(review, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public HttpStatus delete (@PathVariable("id") int id) {
		reviewDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Review> save (@RequestBody final Review reviewEntity){
		return new ResponseEntity<>(reviewDAO.save(reviewEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Review> alter (@PathVariable("id") int id, @RequestBody final Review reviewEntity) {

	    if (!reviewDAO.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

	    reviewEntity.setId(id);
		return new ResponseEntity<>(reviewDAO.save(reviewEntity), HttpStatus.OK);
	}
	
}
