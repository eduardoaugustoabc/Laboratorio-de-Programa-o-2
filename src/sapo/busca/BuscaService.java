package sapo.busca;

import java.util.ArrayList;

import sapo.*;
import sapo.atividades.*;

public class BuscaService {
	private HistoricoDeBuscas  historico;
	private PessoasService ps;
	private AtividadeService as;
	
	
	public BuscaService() {
		this.historico = new HistoricoDeBuscas();
		this.ps = new PessoasService();
	}
	
	public ArrayList<Pessoas> exibirPessoas(String termos){
		ArrayList<Pessoas> pessoas =  this.ps.busca(termos);
		this.historico.adicionaBusca(new BuscaPessoas(pessoas));
		return pessoas;
	}
	
	public ArrayList<Atividade> buscarAtividade(String termos){
		ArrayList<Atividade> atividade = this.as.buscaAtividade(termos);
		this.historico.adicionaBusca(new BuscaAtividade(atividade));
		return atividade;
	}
	
	public ArrayList<Tarefa> buscarTarefa(String termos){
		ArrayList<Tarefa> tarefas = this.as.buscaTarefas(termos);
		this.historico.adicionaBusca(new BuscaTarefa(tarefas));
		return tarefas;
	}
	
	public ArrayList<Tarefa> buscarTarefa(String id,String termos){
		ArrayList<Tarefa> tarefas = this.as.buscaTarefas(id, termos);
		this.historico.adicionaBusca(new BuscaTarefa(tarefas));
		return tarefas;
	}
	
	public 
}
