package br.edu.fib.atividadesDesignPatterns.compositeStrategy.model;

import br.edu.fib.atividadesDesignPatterns.compositeStrategy.service.CalculadorDeSalarioComComissao;
import br.edu.fib.atividadesDesignPatterns.compositeStrategy.service.CalculadorDeSalarioProLabore;
import br.edu.fib.atividadesDesignPatterns.compositeStrategy.service.CalculadorDeSalarioSemComissao;
import br.edu.fib.atividadesDesignPatterns.compositeStrategy.service.ICalculadorDeSalario;

/**
 * Representa o tipo de cargo e relaciona ao cargo o respectivo método de
 * cálculo de salário. Definir o método de cálculo aqui é interessante pois
 * se, por exemplo, for necessário adicionar mais um cargo na aplicação, o
 * desenvolvedor já vai saber que precisa definir um método de cálculo de
 * salário para este novo cargo (encapsulamento), sem precisar ter que lembrar de
 * alterar outras partes do código caso a regra estivesse espalhada em outra(s)
 * classe(s).
 * 
 * @author thiago
 *
 */
public enum TipoCargoEnum {

	PRESIDENCIA(new CalculadorDeSalarioProLabore()), 
	DIRETOR_COMERCIAL(new CalculadorDeSalarioComComissao()), 
	VENDEDOR(new CalculadorDeSalarioComComissao()), 
	DIRETOR_PRODUCAO(new CalculadorDeSalarioSemComissao()), 
	DESENVOLVEDOR(new CalculadorDeSalarioSemComissao());

	private ICalculadorDeSalario calculadorDeSalario;

	private TipoCargoEnum(ICalculadorDeSalario calculadorDeSalario) {
		this.calculadorDeSalario = calculadorDeSalario;
	}

	public ICalculadorDeSalario getCalculadorDeSalario() {
		return calculadorDeSalario;
	}

}
