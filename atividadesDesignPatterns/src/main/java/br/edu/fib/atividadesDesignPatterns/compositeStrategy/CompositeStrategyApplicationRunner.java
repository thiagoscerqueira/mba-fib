package br.edu.fib.atividadesDesignPatterns.compositeStrategy;

import br.edu.fib.atividadesDesignPatterns.compositeStrategy.model.CargoComposite;
import br.edu.fib.atividadesDesignPatterns.compositeStrategy.model.TipoCargoEnum;

/**
 * Classe responsável por instanciar os objetos e executar os métodos de cálculo
 * 
 * @author thiago
 *
 */
public class CompositeStrategyApplicationRunner {

	public static void main(String[] args) {
		CargoComposite presidencia = new CargoComposite(TipoCargoEnum.PRESIDENCIA, 15000d);
		CargoComposite diretorComercial = new CargoComposite(TipoCargoEnum.DIRETOR_COMERCIAL, 5500d, 20d, 12300d);
		CargoComposite diretorProducao = new CargoComposite(TipoCargoEnum.DIRETOR_PRODUCAO, 4000d);

		CargoComposite vendedor1 = new CargoComposite(TipoCargoEnum.VENDEDOR, 3000d, 8d, 16400d);
		CargoComposite vendedor2 = new CargoComposite(TipoCargoEnum.VENDEDOR, 2500d, 10d, 8900d);

		CargoComposite desenvolvedor1 = new CargoComposite(TipoCargoEnum.DESENVOLVEDOR, 1500d);
		CargoComposite desenvolvedor2 = new CargoComposite(TipoCargoEnum.DESENVOLVEDOR, 2500d);
		CargoComposite desenvolvedor3 = new CargoComposite(TipoCargoEnum.DESENVOLVEDOR, 2000d);

		presidencia.adicionarSubordinado(diretorComercial, diretorProducao);
		diretorComercial.adicionarSubordinado(vendedor1, vendedor2);
		diretorProducao.adicionarSubordinado(desenvolvedor1, desenvolvedor2, desenvolvedor3);

		System.out.println("Valor pagamento Presidência: " + presidencia.receberPgto());
		System.out.println("Valor pagamento Diretor Comercial: " + diretorComercial.receberPgto());
		System.out.println("Valor pagamento Diretor Produção: " + diretorProducao.receberPgto());
		System.out.println("Valor pagamento Vendedor 1: " + vendedor1.receberPgto());
		System.out.println("Valor pagamento Vendedor 2: " + vendedor2.receberPgto());
		System.out.println("Valor pagamento Desenvolvedor 1: " + desenvolvedor1.receberPgto());
		System.out.println("Valor pagamento Desenvolvedor 2: " + desenvolvedor2.receberPgto());
		System.out.println("Valor pagamento Desenvolvedor 3: " + desenvolvedor3.receberPgto());

		System.out.println(
				"Custo total da hierarquia desde a Presidência: " + presidencia.calcularCustoTotalHierarquia());
		System.out.println("Custo total da Diretoria Comercial: " + diretorComercial.calcularCustoTotalHierarquia());
		System.out.println("Custo total da Diretoria de Produção: " + diretorProducao.calcularCustoTotalHierarquia());
	}
}
