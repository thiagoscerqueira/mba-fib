package br.edu.fib.calculoSalarioTDD.regraCalculo;

import br.edu.fib.calculoSalarioTDD.model.InfoFuncionario;

import java.math.BigDecimal;

public class RegraPadraoSalarioBruto implements IRegraSalarioBruto {

    @Override
    public BigDecimal calcula(InfoFuncionario infoFuncionario) {

        if (infoFuncionario.getSalarioHora().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salário hora não deve ser negativo");
        }

        if (infoFuncionario.getQuantidadeDependentes() < 0) {
            throw new IllegalArgumentException("Quantidade de dependentes não deve ser negativa");
        }
        if (infoFuncionario.getQuantidadeHorasTrabalhadas() < 0) {
            throw new IllegalArgumentException("Quantidade de horas trabalhadas não deve ser negativa");
        }


        return infoFuncionario.getSalarioHora()
                .multiply(new BigDecimal(infoFuncionario.getQuantidadeHorasTrabalhadas()))
                .add(new BigDecimal(50 * infoFuncionario.getQuantidadeDependentes()));
    }
}
