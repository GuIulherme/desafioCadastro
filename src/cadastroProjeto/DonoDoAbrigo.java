package cadastroProjeto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;


public class DonoDoAbrigo {

	private ArrayList<Pet> pets = new ArrayList<>();
	
	private static final String NAO_INFORMADO = "NAO INFORMADO";
	
	public void ImprimirPet(int indice) {
		// ler um arquivo, listar as linhas dele, se o pet tiver em alguma parte o criterio selecionado, deve mostrar ele completo
		System.out.println(pets.get(indice).getNome() + " " + pets.get(indice).getSobrenome() + " - " + pets.get(indice).getTipoPet() + " - " + pets.get(indice).getSexoPet() + " - Rua " + pets.get(indice).getRua() + ", "
						  + pets.get(indice).getNmrCasa() + " - " + pets.get(indice).getCidade() + " - " + pets.get(indice).getIdade() + " anos - " + pets.get(indice).getPeso() + "kg - " + pets.get(indice).getRaca());
	}
	
	private String lerSomenteLetras(Scanner sc, String mensagem) {
				
		while(true) {
			System.out.println(mensagem);
			String texto = sc.nextLine().trim();
			
			if (texto.isEmpty()) 
				return NAO_INFORMADO;
		    if (texto.matches("[A-Za-zÀ-ÿ ]+")) 
		    	return texto.toUpperCase();
		     
			System.out.println("Use somente letras");
		}
	}
	
	private String lerNumeros(Scanner sc, String mensagem) {
		
		System.out.println(mensagem);
		
		while(true) {
			String texto = sc.nextLine().trim();
						
			if (texto.isEmpty()) 
				return NAO_INFORMADO;
			if (texto.matches("^[0-9.]+$"))
				return texto;
			
			System.out.println("Use somente numeros");
		}
	}
	
	public void cadastrarPet(Scanner sc){
		
		TipoPet tipoPet = null;
		SexoPet sexoPet = null;
		
		String nome = lerSomenteLetras(sc, "Nome: ");
		String sobrenome = lerSomenteLetras(sc, "Sobrenome: ");
		
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

		System.out.println("Cidade: ");
		String cidade = sc.nextLine();
		System.out.println("Rua: ");
		String rua = sc.nextLine();
		
		String nmrCasa = lerNumeros(sc, "Numero da casa: ");
		String peso = lerNumeros(sc, "Peso: ");
		String idade = lerNumeros(sc, "Idade: ");

		System.out.println("Raça: ");
		String raca = sc.nextLine();
		Pet petNovo = new Pet(nome, sobrenome, tipoPet, sexoPet, nmrCasa, cidade, rua, idade, peso, raca);
		pets.add(petNovo);	
		
		escrever(petNovo);		
	}
	
