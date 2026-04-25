package cadastroProjeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PerguntasEssenciais {
	
	private File arquivo;
	
	
	public PerguntasEssenciais() {
		this.arquivo = new File("ArquivosTexto/perguntas.txt");
		this.CriarArquivo();
		this.EscreverArquivo();
		
	}

	private void CriarArquivo() {
		try {
			boolean criado = arquivo.createNewFile();
			System.out.println(criado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void EscreverArquivo() {
		
		try (FileWriter fw = new FileWriter(arquivo); BufferedWriter bw = new BufferedWriter(fw) ){
			bw.write("1 - Qual o nome e sobrenome do pet?");
			bw.newLine();
			bw.write("2 - Qual o tipo do pet (Cachorro/Gato)?");
			bw.newLine();	
			bw.write("3 - Qual o sexo do animal?");
			bw.newLine();
			bw.write("4 - Qual endereço e bairro que ele foi encontrado?");
			bw.newLine();
			bw.write("5 - Qual a idade aproximada do pet?");
			bw.newLine();
			bw.write("6 - Qual o peso aproximado do pet?");
			bw.newLine();
			bw.write("7 - Qual a raça do pet?");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void LerArquivo() {
		try(FileReader fr = new FileReader(arquivo); BufferedReader br = new BufferedReader(fr)){
			String linha;
			while((linha = br.readLine()) != null) {
				System.out.println(linha);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
