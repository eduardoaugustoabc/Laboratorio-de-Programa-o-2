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
	
	public String recuperaBusca(int index) {
		return this.historico.get(index).representacaoBusca();
	}
	
	public String exibeBuscas(int numeroDeBuscas) {
		String buscas = "";
		for(int a = this.historico.size()-numeroDeBuscas; a <this.historico.size(); a++) {
			buscas += (this.historico.get(a).representacaoBusca()) + "\n";
		}
		return buscas;
	}
}
