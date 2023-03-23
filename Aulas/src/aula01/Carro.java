package aula01;

public class Carro {
	private String proprietario;
	private String modelo;
	private String cor;
	private double kilometros;
	private double velocidade;
	private int ano;
	
	public Carro(String proprietario, String modelo, String cor, int ano) {		
		this.proprietario = proprietario;
		this.modelo = modelo;
		this.cor = cor;
		this.kilometros = 0;
		this.velocidade = 0;
		this.ano = ano;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}	

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}

	public double getVelocidade() {
		return velocidade;
	}

	@Override
	public String toString() {
		return "Carro [proprietario=" + proprietario + ", modelo=" + modelo + ", cor=" + cor + ", kilometros="
				+ kilometros + ", velocidade=" + velocidade + ", ano=" + ano + "]";
	}

	public void acelerar(double velocidade) {
		System.out.println("Acelerando...");		
		this.velocidade = this.velocidade + velocidade;		
		this.kilometros = this.kilometros + velocidade;
	}

	public void frear(double velocidade) {
		System.out.println("Freando...");
		
		if ((this.velocidade - velocidade) < 0) {
			this.velocidade = 0;
			System.out.println("Carro parado");
		}
		
		else {
			this.velocidade = this.velocidade - velocidade;
		}
	}
}
