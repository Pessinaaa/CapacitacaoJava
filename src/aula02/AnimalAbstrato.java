package aula02;

public abstract class AnimalAbstrato {
	protected int patas;
	
	public abstract void emitirSom();
	
	public int getPatas() {
		return this.patas;
	}
}
