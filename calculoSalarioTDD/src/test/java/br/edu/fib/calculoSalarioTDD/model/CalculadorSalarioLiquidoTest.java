package br.edu.fib.calculoSalarioTDD.model;

import br.edu.fib.calculoSalarioTDD.builder.CalculadorSalarioLiquidoBuilder;
import br.edu.fib.calculoSalarioTDD.regraCalculo.RegraDescontoINSS;
import br.edu.fib.calculoSalarioTDD.regraCalculo.RegraDescontoIR;
import br.edu.fib.calculoSalarioTDD.regraCalculo.RegraPadraoSalarioBruto;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculadorSalarioLiquidoTest {

    @Test
    public void deveCalcularSalarioLiquidoQuandoInformaRegraSalarioBrutoEDescontosINSSeIR() {
        CalculadorSalarioLiquido calculadorSalarioLiquido = new CalculadorSalarioLiquidoBuilder()
                .comSalarioHora(new BigDecimal(50))
                .comQuantidadeDependentes(2)
                .comQuantidadeHorasTrabalhadas(40)
                .comRegraSalarioBruto(new RegraPadraoSalarioBruto())
                .comDesconto(new RegraDescontoINSS())
                .comDesconto(new RegraDescontoIR())
                .build();

        BigDecimal valorSalarioLiquido = calculadorSalarioLiquido.calcula();
        assertThat(valorSalarioLiquido, is(new BigDecimal(1764)));
    }

    @Test
    public void deveCalcularSalarioLiquidoQuandoInformaRegraSalarioBrutoEDescontoINSS() {
        CalculadorSalarioLiquido calculadorSalarioLiquido = new CalculadorSalarioLiquidoBuilder()
                .comSalarioHora(new BigDecimal(50))
                .comQuantidadeDependentes(2)
                .comQuantidadeHorasTrabalhadas(40)
                .comRegraSalarioBruto(new RegraPadraoSalarioBruto())
                .comDesconto(new RegraDescontoINSS())
                .build();

        BigDecimal valorSalarioLiquido = calculadorSalarioLiquido.calcula();
        assertThat(valorSalarioLiquido, is(new BigDecimal(1911)));
    }

    @Test
    public void deveCalcularSalarioLiquidoQuandoInformaRegraSalarioBrutoEDescontoIR() {
        CalculadorSalarioLiquido calculadorSalarioLiquido = new CalculadorSalarioLiquidoBuilder()
                .comSalarioHora(new BigDecimal(50))
                .comQuantidadeDependentes(2)
                .comQuantidadeHorasTrabalhadas(40)
                .comRegraSalarioBruto(new RegraPadraoSalarioBruto())
                .comDesconto(new RegraDescontoIR())
                .build();

        BigDecimal valorSalarioLiquido = calculadorSalarioLiquido.calcula();
        assertThat(valorSalarioLiquido, is(new BigDecimal(1953)));
    }

    @Test
    public void deveCalcularSalarioLiquidoQuandoInformaRegraSalarioBrutoENaoInformaNenhumDesconto() {
        CalculadorSalarioLiquido calculadorSalarioLiquido = new CalculadorSalarioLiquidoBuilder()
                .comSalarioHora(new BigDecimal(50))
                .comQuantidadeDependentes(2)
                .comQuantidadeHorasTrabalhadas(40)
                .comRegraSalarioBruto(new RegraPadraoSalarioBruto())
                .build();

        BigDecimal valorSalarioLiquido = calculadorSalarioLiquido.calcula();
        assertThat(valorSalarioLiquido, is(new BigDecimal(2100)));
    }

    @Test(expected = RuntimeException.class)
    public void deveDispararExcecaoQuandoNaoInformaRegraSalarioBruto() {
        CalculadorSalarioLiquido calculadorSalarioLiquido = new CalculadorSalarioLiquidoBuilder()
                .comSalarioHora(new BigDecimal(50))
                .comQuantidadeDependentes(2)
                .comQuantidadeHorasTrabalhadas(40)
                .build();

        BigDecimal valorSalarioLiquido = calculadorSalarioLiquido.calcula();
        assertThat(valorSalarioLiquido, is(new BigDecimal(2100)));
    }
}
