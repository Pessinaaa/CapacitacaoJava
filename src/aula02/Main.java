package aula02;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario("Pedro", "11122233344", 19, new BigDecimal(2000), "12345");
		Pessoa funcionario2 = new Funcionario("Pedro", "11122233344", 17, new BigDecimal(3000), "12345");
		Pessoa funcionario3 = new Pessoa("Pedro", "11122233344", 19);
		
		System.out.println(funcionario.toString());
		System.out.println(funcionario2.toString());
		System.out.println(funcionario3.toString());
		
		imprimePelaIdade(funcionario);
		imprimePelaIdade(funcionario2);
		
		imprimePeloImposto(funcionario);
		//imprimePeloImposto(funcionario2); não funciona pois funcionario2 é do tipo pessoa
		
		Cachorro cachorro = new Cachorro();
		Animal animal = new Cachorro();
				
		cachorro.emitirSom();
		animal.emitirSom();
		
		animal = new Gato();
		animal.emitirSom();
		
		Aranha aranha = new Aranha();
		aranha.emitirSom();
		
		List<Animal> animais = new ArrayList<Animal>();
		System.out.println(animais.size());
		animais.add(cachorro);
		animais.add(animal);
		System.out.println(animais.size());
		for (Animal i : animais) {
			i.emitirSom();
		}
	}
	
	public static void imprimePelaIdade(Pessoa pessoa) {
		if (pessoa.Maioridade()) {
			System.out.println(String.format("%s e maior de idade", pessoa.getNome()));
		} else {
			System.out.println(String.format("%s nao e maior de idade", pessoa.getNome()));
		}
	}
	
	public static void imprimePeloImposto(Funcionario funcionario) {
		if (funcionario.declaraImpostoRenda()) {
			System.out.println(String.format("%s paga imposto de renda", funcionario.getNome()));
		} else {
			System.out.println(String.format("%s nao paga imposto de renda", funcionario.getNome()));
		}
	}
}
