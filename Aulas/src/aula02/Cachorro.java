package aula02;

public class Cachorro implements Animal {
	@Override
	public void emitirSom() {
		System.out.println("O cachorro late");
	}
	
	@Override
	public int retornaIdade() {
		return 0;
	}
}
