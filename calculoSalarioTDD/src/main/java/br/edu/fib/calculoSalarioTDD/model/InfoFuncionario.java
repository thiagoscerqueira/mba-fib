package br.edu.fib.calculoSalarioTDD.model;

import java.math.BigDecimal;

public class InfoFuncionario {

    private int quantidadeHorasTrabalhadas = 0;
    private BigDecimal salarioHora = BigDecimal.ZERO;
    private int quantidadeDependentes = 0;

    public InfoFuncionario() {
    }

    public InfoFuncionario(int quantidadeHorasTrabalhadas, BigDecimal salarioHora, int quantidadeDependentes) {
        this.quantidadeHorasTrabalhadas = quantidadeHorasTrabalhadas;
        this.salarioHora = salarioHora;
        this.quantidadeDependentes = quantidadeDependentes;
    }

    public InfoFuncionario(InfoFuncionario other) {
        this.quantidadeHorasTrabalhadas = other.quantidadeHorasTrabalhadas;
        this.salarioHora = other.salarioHora;
        this.quantidadeDependentes = other.quantidadeDependentes;
    }

    public int getQuantidadeHorasTrabalhadas() {
        return quantidadeHorasTrabalhadas;
    }

    public BigDecimal getSalarioHora() {
        return salarioHora;
    }

    public int getQuantidadeDependentes() {
        return quantidadeDependentes;
    }
}
