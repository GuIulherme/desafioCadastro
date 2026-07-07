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
			sc.nextLine(); 
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
			dono.cadastrarPet(sc);
		}
		else if (escolha == 2) { 
			
			Criterio[] criterios = DonoDoAbrigo.selecionaCriterio(sc);
			dono.buscarPet(criterios);
			
			System.out.println("Digite o indice do pet que voce deseja alterar: ");
			int indice = sc.nextInt();
			sc.nextLine();
			
			dono.ImprimirPet(indice);
			boolean alterando = true;
			
			while (alterando) {
				System.out.println("Quais dados deseja alterar?");
				for (TipoBusca tipo : TipoBusca.values()) {
					if (tipo != TipoBusca.TIPO || tipo != TipoBusca.SEXO)
						System.out.println("- " + tipo);
				}
				TipoBusca alteracao = TipoBusca.valueOf(sc.next().toUpperCase());
				sc.nextLine();
				dono.alterarPet(indice, alteracao, sc);
				System.out.println("Deseja continuar alterando os dados do pet? (1 para sim, 0 para não)");
				if (sc.nextInt() == 0)
					alterando = false;
			}	
		}
		else if (escolha == 3) { 
			
			Criterio[] criterios = DonoDoAbrigo.selecionaCriterio(sc);
			dono.buscarPet(criterios);
			
			System.out.println("Digite o indice do pet que voce deseja deletar: ");
			int indice = sc.nextInt();
			sc.nextLine();
			
			dono.ImprimirPet(indice);
			boolean deletando = true;
			
			while (deletando) {
				dono.deletarPet(indice);
				System.out.println("Pet deletado com sucesso!!");
				System.out.println("Deseja continuar deletando? (1 para sim, 0 para não)");
				if (sc.nextInt() == 0)
					deletando = false;				
			}
		}
		
		else if (escolha == 4) {
			for (int i=0; i < dono.getPets().size(); i++) {
				dono.ImprimirPet(i);
			}
		}
		
		else if (escolha == 5) {
			Criterio[] criterios = DonoDoAbrigo.selecionaCriterio(sc);
			dono.buscarPet(criterios);
		}
		
		}
		System.out.println("Saindo...");
	}

}
