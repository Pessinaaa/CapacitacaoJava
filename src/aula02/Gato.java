package aula02;

public class Gato implements Animal{
	@Override
	public void emitirSom() {
		System.out.println("O gato mia");
	}
	
	@Override
	public int retornaIdade() {
		return 1;
	}
}
