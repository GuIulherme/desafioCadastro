package cadastroProjeto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Pet {

	private String nome;
	private String sobrenome;
	private TipoPet tipoPet;
	private SexoPet sexoPet;
	private String rua;
	private String nmrCasa;
	private String cidade;
	private String idade;
	private String peso;
	private String raca;
	
	public Pet(String nome, String sobrenome, TipoPet tipoPet, SexoPet sexoPet, String rua, String nmrCasa, 
			String cidade, String idade, String peso, String raca) {
		super();
		this.sobrenome = sobrenome;
		setNome(nome);
		this.tipoPet = tipoPet;
		this.sexoPet = sexoPet;
		setRua(rua);
		setNmrCasa(nmrCasa);
		setCidade(cidade);
		setIdade(idade);
		setPeso(peso);
		this.raca = raca;		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		String nomeAlto = nome.toUpperCase();
		if (nomeAlto.trim().isEmpty() || !nomeAlto.matches("[A-Z]+")) {
			nomeAlto = ("NÃO INFORMADO");
		}
		this.nome = nomeAlto;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public TipoPet getTipoPet() {
		return tipoPet;
	}
	public void setTipoPet(TipoPet tipoPet) {
		this.tipoPet = tipoPet;
	}
	
	public SexoPet getSexoPet() {
		return sexoPet;
	}
	public void setSexoPet(SexoPet sexoPet) {
		this.sexoPet = sexoPet;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		if (rua.trim().isEmpty()) 
			this.rua = ("NÃO INFORMADO");
		else
			this.rua = rua;
	}
	
	public String getNmrCasa() {
		return nmrCasa;
	}
	public void setNmrCasa(String nmrCasa) {
		if (nmrCasa.trim().isEmpty()) 
			nmrCasa = ("NÃO INFORMADO");
		this.nmrCasa = nmrCasa;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		if (cidade.trim().isEmpty()) 
			cidade = ("NÃO INFORMADO");
		this.cidade = cidade;
	}
	
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade)  {
		if (Integer.parseInt(idade) > 20) {
			throw new IllegalArgumentException("idade deve ser entre 0 e 20 anos");
		} 
		this.idade = idade;
	}
	
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		if (Double.parseDouble(peso) > 60 || Double.parseDouble(peso) < 0.5) {
			throw new IllegalArgumentException("Peso invalido!");
		}
		this.peso = peso;
	}
	
	public String getraca() {
		return raca;
	}
	public void setraca(String raca) {
		this.raca = raca;
	}
	
	public void escrever(String nome, String sobrenome, TipoPet tipoPet, SexoPet sexoPet, String rua, String nmrCasa, 
			String cidade, String idade, String peso, String raca) {
			File arquivo = new File(nome + ".txt");
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
				writer.write("1 - " + nome + " " + sobrenome);
				writer.newLine();
				writer.write("2 - " + tipoPet);
				writer.newLine();
				writer.write("3 - " + sexoPet);
				writer.newLine();
				writer.write("4 - Rua " + rua + ", " + nmrCasa + ", " + cidade);
				writer.newLine();
				writer.write("5 - " + idade + " anos");
				writer.newLine();
				writer.write("6 - " + peso + " kg");
				writer.newLine();
				writer.write("7 - " + raca);				
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		
		}
	}


