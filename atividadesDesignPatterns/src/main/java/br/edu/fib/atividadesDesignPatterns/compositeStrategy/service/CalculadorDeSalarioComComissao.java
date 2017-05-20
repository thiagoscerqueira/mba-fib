package br.edu.fib.atividadesDesignPatterns.compositeStrategy.service;

import br.edu.fib.atividadesDesignPatterns.compositeStrategy.model.CargoComposite;

public class CalculadorDeSalarioComComissao extends CalculadorDeSalarioSemComissao {

	@Override
	public Double calcula(CargoComposite cargo) {
		Double salarioSemComissao = super.calcula(cargo);
		Double salarioComComissao = salarioSemComissao + (cargo.getValorVenda() * cargo.getComissao() / 100);
		return salarioComComissao;
	}

}
