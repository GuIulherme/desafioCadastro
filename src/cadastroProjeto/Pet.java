package cadastroProjeto;

public class Pet {

	private String nome;
	private String sobrenome;
	private TipoPet tipoPet;
	private SexoPet sexoPet;
	private String rua;
	private String nmrCasa;
	private String cidade;
	private int idade;
	private double peso;
	private String raca;
	
	public Pet(String nome, String sobrenome, TipoPet tipoPet, SexoPet sexoPet, String rua, String nmrCasa, 
			String cidade, int idade, double peso, String raca) {
		super();
		this.sobrenome = sobrenome;
		setNome(nome);
		this.tipoPet = tipoPet;
		this.sexoPet = sexoPet;
		this.rua = rua;
		setNmrCasa(nmrCasa);
		this.cidade = cidade;
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
		this.rua = rua;
	}
	public String getNmrCasa() {
		return nmrCasa;
	}
	public void setNmrCasa(String nmrCasa) {
		if (nmrCasa.trim().isEmpty()) {
			nmrCasa = ("NÃO INFORMADO");
		}
		this.nmrCasa = nmrCasa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade)  {
		if (idade > 20) {
			throw new IllegalArgumentException("idade deve ser entre 0 e 20 anos");
		} 
		this.idade = idade;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		if (peso > 60 || peso < 0.5) {
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

}
