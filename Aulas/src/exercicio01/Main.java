package exercicio01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	System.out.println(ehPar(lerNumeros()));
	geraSequencia(90);
	geraSequenciaOmitindoImpares(90);
	}
	
	public static int lerNumeros() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite um numero: ");
		int numero = leitor.nextInt();
		return numero;
	}
	
	public static boolean ehPar(int numero) {
		if (numero % 2 == 0) {
			return true;
		}
		return false;
	}
	
	public static void geraSequencia(int numero) {
		while (numero <= 100) {
			System.out.println(numero);
			numero++;
		}
	}
	
	public static void geraSequenciaOmitindoImpares(int numero) {
		while (numero <= 100) {
			if (ehPar(numero)) {
				System.out.println(numero);
			}
			numero++;
		}
	}
}
