package br.edu.fib.calculoSalarioTDD.builder;

import br.edu.fib.calculoSalarioTDD.model.CalculadorSalarioLiquido;
import br.edu.fib.calculoSalarioTDD.model.InfoFuncionario;
import br.edu.fib.calculoSalarioTDD.regraCalculo.IRegraDescontoSalario;
import br.edu.fib.calculoSalarioTDD.regraCalculo.IRegraSalarioBruto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculadorSalarioLiquidoBuilder {

    private int quantidadeHorasTrabalhadas;
    private BigDecimal salarioHora;
    private int quantidadeDependentes;
    private IRegraSalarioBruto regraSalarioBruto;
    private List<IRegraDescontoSalario> descontos = new ArrayList<>();


    public CalculadorSalarioLiquidoBuilder comQuantidadeHorasTrabalhadas(int quantidadeHorasTrabalhadas) {
        this.quantidadeHorasTrabalhadas = quantidadeHorasTrabalhadas;
        return this;
    }

    public CalculadorSalarioLiquidoBuilder comSalarioHora(BigDecimal salarioHora) {
        this.salarioHora = salarioHora;
        return this;
    }

    public CalculadorSalarioLiquidoBuilder comQuantidadeDependentes(int quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
        return this;
    }

    public CalculadorSalarioLiquidoBuilder comRegraSalarioBruto(IRegraSalarioBruto regraSalarioBruto) {
        this.regraSalarioBruto = regraSalarioBruto;
        return this;
    }

    public CalculadorSalarioLiquidoBuilder comDesconto(IRegraDescontoSalario desconto) {
        this.descontos.add(desconto);
        return this;
    }

    public CalculadorSalarioLiquido build() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .comQuantidadeDependentes(quantidadeDependentes)
                .comQuantidadeHorasTrabalhadas(quantidadeHorasTrabalhadas)
                .comSalarioHora(salarioHora)
                .build();

        return new CalculadorSalarioLiquido(infoFuncionario, regraSalarioBruto, descontos);
    }
}
