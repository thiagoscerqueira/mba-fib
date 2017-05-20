package br.edu.fib.atividadesDesignPatterns.compositeStrategy.service;

import br.edu.fib.atividadesDesignPatterns.compositeStrategy.model.CargoComposite;

/**
 * Abstração que define método comum para os diversos algoritmos de cálculo de
 * salário.
 * 
 * @author thiago
 *
 */
public interface ICalculadorDeSalario {

	public Double calcula(CargoComposite cargo);
}
