package br.edu.fib.atividadesDesignPatterns.visitor.interfaces;

import br.edu.fib.atividadesDesignPatterns.visitor.Computador;
import br.edu.fib.atividadesDesignPatterns.visitor.Impressora;
import br.edu.fib.atividadesDesignPatterns.visitor.Monitor;
import br.edu.fib.atividadesDesignPatterns.visitor.Mouse;
import br.edu.fib.atividadesDesignPatterns.visitor.Teclado;

/**
 * Definição da interface que deve ser implementada por cada ação. Todas as
 * ações devem implementar seu código na mesma classe para cada componente. Essa
 * ação será visitada pelos componentes conforme demandado.
 */
public interface IPerifericoVisitor {
	void visitar(Computador computador);

	void visitar(Mouse mouse);

	void visitar(Teclado teclado);

	void visitar(Monitor monitor);

	void visitar(Impressora impressora);
}
