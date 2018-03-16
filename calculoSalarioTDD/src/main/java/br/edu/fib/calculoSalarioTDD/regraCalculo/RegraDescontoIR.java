package br.edu.fib.calculoSalarioTDD.regraCalculo;

import java.math.BigDecimal;

public class RegraDescontoIR implements IRegraDescontoSalario {

    @Override
    public BigDecimal calcula(BigDecimal salarioBruto) {

        if (salarioBruto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salário bruto não deve ser negativo");
        }

        if (salarioBruto.compareTo(new BigDecimal(500)) <= 0) {
            return BigDecimal.ZERO;
        }

        if (salarioBruto.compareTo(new BigDecimal(1000)) <= 0) {
            return salarioBruto.multiply(new BigDecimal(5)).divide(new BigDecimal(100));
        }

        return salarioBruto.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
    }
}
