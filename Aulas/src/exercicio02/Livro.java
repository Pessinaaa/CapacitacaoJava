package exercicio02;

public class Livro {
	private String nome;
	private double preco;
	private int quantidade;
	public int ISS;
	public int XLP;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setImpostos(int iss, int xlp) {
		this.ISS = iss;
		this.XLP = xlp;
	}

	public Livro(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.ISS = 30;
		this.XLP = 5;
	}
	public Livro() {
		this.nome = null;
		this.preco = 0;
		this.quantidade = 0;
		this.ISS = 30;
		this.XLP = 5;
	}
	
	public double calculoISS() {
		return this.preco + (this.preco * (this.ISS / 100));
	}
	
	public double calculoXLP() {
		return this.preco + (this.preco * (this.XLP / 100));
	}
	
	public double calculoImpostos() {
		return this.preco + this.calculoISS() + this.calculoXLP();
	}
}
