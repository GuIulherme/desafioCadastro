package cadastroProjeto;

public class Criterio {

	private TipoBusca tipo;
	private String busca;
	
	public Criterio(TipoBusca tipo, String busca) {
		super();
		this.tipo = tipo;
		this.busca = busca;
	}

	public TipoBusca getTipo() {
		return tipo;
	}
	
	public String getBusca() {
		return busca;
	}

	
	
}
