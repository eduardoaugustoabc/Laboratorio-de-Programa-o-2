package atividades;

import java.util.Map;

public class TarefaService {
	
	private Map<String, Tarefa> repositorioTarefas;
	private AtividadesRepository ar;
	private Atividade atv;
	
	public TarefaService() {
		this.ar = new AtividadesRepository();
		this.atv = new Atividade();
	}
	
	public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades){
		this.ar.getAtividade(atividadeId).
	}
}
