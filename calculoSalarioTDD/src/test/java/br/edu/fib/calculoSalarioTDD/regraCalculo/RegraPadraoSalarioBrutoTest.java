package br.edu.fib.calculoSalarioTDD.regraCalculo;

import br.edu.fib.calculoSalarioTDD.builder.InfoFuncionarioBuilder;
import br.edu.fib.calculoSalarioTDD.model.InfoFuncionario;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegraPadraoSalarioBrutoTest {

    @Test
    public void deveCalcularValorQuandoPossuiHorasTrabalhadasSalarioHoraEDependentes() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .comSalarioHora(new BigDecimal(50))
                .comQuantidadeHorasTrabalhadas(35)
                .comQuantidadeDependentes(2)
                .build();

        BigDecimal valorSalarioBruto = new RegraPadraoSalarioBruto().calcula(infoFuncionario);
        assertThat(valorSalarioBruto, is(new BigDecimal(1850)));
    }

    @Test
    public void deveCalcularValorQuandoPossuiHorasTrabalhadasSalarioHoraENaoPossuiDependentes() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .comSalarioHora(new BigDecimal(80))
                .comQuantidadeHorasTrabalhadas(40)
                .build();

        BigDecimal valorSalarioBruto = new RegraPadraoSalarioBruto().calcula(infoFuncionario);
        assertThat(valorSalarioBruto, is(new BigDecimal(3200)));
    }

    @Test
    public void deveCalcularZeroQuandoNaoPossuiHorasTrabalhadasPossuiSalarioHoraENaoPossuiDependentes() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .comSalarioHora(new BigDecimal(800))
                .build();

        BigDecimal valorSalarioBruto = new RegraPadraoSalarioBruto().calcula(infoFuncionario);
        assertThat(valorSalarioBruto, is(new BigDecimal(0)));
    }

    @Test
    public void deveCalcularZeroQuandoPossuiHorasTrabalhadasNaoPossuiSalarioHoraENaoPossuiDependentes() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .comQuantidadeHorasTrabalhadas(40)
                .build();

        BigDecimal valorSalarioBruto = new RegraPadraoSalarioBruto().calcula(infoFuncionario);
        assertThat(valorSalarioBruto, is(new BigDecimal(0)));
    }

    @Test
    public void deveCalcularZeroQuandoNaoPossuiHorasTrabalhadasNaoPossuiSalarioHoraENaoPossuiDependentes() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .build();

        BigDecimal valorSalarioBruto = new RegraPadraoSalarioBruto().calcula(infoFuncionario);
        assertThat(valorSalarioBruto, is(new BigDecimal(0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveDispararExcecaoQuandoSalarioHoraNegativo() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .comSalarioHora(new BigDecimal(-100))
                .build();

        new RegraPadraoSalarioBruto().calcula(infoFuncionario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveDispararExcecaoQuandoQuantidadeHorasTrabalhadasNegativa() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .comQuantidadeHorasTrabalhadas(-30)
                .build();

        new RegraPadraoSalarioBruto().calcula(infoFuncionario);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveDispararExcecaoQuandoQuantidadeDependentesNegativa() {
        InfoFuncionario infoFuncionario = new InfoFuncionarioBuilder()
                .comQuantidadeDependentes(-2)
                .build();

        new RegraPadraoSalarioBruto().calcula(infoFuncionario);
    }
}
