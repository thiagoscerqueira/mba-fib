package br.edu.fib.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BancoTest {

    @Test
    public void deveRetornarSaldoZeroQuandoBancoNaoPossuiConta() throws Exception {
        assertEquals(BigDecimal.ZERO, new Banco().saldoTotal());
    }

    @Test
    public void deveRetornarSaldoCorretoQuandoBancoPossuiContas() throws Exception {
        Banco banco = criaBancoComTresContas();
        assertEquals(new BigDecimal(60), banco.saldoTotal());
    }

    @Test
    public void deveListarContas() throws Exception {
        Banco banco = criaBancoComTresContas();
        assertEquals(3, banco.listaContas().size());
    }

    @Test
    public void deveListarContasFormatado() throws Exception {
        Banco banco = criaBancoComTresContas();

        String formatado = banco.listaContasFormatado();
        System.out.println(formatado);
    }

    private Banco criaBancoComTresContas() {
        IConta conta1 = new Conta("CONTA1");
        conta1.depositar(new BigDecimal(10));
        IConta conta2 = new Conta("CONTA2");
        conta2.depositar(new BigDecimal(20));
        IConta conta3 = new Conta("CONTA3");
        conta3.depositar(new BigDecimal(30));

        Banco banco = new Banco();
        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);
        banco.adicionarConta(conta3);
        return banco;
    }
}