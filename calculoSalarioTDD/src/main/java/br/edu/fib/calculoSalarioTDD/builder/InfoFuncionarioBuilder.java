package br.edu.fib.calculoSalarioTDD.builder;

import br.edu.fib.calculoSalarioTDD.model.InfoFuncionario;

import java.math.BigDecimal;

public class InfoFuncionarioBuilder {

    private int quantidadeHorasTrabalhadas = 0;
    private BigDecimal salarioHora = BigDecimal.ZERO;
    private int quantidadeDependentes = 0;

    public InfoFuncionarioBuilder comQuantidadeHorasTrabalhadas(int quantidadeHorasTrabalhadas) {
        this.quantidadeHorasTrabalhadas = quantidadeHorasTrabalhadas;
        return this;
    }

    public InfoFuncionarioBuilder comSalarioHora(BigDecimal salarioHora) {
        this.salarioHora = salarioHora;
        return this;
    }

    public InfoFuncionarioBuilder comQuantidadeDependentes(int quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
        return this;
    }

    public InfoFuncionario build() {
        return new InfoFuncionario(quantidadeHorasTrabalhadas, salarioHora, quantidadeDependentes);
    }
}