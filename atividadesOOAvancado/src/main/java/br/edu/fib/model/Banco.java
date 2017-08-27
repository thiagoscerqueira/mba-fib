package br.edu.fib.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Conta> listaDeTodasContas = new ArrayList<Conta>();

    public List<Conta> listaContas() {
        return listaDeTodasContas;
    }

    public String listaContasFormatado() {
        return listaDeTodasContas.stream().map(conta -> conta.toString()).reduce(String::concat).orElse("");
    }

    public BigDecimal saldoTotal() {
        return listaDeTodasContas.stream().map(conta -> conta.saldoAtual()).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public void adicionarConta(Conta conta) {
        listaDeTodasContas.add(conta);
    }
}
