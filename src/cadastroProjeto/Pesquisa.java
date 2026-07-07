package cadastroProjeto;

public class Pesquisa {
	
	// Verifica se o pet bate com o valor da busca
	public boolean verificaCriterio(Pet pet, Criterio criterio) {
		
		switch (criterio.getTipo()) {
		
		case NOME:
			return pet.getNome().equalsIgnoreCase(criterio.getBusca());
		case SOBRENOME:
			return pet.getSobrenome().equalsIgnoreCase(criterio.getBusca());
		case TIPO:
			return pet.getTipoPet() == TipoPet.valueOf(criterio.getBusca().toUpperCase());
		case SEXO:
			return pet.getSexoPet() == SexoPet.valueOf(criterio.getBusca().toUpperCase());
		case RUA:
			return pet.getRua().equalsIgnoreCase(criterio.getBusca());
		case NUMERO:
			return pet.getNmrCasa().equalsIgnoreCase(criterio.getBusca());
		case CIDADE:
			return pet.getCidade().equalsIgnoreCase(criterio.getBusca());
		case IDADE:
			return pet.getIdade().equalsIgnoreCase(criterio.getBusca());
		case PESO:
			return pet.getPeso().equalsIgnoreCase(criterio.getBusca());
		case RACA:
			return pet.getRaca().equalsIgnoreCase(criterio.getBusca());
			
		}
		
		return false;
		
	}
	
}
