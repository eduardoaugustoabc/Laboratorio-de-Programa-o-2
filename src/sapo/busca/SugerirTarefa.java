package sapo.busca;

import java.util.ArrayList;

import sapo.atividades.Tarefa;

public class SugerirTarefa implements Busca {
	
	private ArrayList<Tarefa> tarefa;
	private String tipo;
	
	public SugerirTarefa(ArrayList<Tarefa> trf) {
		this.tarefa = trf;
		this.tipo = "SUGESTÃO";
	}
	
	@Override
	public String representacaoBusca(){
		String representacao = "";
		representacao +=(tipo) + "\n";
		for(int a = 0; a < this.tarefa.size();a++) {
			representacao += (this.tarefa.get(a).toString()) + "\n";
		}
		return representacao;
	}
}
