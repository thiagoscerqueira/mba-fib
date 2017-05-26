package br.edu.fib.atividadesDesignPatterns.observer;

import java.util.Vector;

interface IEscola {
	void executarAcao();
}

class BoletimEscolar implements IEscola {

	@Override
	public void executarAcao() {
		System.out.println("Gerando o boletim escolar dos alunos");
	}
}

class NotificacaoPais implements IEscola {

	@Override
	public void executarAcao() {
		System.out.println("Disparando notificação aos pais");
	}
}

class Matricula implements IEscola {

	@Override
	public void executarAcao() {
		System.out.println("Realizando as matrículas do próximo ano");
	}
}

class Observer {

	Vector<IEscola> listeners = new Vector<>();

	public void registrar(IEscola item) {
		listeners.addElement(item);
	}

	public void gerarFimdeAno() {
		for (IEscola iEscola : listeners) {
			iEscola.executarAcao();
		}
	}
}

public class ExercicioObserver {
	public static void main(String args[]) {

		Observer o = new Observer();
		o.registrar(new BoletimEscolar());
		o.registrar(new NotificacaoPais());
		o.registrar(new Matricula());

		o.gerarFimdeAno();
	}
}
