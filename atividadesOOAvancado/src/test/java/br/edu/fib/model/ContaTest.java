package br.edu.fib.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ContaTest {

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeTentarDepositarValorNegativo() throws Exception {
        IConta conta = new Conta("CONTA");
        conta.depositar(new BigDecimal(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeTentarDepositarValorZero() throws Exception {
        IConta conta = new Conta("CONTA");
        conta.depositar(BigDecimal.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeTentarSacarValorNegativo() throws Exception {
        IConta conta = new Conta("CONTA");
        conta.sacar(new BigDecimal(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeTentarSacarValorZero() throws Exception {
        IConta conta = new Conta("CONTA");
        conta.sacar(BigDecimal.ZERO);
    }

    @Test
    public void deveRetornarValorCorretoDoSaldoAposUmDeposito() throws Exception {
        IConta conta = new Conta("CONTA");
        conta.depositar(new BigDecimal(10));
        assertEquals(new BigDecimal(10), conta.saldoAtual());
    }

    @Test
    public void deveRetornarValorCorretoDoSaldoAposDoisDepositosConsecutivos() throws Exception {
        IConta conta = new Conta("CONTA");
        conta.depositar(new BigDecimal(10));
        conta.depositar(new BigDecimal(20));
        assertEquals(new BigDecimal(30), conta.saldoAtual());
    }

    @Test
    public void deveRetornarValorCorretoDoSaldoAposDiversosDepositosESaques() throws Exception {
        IConta conta = new Conta("CONTA");
        conta.depositar(new BigDecimal(10));
        conta.sacar(new BigDecimal(5));
        conta.sacar(new BigDecimal(4));
        conta.depositar(new BigDecimal(2));
        conta.sacar(new BigDecimal(1));
        conta.depositar(new BigDecimal(6));
        assertEquals(new BigDecimal(8), conta.saldoAtual());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeTentarSacarValorMaiorQueOSaldo() throws Exception {
        IConta conta = new Conta("CONTA");
        conta.depositar(new BigDecimal(40));
        conta.sacar(new BigDecimal(41));
    }

    @Test
    public void deveTransferirSaldoEntreDuasContas() throws Exception {
        IConta conta1 = new Conta("CONTA1");
        conta1.depositar(new BigDecimal(10));
        IConta conta2 = new Conta("CONTA2");
        conta2.depositar(new BigDecimal(8));

        conta1.transferir(new BigDecimal(4), conta2);

        assertEquals(new BigDecimal(6), conta1.saldoAtual());
        assertEquals(new BigDecimal(12), conta2.saldoAtual());
    }


}