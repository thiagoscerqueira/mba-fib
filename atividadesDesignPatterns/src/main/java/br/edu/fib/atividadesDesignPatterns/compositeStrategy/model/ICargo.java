package br.edu.fib.atividadesDesignPatterns.compositeStrategy.model;

/**
 * Interface que define os métodos comuns a todos os cargos.
 * 
 * @author thiago
 *
 */
public interface ICargo {

	/**
	 * Calcula o valor de pagamento do item isoladamente, sem considerar o
	 * restante da hierarquia
	 * 
	 * @return Valor do pagamento do item
	 */
	public Double receberPgto();

	/**
	 * Calcula o valor do custo (valor de pagamento) de toda a hierarquia a
	 * partir do nó atual até as folhas.
	 * 
	 * @return Valor do pagamento da hierarquia.
	 */
	public Double calcularCustoTotalHierarquia();

}
