package sapo.busca;

import java.util.ArrayList;

import sapo.pessoas.*;
import sapo.atividades.Atividade;

public class BuscaAtividade  implements Busca{
	private ArrayList<Atividade> atividade;
	private String tipo;
	
	public BuscaAtividade(ArrayList<Atividade> atividade) {
		this.atividade = atividade;
		this.tipo = "ATIVIDADES";
	}	
	@Override
	public String representacaoBusca(){
		String representacao = "";
		representacao += (tipo)+ "\n";
		for(int a = 0; a < this.atividade.size();a++) {
			representacao += (this.atividade.get(a).toStringResumido()) + "\n";
		}
		return representacao;
	}
}
