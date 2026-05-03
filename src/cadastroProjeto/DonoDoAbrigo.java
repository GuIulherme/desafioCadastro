package cadastroProjeto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;


public class DonoDoAbrigo {
	Scanner sc = new Scanner(System.in);

	private ArrayList<Pet> pet = new ArrayList<>();
	
	public void cadastrarPet(){
		TipoPet tipoPet = null;
		SexoPet sexoPet = null;
		String nome = "";		
		String sobrenome = "";
		String idade = "";
		String peso = "";
		
		while (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || 
			   !(nome.matches("[A-Z]+")) || !(sobrenome.matches("[A-Z]+")) ) {
			
			System.out.println("Nome: ");
			nome = sc.nextLine().toUpperCase();
			System.out.println("Sobrenome: ");
			sobrenome = sc.nextLine().toUpperCase();
			
			if (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || 
				!(nome.matches("[A-Z]+")) || !(sobrenome.matches("[A-Z]+"))) {

				System.out.println("Nome e sobrenome não podem ser invalidos");
				idade = "";
				sobrenome = "";
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
		
		System.out.println("Numero da casa: "); // garantir que seja só numero
		String nmrCasa = sc.nextLine();
		System.out.println("Cidade: ");
		String cidade = sc.nextLine();
		System.out.println("Rua: ");
		String rua = sc.nextLine();
		
		while (idade.trim().isEmpty() || !(idade.matches("^[0-9.]+$")) ) {
			System.out.println("Idade: "); 
			idade = sc.nextLine();
		}

		while (peso.trim().isEmpty() || !(peso.matches("^[0-9.]+$")) ) {
			System.out.println("peso: "); 
			peso = sc.nextLine();
		}

		System.out.println("Raça: ");
		String raca = sc.nextLine();
		Pet petNovo = new Pet(nome, sobrenome, tipoPet, sexoPet, nmrCasa, cidade, rua, idade, peso, raca);
		pet.add(petNovo);	
		
		escrever(petNovo);		
	}
	
	public void escrever(Pet pet) {
		
		Calendar cal = Calendar.getInstance();
		File pasta = new File("PetsCadastrados");
		
		File arquivo = new File(pasta, cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DAY_OF_MONTH) + "T" 
								+ cal.get(Calendar.HOUR) + cal.get(Calendar.MINUTE) + "-" 
								+ pet.getNome().toUpperCase() + pet.getSobrenome().toUpperCase() + ".TXT");
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
			writer.write("1 - " + pet.getNome() + " " + pet.getSobrenome());
			writer.newLine();
			writer.write("2 - " + pet.getTipoPet());
			writer.newLine();
			writer.write("3 - " + pet.getSexoPet());
			writer.newLine();
			writer.write("4 - Rua " + pet.getRua() + ", " + pet.getNmrCasa() + ", " + pet.getCidade());
			writer.newLine();
			writer.write("5 - " + pet.getCidade() + " anos");
			writer.newLine();
			writer.write("6 - " + pet.getPeso() + " kg");
			writer.newLine();
			writer.write("7 - " + pet.getraca());		
			System.out.println("ARQUIVO CRIADO COM SUCESSO");
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} 
	
	}
	
	public void buscarPet() {
		//acessar arquivos de pets cadastrados, procurar neles os padrões escritos, fazer um while, enquanto todos não forem encontrados, ela ira enumerar e listar todas as caracteristicas dos pets que correspondem as pesquisas
		
	}
	public void deletarPet() {
		
	}
	public void listarTodosPet() {
		
	}
	public void listarPetPorCriterio() {
		
	}
}
