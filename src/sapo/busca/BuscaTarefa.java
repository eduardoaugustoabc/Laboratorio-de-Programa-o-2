package sapo.busca;

import java.util.ArrayList;

import sapo.atividades.*;

public class BuscaTarefa  implements Busca{
	private ArrayList<Tarefa> tarefa;
	private String tipo;
	
	public BuscaTarefa(ArrayList<Tarefa> tarefa) {
		this.tarefa = tarefa;
		this.tipo = "TAREFA";
	}
	
	@Override
	public String representacaoBusca(){
		String representacao = "";
		representacao +=(tipo);
		for(int a = 0; a < this.tarefa.size();a++) {
			representacao += (this.tarefa.get(a).toString());
		}
		return representacao;
	}
}
