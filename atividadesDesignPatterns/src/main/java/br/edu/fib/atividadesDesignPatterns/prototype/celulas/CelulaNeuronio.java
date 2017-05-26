package br.edu.fib.atividadesDesignPatterns.prototype.celulas;

import br.edu.fib.atividadesDesignPatterns.prototype.celulas.interfaces.Celula;

/**
 * Implementação da célula do tipo "Estomacal", estendendo a classe "Celula". O
 * método mitose é o responsável por devolver ao demandador o objeto clonado.
 */
public class CelulaNeuronio extends Celula {

	public CelulaNeuronio() {
		tipo = "Neuronio";
	}

	@Override
	public Object mitose() {
		System.out.println("Nova célula neuronio criada");
		try {
			return this.clone();
		} catch (CloneNotSupportedException err) {
			return null;
		}
	}
}
