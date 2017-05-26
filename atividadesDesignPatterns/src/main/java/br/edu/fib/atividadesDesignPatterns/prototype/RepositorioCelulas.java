package br.edu.fib.atividadesDesignPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

import br.edu.fib.atividadesDesignPatterns.prototype.celulas.CelulaBucal;
import br.edu.fib.atividadesDesignPatterns.prototype.celulas.CelulaEpitelial;
import br.edu.fib.atividadesDesignPatterns.prototype.celulas.CelulaEstomacal;
import br.edu.fib.atividadesDesignPatterns.prototype.celulas.CelulaNeuronio;
import br.edu.fib.atividadesDesignPatterns.prototype.celulas.interfaces.Celula;

/**
 * A classe repositório tem por objetivo armazenar uma instância de cada tipo de
 * célula (protótipo) e entregar às classes demandadoras uma cópia da instância
 * desejada a cada solicitação. A cópia é feita por meio do método "mitose" de
 * cada objeto célula.
 */
public class RepositorioCelulas {

	// Essa lista contém os objetos criados para serem utilizados como protótipo
	List<Celula> arrCelulas = new ArrayList<>();

	/*
	 * O método novaCelula é o responsável por entregar uma instância do objeto
	 * solicitado à classe demandadora O tipo de célula enviado é identificado
	 * pelo parâmetro passado na invocação do método
	 */
	public Celula novaCelula(String tipo) {

		switch (tipo) {
		case "bucal":
			return (CelulaBucal) arrCelulas.get(0).mitose();
		case "estomacal":
			return (CelulaEstomacal) arrCelulas.get(1).mitose();
		case "epitelial":
			return (CelulaEpitelial) arrCelulas.get(2).mitose();
		case "neuronio":
			return (CelulaNeuronio) arrCelulas.get(3).mitose();
		}

		return null;
	}

	// Na criação do objeto repositório, fazemos a criação de todos os objetos
	// protótipos
	public RepositorioCelulas() {
		arrCelulas.add(new CelulaBucal());
		arrCelulas.add(new CelulaEstomacal());
		arrCelulas.add(new CelulaEpitelial());
		arrCelulas.add(new CelulaNeuronio());
	}
}
