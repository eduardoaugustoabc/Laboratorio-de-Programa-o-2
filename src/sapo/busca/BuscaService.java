package sapo.busca;

import java.util.ArrayList;
import java.util.Arrays;

import sapo.*;
import sapo.atividades.*;
import sapo.pessoas.*;

public class BuscaService {
	private HistoricoDeBuscas  historico;
	private PessoasService ps;
	private AtividadeService as;
	
	
	public BuscaService(PessoasService ps, AtividadeService as) {
		this.historico = new HistoricoDeBuscas();
		this.ps = ps;
		this.as = as;
	}
	
	public ArrayList<Pessoas> exibirPessoas(String termos){
		ArrayList<Pessoas> pessoas =  this.ps.busca(termos);
		this.historico.adicionaBusca(new BuscaPessoas(pessoas));
		
		return pessoas;
	}
	
	public ArrayList<Atividade> buscaAtividade(String termos){
		ArrayList<Atividade> atividade = this.as.buscaAtividade(termos);
		this.historico.adicionaBusca(new BuscaAtividade(atividade));
		return atividade;
	}
	
	public ArrayList<Tarefa> buscaTarefa(String termos){
		ArrayList<Tarefa> tarefas = this.as.buscaTarefas(termos);
		
		return tarefas;
	}
	
	public ArrayList<Tarefa> buscaTarefa(String id,String termos){
		ArrayList<Tarefa> tarefas = this.as.buscaTarefas(id, termos);
		this.historico.adicionaBusca(new BuscaTarefa(tarefas));
		return tarefas;
	}
	
	public ArrayList<Tarefa> sugerirTarefa(String id){
		ArrayList<Tarefa> tarefas = this.as.sugerirTarefas(id);
		this.historico.adicionaBusca(new SugerirTarefa(tarefas));
		return tarefas;
	}
	
	public String buscasRecentes(int numero){
		return this.historico.exibeBuscas(numero);
	}
	
	public String exibeHistoricoBuscas(int index){
		return this.historico.recuperaBusca(index);
	}
	
	
}
