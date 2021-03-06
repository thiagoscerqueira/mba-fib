package br.edu.fib.atividadesDesignPatterns.visitor;

import br.edu.fib.atividadesDesignPatterns.visitor.interfaces.IPeriferico;
import br.edu.fib.atividadesDesignPatterns.visitor.interfaces.IPerifericoVisitor;

/**
 * Classe que representa um componente "Teclado" do computador. Há apenas um
 * método implementado. Esse método é responsável pela execução da ação definida
 * no parâmetro passado. Essa operação é denominada visitação.
 */
public class Teclado implements IPeriferico {
	@Override
	public void accept(IPerifericoVisitor visitor) {
		visitor.visitar(this);
	}
}
