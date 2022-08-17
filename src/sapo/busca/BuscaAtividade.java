package sapo.busca;

import java.util.ArrayList;

import sapo.pessoas.*;
import sapo.atividades.Atividade;

public class BuscaAtividade  implements Busca{
	private ArrayList<Atividade> atividade;
	private String tipo;
	
	public BuscaAtividade(ArrayList<Atividade> atividade) {
		this.atividade = new ArrayList<Atividade>();
		this.tipo = "ATIVIDADES";
	}	
}
