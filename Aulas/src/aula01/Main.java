package aula01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Classe iniciada");
		//hello();
		
		Motorista motorista = new Motorista("José", 30, "12345");
		Carro carro = new Carro("Maria", "modelo1", "preta", 2022);
		motorista.cadastrarCarroPrincipal(carro);
		System.out.println(motorista.toString());
		motorista.alteraStatus(TipoStatusEnum.TRISTE);
		System.out.println(motorista.toString());
	}
	
public static void hello() {
	Scanner leitor = new Scanner(System.in);
	System.out.println("Digite seu nome: ");
	String nome = leitor.next();
	System.out.println("ola, " + nome);
}
}