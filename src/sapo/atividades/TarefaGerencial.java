package sapo.atividades;

import java.util.ArrayList;
import java.util.HashMap;

public class TarefaGerencial extends Tarefa{
	
	private ArrayList<Tarefa> tarefas;
	private ArrayList<String> idsTarefas;
	private HashMap<String, Tarefa> tarefasCompletas;
	
	public TarefaGerencial(String nome, String[] habilidades, ArrayList<String> idTarefas, ArrayList<Tarefa> tarefas) {
		super(nome, habilidades);
		this.tarefas = tarefas;
		this.idsTarefas = idTarefas;
		this.tarefasCompletas =  new HashMap<String, Tarefa>();
		this.setHorario();
		this.colocaMap();
	}
	
	private void setHorario() {
		
		for(int r =0;  r< this.idsTarefas.size(); r ++) {
			 this.aumentarHoras(tarefas.get(r).getHoras());
		}
	}
	
	private void colocaMap() {
		
		for(int r =0;  r< this.idsTarefas.size(); r ++) {
			 this.tarefasCompletas.put(this.idsTarefas.get(r), this.tarefas.get(r));
		}
	}
	
	public void adicionaTarefa(String id,Tarefa trf) {
		this.tarefasCompletas.put(id, trf);
	}
	
	public void removeTarefa(String id) {
		this.tarefasCompletas.remove(id);
	}
	
	public void setConcluidoGerencial() {
		for(int r =0;  r< this.idsTarefas.size(); r ++) {
			 this.tarefas.get(r).setConcluido();;
		}
		this.setConcluido();
	}
	
	public ArrayList<Tarefa> getTarefas(){
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		for(int b = 0; b < this.idsTarefas.size();b++) {
			tarefas.add(this.tarefasCompletas.get(this.idsTarefas.get(b)));
		}
		return tarefas;
	}
	
	@Override
	public int contaTarefas() {
		return this.idsTarefas.size();
	}
	
}
