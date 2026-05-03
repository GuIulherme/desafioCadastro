package cadastroProjeto;

import java.util.Scanner;

public class CadastroTeste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PerguntasEssenciais pe = new PerguntasEssenciais();
		DonoDoAbrigo dono = new DonoDoAbrigo();
		
		int escolha = 0;
		
		while(escolha != 6) {
		System.out.println("Escolha uma opção: ");
		System.out.println("1. Cadastrar um novo pet");
		System.out.println("2. Alterar os dados do pet cadastrado");
		System.out.println("3. Deletar um pet cadastrado");
		System.out.println("4. Listar todos os pets cadastrados");
		System.out.println("5. Listar pets por algum critério (idade,nome, raça)");
		System.out.println("6. Sair");
		
		if (sc.hasNextInt()) {
			escolha = sc.nextInt();
			System.out.println("Opção " + escolha + " selecionada");
		} else {
			System.out.println("Apenas numeros inteiros são aceitos!");
		}
		
		if (escolha <= 0) {
			System.out.println("Número inválido!!");
		}
		else if (escolha > 6) {
			System.out.println("Apenas numeros de 1 a 6 são aceitos");
		}
		else if (escolha == 1) { 
			pe.LerArquivo();
			dono.cadastrarPet();
		}
		
		
		}
		System.out.println("Saindo...");
	}

}