	private void escrever(Pet pet) {
		
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
			writer.write("7 - " + pet.getRaca());		
			System.out.println("ARQUIVO CRIADO COM SUCESSO");
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} 
	
	}
	
	// Mostra pets que batem com o criterio
	public void buscarPet(Criterio[] criterio) {
		
		Pesquisa pesquisa = new Pesquisa();
		//pets.get(0).ImprimirPet();

		for (int i = 0; i < pets.size(); i ++) {
			
			boolean encontrou = false;
			
			for (int j = 0; j < criterio.length; j++) {
				
				if (pesquisa.verificaCriterio(pets.get(i), criterio[j])) {
					 encontrou = true;
				}
			}
			if(encontrou) {
				System.out.print(i + " - ");
				ImprimirPet(i);
			}
		}
		
	}
	
	// Menu onde o usuario vai escolher criterios para busca
	public static Criterio[] selecionaCriterio(Scanner sc) {
				
		System.out.println("Quantos critérios? (1 ou 2)");
		int qtd = sc.nextInt();
		sc.nextLine(); 
		
		Criterio[] criterio = new Criterio[qtd];
		
		for (int i = 0; i < criterio.length; i++) {
			for (TipoBusca tipo : TipoBusca.values()) {
					System.out.println("- " + tipo);
			}
			
			System.out.println("Escreva o tipo do criterio: ");
			TipoBusca escolha = TipoBusca.valueOf(sc.nextLine().toUpperCase());
			System.out.println("Escreva o que deve ser procurado nesse criterio: ");
			String valor = sc.nextLine();
			
			criterio[i] = new Criterio(escolha,valor);
		}

		return criterio;
		
	}

	// altera um dado do pet
	public boolean alterarPet(int indice, TipoBusca escolha, Scanner sc) {
		

		switch(escolha) {
			case NOME:
				System.out.println("Digite o novo nome do pet: ");
				String novo_nome = sc.nextLine();
				pets.get(indice).setNome(novo_nome);
				return true;

			case SOBRENOME:
				System.out.println("Digite o novo sobrenome do pet: ");
				String novo_sobrenome = sc.nextLine();
				pets.get(indice).setSobrenome(novo_sobrenome);
				return true;

			case RUA:
				System.out.println("Digite a nova rua do pet: ");
				String nova_rua = sc.nextLine();
				pets.get(indice).setRua(nova_rua);
				return true;
				
			case NUMERO:
				System.out.println("Digite o novo numero do endereço do pet: ");
				String novo_nmr = sc.nextLine();
				pets.get(indice).setNmrCasa(novo_nmr);
				return true;
				
			case CIDADE:
				System.out.println("Digite a nova cidade do pet: ");
				String nova_cidade = sc.nextLine();
				pets.get(indice).setCidade(nova_cidade);
				return true;

			case IDADE:
				System.out.println("Digite a nova idade do pet: ");
				String nova_idade = sc.nextLine();
				pets.get(indice).setIdade(nova_idade);
				return true;

			case PESO:
				System.out.println("Digite o novo peso do pet: ");
				String novo_peso = sc.nextLine();
				pets.get(indice).setPeso(novo_peso);
				return true;
				
			case RACA:
				System.out.println("Digite a nova raça do pet: ");
				String nova_raca = sc.nextLine();
				pets.get(indice).setRaca(nova_raca);	
				return true;
			
			case TIPO:
				return false;
				
			case SEXO:
				return false;
		}
		
		return false;
	}
	
	// Função que deleta um pet
	public boolean deletarPet(int indice) {

	    if (indice >= 0 && indice < pets.size()) {
	        pets.remove(indice);
	        return true;
	    }

	    return false;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
		
	// Vai imprimir os dados do pet e o usuario vai escolher qual dado quer alterar
	/*public void alterarPet(int indice) {
		
		Scanner sc = new Scanner(System.in);
		boolean alterando = true;
		
		while (alterando) {
		
			pets.get(indice).ImprimirPet();
			System.out.println("Quais dados deseja alterar?");
			for (TipoBusca tipo : TipoBusca.values()) {
				if (tipo != TipoBusca.TIPO || tipo != TipoBusca.SEXO)
					System.out.println("- " + tipo);
			}
					
			TipoBusca escolha = TipoBusca.valueOf(sc.next().toUpperCase());
			
			switch(escolha) {
				case NOME:
					System.out.println("Digite o novo nome do pet: ");
					String novo_nome = sc.nextLine();
					pets.get(indice).setNome(novo_nome);
	
				case SOBRENOME:
					System.out.println("Digite o novo sobrenome do pet: ");
					String novo_sobrenome = sc.nextLine();
					pets.get(indice).setSobrenome(novo_sobrenome);
	
				case RUA:
					System.out.println("Digite a nova rua do pet: ");
					String nova_rua = sc.nextLine();
					pets.get(indice).setRua(nova_rua);
					
				case NUMERO:
					System.out.println("Digite o novo numero do endereço do pet: ");
					String novo_nmr = sc.nextLine();
					pets.get(indice).setNmrCasa(novo_nmr);
					
				case CIDADE:
					System.out.println("Digite a nova cidade do pet: ");
					String nova_cidade = sc.nextLine();
					pets.get(indice).setCidade(nova_cidade);
	
				case IDADE:
					System.out.println("Digite a nova idade do pet: ");
					String nova_idade = sc.nextLine();
					pets.get(indice).setIdade(nova_idade);
	
				case PESO:
					System.out.println("Digite o novo peso do pet: ");
					String novo_peso = sc.nextLine();
					pets.get(indice).setPeso(novo_peso);
					
				case RACA:
					System.out.println("Digite a nova raça do pet: ");
					String nova_raca = sc.nextLine();
					pets.get(indice).setRaca(nova_raca);		
			}
			
			System.out.println("Deseja continuar alterando os dados do pet? (1 para sim, 0 para não)");
			if (sc.nextInt() == 0)
				alterando = false;
		}

		
	}*/
	

}
