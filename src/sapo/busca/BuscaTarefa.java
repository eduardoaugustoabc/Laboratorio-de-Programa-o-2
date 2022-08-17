package sapo.busca;

import java.util.ArrayList;

import sapo.atividades.*;

public class BuscaTarefa  implements Busca{
	private ArrayList<Tarefa> tarefa;
	private String tipo;
	
	public BuscaTarefa(ArrayList<Tarefa> tarefa) {
		this.tarefa = new ArrayList<Tarefa>();
		this.tipo = "TAREFA";
	}
}
