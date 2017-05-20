package br.edu.fib.atividadesDesignPatterns.compositeStrategy.service;

import br.edu.fib.atividadesDesignPatterns.compositeStrategy.model.CargoComposite;

public class CalculadorDeSalarioProLabore implements ICalculadorDeSalario {

	@Override
	public Double calcula(CargoComposite cargo) {
		return cargo.getSalario() * 0.98;
	}

}
