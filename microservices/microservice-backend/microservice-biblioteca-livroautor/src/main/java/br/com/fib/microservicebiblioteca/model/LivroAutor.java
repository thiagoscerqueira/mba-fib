package br.com.fib.microservicebiblioteca.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "livroAutor")
public class LivroAutor implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_livro")
	private int idLivro;
	
	@Column(name="id_autor")
	private int idAutor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
}
