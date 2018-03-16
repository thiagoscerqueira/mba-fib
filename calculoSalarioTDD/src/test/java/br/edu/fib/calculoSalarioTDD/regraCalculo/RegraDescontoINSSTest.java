package br.edu.fib.calculoSalarioTDD.regraCalculo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RegraDescontoINSSTest {

    @Test
    public void deveCalcularValorQuandoSalarioBrutoPositivoMenorQueMil() {
        BigDecimal desconto = new RegraDescontoINSS().calcula(new BigDecimal(200));
        assertThat(desconto.setScale(0), is(new BigDecimal(17)));
    }

    @Test
    public void deveCalcularValorQuandoSalarioBrutoPositivoIgualAMil() {
        BigDecimal desconto = new RegraDescontoINSS().calcula(new BigDecimal(1000));
        assertThat(desconto.setScale(0), is(new BigDecimal(85)));
    }

    @Test
    public void deveCalcularValorQuandoSalarioBrutoPositivoMaiorQueMil() {
        BigDecimal desconto = new RegraDescontoINSS().calcula(new BigDecimal(1500));
        assertThat(desconto, is(new BigDecimal(135)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveDispararExcecaoQuandoSalarioBrutoNegativo() {
        new RegraDescontoINSS().calcula(new BigDecimal(-2000));
    }

}
