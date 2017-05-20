package br.edu.fib.atividadesDesignPatterns.adapterExercise;

/**
 * Created by ricardo on 4/18/17.
 */

class TomadaDeDoisPinos {
	public void ligarNaTomadaDeDoisPinos() {
		System.out.println("Ligado na Tomada de Dois Pinos");
	}
}

class TomadaDeTresPinos {
	public void ligarNaTomadaDeTresPinos() {
		System.out.println("Ligado na Tomada de Tres Pinos");
	}
}

class AdapterTomada extends TomadaDeDoisPinos {

	private TomadaDeTresPinos tomadaDeTresPinos;

	public AdapterTomada(TomadaDeTresPinos tomadaDeTresPinos) {
		this.tomadaDeTresPinos = tomadaDeTresPinos;
	}

	@Override
	public void ligarNaTomadaDeDoisPinos() {
		this.tomadaDeTresPinos.ligarNaTomadaDeTresPinos();
	}
}

public class AdapterExercise {
	public static void main(String args[]) {
		TomadaDeTresPinos t3 = new TomadaDeTresPinos();

		AdapterTomada a = new AdapterTomada(t3);
		a.ligarNaTomadaDeDoisPinos();
	}
}
