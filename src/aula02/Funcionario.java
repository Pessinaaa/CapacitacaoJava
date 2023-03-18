package aula02;

import java.math.BigDecimal;

public class Funcionario extends Pessoa{
	
	private BigDecimal salario;
	private String matriculaFuncional;
	
	public Funcionario(String nome, String cpf, int idade, BigDecimal salario, String matriculaFuncional) {
		super(nome, cpf, idade);
		this.salario = salario;
		this.matriculaFuncional = matriculaFuncional;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getMatriculaFuncional() {
		return matriculaFuncional;
	}

	public void setMatriculaFuncional(String matriculaFuncional) {
		this.matriculaFuncional = matriculaFuncional;
	}
	
	public boolean declaraImpostoRenda() {
		BigDecimal valorBase = new BigDecimal("2640");
		int resultadoCompareTo = this.salario.compareTo(valorBase);
		if (resultadoCompareTo == -1) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Funcionario [nome= " + super.getNome() + ", cpf= " + super.getCpf() + ", idade= " + super.getIdade() + ", salario= " + salario + ", matricula funcional= " + matriculaFuncional + "]";
	}
}
