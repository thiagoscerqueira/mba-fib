package br.edu.fib.calculoSalarioTDD.regraCalculo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RegraDescontoIRTest {

    @Test
    public void deveCalcularValorZeroQuandoSalarioBrutoPositivoMenorQue500() {
        BigDecimal desconto = new RegraDescontoIR().calcula(new BigDecimal(200));
        assertThat(desconto, is(BigDecimal.ZERO));
    }

    @Test
    public void deveCalcularValorQuandoSalarioBrutoIgualA500() {
        BigDecimal desconto = new RegraDescontoIR().calcula(new BigDecimal(500));
        assertThat(desconto, is(BigDecimal.ZERO));
    }

    @Test
    public void deveCalcularValorQuandoSalarioBrutoMaiorQue500EMenorQueMil() {
        BigDecimal desconto = new RegraDescontoIR().calcula(new BigDecimal(700));
        assertThat(desconto, is(new BigDecimal(35)));
    }

    @Test
    public void deveCalcularValorQuandoSalarioBrutoIgualMil() {
        BigDecimal desconto = new RegraDescontoIR().calcula(new BigDecimal(1000));
        assertThat(desconto, is(new BigDecimal(50)));
    }

    @Test
    public void deveCalcularValorQuandoSalarioBrutoMaiorQueMil() {
        BigDecimal desconto = new RegraDescontoIR().calcula(new BigDecimal(1800));
        assertThat(desconto, is(new BigDecimal(126)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveDispararExcecaoQuandoSalarioBrutoNegativo() {
        new RegraDescontoIR().calcula(new BigDecimal(-2000));
    }

}
