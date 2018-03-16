package br.edu.fib.calculoSalarioTDD.model;

import br.edu.fib.calculoSalarioTDD.regraCalculo.IRegraDescontoSalario;
import br.edu.fib.calculoSalarioTDD.regraCalculo.IRegraSalarioBruto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CalculadorSalarioLiquido implements ICalculadorSalarioLiquido {

    private InfoFuncionario infoFuncionario;
    private IRegraSalarioBruto regraSalarioBruto;
    private List<IRegraDescontoSalario> descontos;

    public CalculadorSalarioLiquido() {
    }

    public CalculadorSalarioLiquido(InfoFuncionario infoFuncionario, IRegraSalarioBruto regraSalarioBruto, List<IRegraDescontoSalario> descontos) {
        this.infoFuncionario = infoFuncionario;
        this.regraSalarioBruto = regraSalarioBruto;
        this.descontos = descontos;
    }

    public InfoFuncionario getInfoFuncionario() {
        return new InfoFuncionario(infoFuncionario);
    }

    public IRegraSalarioBruto getRegraSalarioBruto() {
        return regraSalarioBruto;
    }

    public List<IRegraDescontoSalario> getDescontos() {
        return Collections.unmodifiableList(descontos);
    }

    @Override
    public BigDecimal calcula() {
        if (regraSalarioBruto == null) {
            throw new RuntimeException("Deve ser informada uma regra de salário bruto");
        }

        BigDecimal salarioBruto = regraSalarioBruto.calcula(infoFuncionario);
        BigDecimal salarioLiquido = salarioBruto.add(BigDecimal.ZERO);

        for (IRegraDescontoSalario regraDescontoSalario : this.descontos) {
            salarioLiquido = salarioLiquido.subtract(regraDescontoSalario.calcula(salarioBruto));
        }

        return salarioLiquido;
    }
}
