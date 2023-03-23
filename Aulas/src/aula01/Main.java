package aula01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Classe iniciada");
		hello();
	}
	
public static void hello() {
	Scanner leitor = new Scanner(System.in);
	System.out.println("Digite seu nome: ");
	String nome = leitor.next();
	System.out.println("ola, " + nome);
}
}