package exercicio02;

import java.util.Scanner;

// ANALISAR ERRO APÓS EXECUÇÃO DO MENU:
/*
Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.Scanner.throwFor(Scanner.java:941)
	at java.base/java.util.Scanner.next(Scanner.java:1598)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2263)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2217)
	at Aula01/exercicio02.Main.menu(Main.java:46)
	at Aula01/exercicio02.Main.main(Main.java:12)
*/

public class Main {
	static Livro livro = new Livro();
	static int vendas;
	
	public static void main(String[] args) {
		int menu;
		do {
			menu = menu();
			switch (menu) {
			case 1:
				cadastrar();
				break;
			case 2:
				vender();
				break;
			case 3:
				balanco();
				break;
			case 4:
				alterarImposto();
				break;
			case 5:
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		} while (menu !=5);
			System.out.println("Saindo...");
		}
	
	public static int menu() {
		try (Scanner scanner = new Scanner(System.in)) {
		System.out.println("= = = = Bem­vindo(a) ao Livraria P2 = = = ="
				+ "\n Digite a opcao desejada:"
				+ "\n 1 - Cadastrar um Livro"
				+ "\n 2 ­ Vender um Livro"
				+ "\n 3 - Imprimir Balanco"
				+ "\n 4 - Alterar Impostos"
				+ "\n 5 - Sair"
				+ "\n Opcao: ");
		return scanner.nextInt();
		}
	}
	
	public static void cadastrar() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("= = = = Cadastro de Livros = = = =" 
					+ "/nDigite o nome do livro: ");
			String nome = scanner.next();
			System.out.println("Digite o preço unitario do livro: ");
			double preco = scanner.nextFloat();
			System.out.println("Digite a quantidade de livros: ");
			int quantidade = scanner.nextInt();
			livro.setNome(nome);
			livro.setPreco(preco);
			livro.setQuantidade(quantidade);
			System.out.println("*** " + quantidade + " livros com o titulo " + nome + " custando R$ " + preco + " cadastrados com sucesso.");
			System.out.printf("*** Imposto por cada livro: R$%.2f", livro.calculoImpostos());
			System.out.printf("*** Imposto ISS: R$%.2f", (livro.calculoISS() * quantidade));
			System.out.printf("*** Imposto XLP: R$%.2f", (livro.calculoXLP() * quantidade));
			System.out.printf("*** Valor com impostos de cada livro e: R$%.2f", (livro.calculoImpostos() + preco));
		}
	}
	
	public static void vender() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite a quantidade de livros vendidos: ");
			int quantidade = scanner.nextInt();
			if (quantidade > livro.getQuantidade()) {
				System.out.println("Estoque insuficiente");
			} else {
				livro.setQuantidade(livro.getQuantidade() - quantidade);
				vendas = vendas + quantidade;
			}
		}
	}
	
	public static void balanco() {
		System.out.println("*** Foram vendidos " + vendas + " livros " + livro.getNome()
					+ "\n*** O valor total das vendas foi de R$" + (vendas * livro.calculoImpostos())
					+ "\n*** O valor das vendas sem considerar os impostos e R$" + (vendas * livro.getPreco()));
	}
	
	public static void alterarImposto() {
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite a nova porcentagem do ISS: ");
			int iss = scanner.nextInt();
			System.out.println("Digite a nova porcentagem do XLP: ");
			int xlp = scanner.nextInt();
			livro.setImpostos(iss, xlp);
			System.out.println("*** Imposto ISS alterado para " + iss + "% do valor de cada livro"
					+ "\n*** Imposto XLP alterado para " + xlp + "% do valor de cada livro");
		}
	}
}