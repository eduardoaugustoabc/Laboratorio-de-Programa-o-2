package sapo.atividades;

import java.util.HashMap;
import java.util.Map;

import sapo.Pessoas;

import java.util.ArrayList;

public class AtividadesRepository {
	
	private Map<String, Atividade> atividades;
	private ArrayList<Atividade> atividadesListadas;
	
	public AtividadesRepository() {
		this.atividades = new HashMap<String, Atividade>();
		this.atividadesListadas = new ArrayList<Atividade>();
	}
	
	public String completaHashCode(Atividade a) {
		String ans = "";
		ans += a.meuHashCode() + "-";
		ans += Integer.toString(this.atividades.size());
		return ans;
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		Atividade atv1 = new Atividade(nome, descricao,cpf);
		this.atividadesListadas.add(atv1);
		this.atividades.put(this.completaHashCode(atv1), atv1);
		return this.completaHashCode(atv1);
	}
	
	public Atividade getAtividade(String idAtividade) {
		return this.atividades.get(idAtividade);
	}
	
	public ArrayList<Atividade> buscaAtividade(String termos) {
		String[] termosArray = termos.split(" ");
		ArrayList<Atividade> atividadeTermos = new ArrayList<Atividade>();
		atividadeTermos.addAll(this.atividadesListadas);
		for(int a = 0 ; a < atividadeTermos.size(); a ++) {
			for(int u = 0; u < termosArray.length; u++)
				if(!atividadeTermos.get(a).getTermos().contains(termosArray[u])) {
					atividadeTermos.remove(a);
				}
		}
		return atividadeTermos;
		
		
	}
	
	public ArrayList<Tarefa> buscaTarefas(String termos) {
		String[] termosArray = termos.split(" ");
		ArrayList<Tarefa> tarefasTermos = new ArrayList<>();
		
		for(int w = 0 ; w < this.atividadesListadas.size(); w ++) {
			
			for(int j = 0; j < this.atividadesListadas.get(w).getTarefas().size(); j++) {
				tarefasTermos.add(this.atividadesListadas.get(w).getTarefasListada().get(j));
			}
		
		}
			
		for(int j = 0; j < tarefasTermos.size(); j++) {
			for(int u = 0; u < termosArray.length; u++) {
				if(!tarefasTermos.get(j).getTermos().contains(termosArray[u])) {
					tarefasTermos.remove(j);
				}
			}
		}
		
		return tarefasTermos;
		
		
	}
	
	public ArrayList<Tarefa> buscaTarefas(String id ,String termos) {
		String[] termosArray = termos.split(" ");
		ArrayList<Tarefa> tarefasTermos = new ArrayList<>();
		

		for(int j = 0; j < this.atividades.get(id).getTarefas().size(); j++) {
			tarefasTermos.add(this.atividades.get(id).getTarefasListada().get(j));
		}
		
		
			
		for(int j = 0; j < tarefasTermos.size(); j++) {
			for(int u = 0; u < termosArray.length; u++) {
				if(!tarefasTermos.get(j).getTermos().contains(termosArray[u])) {
					tarefasTermos.remove(j);
				}
			}
		}
		
		return tarefasTermos;
		
		
	}
}
