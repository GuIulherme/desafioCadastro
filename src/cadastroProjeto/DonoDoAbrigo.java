package cadastroProjeto;

import java.util.ArrayList;
import java.util.Scanner;

public class DonoDoAbrigo {
	Scanner sc = new Scanner(System.in);

	private ArrayList<Pet> pet;
	
	public void cadastrarPet(){
		TipoPet tipoPet = null;
		SexoPet sexoPet = null;
		String nome = null;		
		String sobrenome = null;
		
		while (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || 
			   !(nome.matches("[A-Z]+")) || !(sobrenome.matches("[A-Z]+")) ) {
			
			System.out.println("Nome: ");
			nome = sc.nextLine().toUpperCase();
			System.out.println("Sobrenome: ");
			sobrenome = sc.nextLine().toUpperCase();
			
			if (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || 
				!(nome.matches("[A-Z]+")) || !(sobrenome.matches("[A-Z]+"))) {
				System.out.println("Nome e sobrenome não podem ser invalidos");
			}
			
		}
		
		
		while (tipoPet == null) {
			System.out.println("Tipo: ");
			try {
				tipoPet = TipoPet.valueOf(sc.nextLine().toUpperCase());
			}	
			catch (IllegalArgumentException e) {
			    System.out.println("Tipo inválido! Use GATO ou CACHORRO.");
			}
		}
		
		while (sexoPet == null) {
			System.out.println("Sexo do animal (masculino/feminino): "); // deixar em uppercase
			try {
				sexoPet = SexoPet.valueOf(sc.nextLine().toUpperCase());
			}	
			catch (IllegalArgumentException e) {
			    System.out.println("Tipo inválido! Use MASCULINO ou FEMININO.");
			}
		}
		
		System.out.println("Numero da casa: ");
		String nmrCasa = sc.nextLine();
		System.out.println("Cidade: ");
		String cidade = sc.nextLine();
		System.out.println("Rua: ");
		String rua = sc.nextLine();
		System.out.println("Idade: "); // colocar as parada
		int idade = sc.nextInt();
		System.out.println("Peso: "); // só numeros
		Double peso = sc.nextDouble();
		System.out.println("Raça: ");
		String raca = sc.nextLine();
		Pet petNovo = new Pet(nome, sobrenome, tipoPet, sexoPet, nmrCasa, cidade, rua, idade, peso, raca);
		pet.add(petNovo);	
		
	}
	public void buscarPet() {
		
	}
	public void deletarPet() {
		
	}
	public void listarTodosPet() {
		
	}
	public void listarPetPorCriterio() {
		
	}
}
