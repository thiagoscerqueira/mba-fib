package br.edu.fib.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<IConta> listaDeTodasContas = new ArrayList<>();

    public List<IConta> listaContas() {
        return listaDeTodasContas;
    }

    public String listaContasFormatado() {
        return listaDeTodasContas.stream().map(conta -> conta.toString()).reduce(String::concat).orElse("");
    }

    public BigDecimal saldoTotal() {
        return listaDeTodasContas.stream().map(conta -> conta.saldoAtual()).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public void adicionarConta(IConta conta) {
        listaDeTodasContas.add(conta);
    }
}
