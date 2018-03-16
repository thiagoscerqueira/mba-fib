package br.edu.fib.calculoSalarioTDD.regraCalculo;

import br.edu.fib.calculoSalarioTDD.model.InfoFuncionario;

import java.math.BigDecimal;

public interface IRegraSalarioBruto {

    BigDecimal calcula(InfoFuncionario infoFuncionario);
}
