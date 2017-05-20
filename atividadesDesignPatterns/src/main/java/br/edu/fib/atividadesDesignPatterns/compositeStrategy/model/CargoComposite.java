package br.edu.fib.atividadesDesignPatterns.compositeStrategy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe que representa um composite do cargo, contendo os atributos, a lista
 * de subordinados que o compõe e os métodos de cálculo.
 * 
 * @author thiago
 *
 */
public class CargoComposite implements ICargo {

	private Double salario;
	private Double comissao;
	private TipoCargoEnum tipoCargo;
	private Double valorVenda;
	private List<ICargo> listaSubordinados = new ArrayList<>();

	public CargoComposite(TipoCargoEnum tipoCargo, Double salario) {
		this.tipoCargo = tipoCargo;
		this.salario = salario;
	}

	public CargoComposite(TipoCargoEnum tipoCargo, Double salario, Double comissao) {
		this.tipoCargo = tipoCargo;
		this.salario = salario;
		this.comissao = comissao;
	}

	public CargoComposite(TipoCargoEnum tipoCargo, Double salario, Double comissao, Double valorVenda) {
		this.tipoCargo = tipoCargo;
		this.salario = salario;
		this.comissao = comissao;
		this.valorVenda = valorVenda;
		this.valorVenda = valorVenda;
	}

	@Override
	public Double receberPgto() {
		// Aplicação do strategy. Descobre a forma de calcular o salário de
		// acordo com a estratégia definida no enum do tipo de cargo.
		Double valorSalario = tipoCargo.getCalculadorDeSalario().calcula(this);
		return valorSalario;
	}

	@Override
	public Double calcularCustoTotalHierarquia() {
		// Calcula o valor de pagamento de todos os itens, primeiro calculando o
		// atual e depois chamando o cálculo de cada subordinado.
		Double custo = receberPgto();
		for (ICargo iCargo : listaSubordinados) {
			custo += iCargo.calcularCustoTotalHierarquia();
		}

		return custo;
	}

	public void adicionarSubordinado(ICargo subordinado) {
		this.listaSubordinados.add(subordinado);
	}

	public void adicionarSubordinado(ICargo... subordinados) {
		this.listaSubordinados.addAll(Arrays.asList(subordinados));
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public TipoCargoEnum getTipoCargo() {
		return tipoCargo;
	}

	public void setTipoCargo(TipoCargoEnum tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

}
