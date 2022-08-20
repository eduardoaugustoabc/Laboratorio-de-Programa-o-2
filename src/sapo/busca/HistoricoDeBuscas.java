package sapo.busca;

import java.util.ArrayList; 

public class HistoricoDeBuscas {
	
	private ArrayList<Busca> historico;
	
	public HistoricoDeBuscas() {
		this.historico = new ArrayList<Busca>();
	}
	
	public void adicionaBusca(Busca busca) {
		this.historico.add(busca);
	}
	
	public Busca recuperaBusca(int index) {
		return this.historico.get(index);
	}
	
	public ArrayList<Busca> recuperaBuscas(int numeroDeBuscas) {
		ArrayList<Busca> buscas = new ArrayList<Busca>();
		for(int a = this.historico.size()-numeroDeBuscas; a <this.historico.size(); a++) {
			buscas.add(this.historico.get(a));
		}
		return buscas;
	}
}
