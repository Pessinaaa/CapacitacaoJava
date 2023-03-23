package aula01;

public class Motorista {
	
	private String nome;
	private int idade;
	private String CNH;
	private Carro carroPrincipal;
	
	private TipoStatusEnum status;
	
	public Motorista(String nome, int idade, String CNH) {		
		this.nome = nome;
		this.idade = idade;
		this.CNH = CNH;
		this.status = TipoStatusEnum.TRANQUILO;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCNH() {
		return CNH;
	}
	
	public void setCNH(String CNH) {
		this.CNH = CNH;
	}
	
	public void cadastrarCarroPrincipal(Carro carro) {
		this.carroPrincipal = carro;
	}
	
	public Carro getCarroPrincipal() {
		return carroPrincipal;
	}

	public void setCarroPrincipal(Carro carroPrincipal) {
		carroPrincipal = carroPrincipal;
	}
	
	public void alteraStatus(TipoStatusEnum statusNovo) {
		this.status = statusNovo;
	}

	
	public void acelerar(double velocidade) {
	}

	public void frear(double velocidade) {
		this.carroPrincipal.frear(velocidade);
	}

	@Override
	public String toString() {
		return "Motorista [nome=" + nome + ", idade=" + idade + ", CNH=" + CNH + ", carroPrincipal=" + carroPrincipal
				+ ", status=" + status + "]";
	}
}