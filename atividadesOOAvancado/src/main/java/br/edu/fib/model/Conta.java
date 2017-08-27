package br.edu.fib.model;

import java.math.BigDecimal;

public class Conta implements IConta{

    private String id;
    private BigDecimal saldo = BigDecimal.ZERO;

    public Conta(String id) {
        this.id = id;
    }


    public void sacar(BigDecimal valor) {
        testaValorValido(valor);

        if (valor.compareTo(saldo) > 0) {
            throw new IllegalArgumentException("Não há saldo suficiente para realizar o saque");
        }

        saldo =  saldo.subtract(valor);
    }


    public void depositar(BigDecimal valor) {
        testaValorValido(valor);

        saldo = saldo.add(valor);
    }

    public void transferir(BigDecimal valor, IConta conta) {
        this.sacar(valor);
        conta.depositar(valor);
    }

    public BigDecimal saldoAtual() {
        return this.saldo;
    }

    private void testaValorValido(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id='" + id + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
