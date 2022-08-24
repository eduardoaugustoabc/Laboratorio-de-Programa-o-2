package sapo;

import java.util.ArrayList;
import java.util.Map;

import sapo.atividades.Atividade;
import sapo.atividades.AtividadeService;
import sapo.atividades.Tarefa;
import sapo.busca.BuscaService;
import sapo.pessoas.Pessoas;
import sapo.pessoas.PessoasService;

public class Facade {
	
	private PessoasService ps;
	private AtividadeService as;
	private BuscaService bs;
	
	public Facade(PessoasService ps,AtividadeService as, BuscaService bs) {
		this.as = as;
		this.ps = ps;
		this.bs = bs;
	}
	
	public void associarPessoaTarefa(String cpf, String idTarefa){
		this.as.associarPessoaTarefa(cpf, idTarefa);
	}
	
	public void removerPessoaTarefa(String cpf, String idTarefa){
		this.as.removerPessoaTarefa(cpf, idTarefa);
	}
	
	public Map<String, Atividade> getRepositorio(){
		return this.getRepositorio();
	}
	
	public String  CadastraTarefaGerencial(String atividadeId,String nome, String[] habilidades, String[] idTarefas) {
		return this.CadastraTarefaGerencial(atividadeId, nome, habilidades, idTarefas);
	}
	
	public void adicionaTarefa(String id,String gerencial, String atvId) {
		this.as.adicionaTarefa(id, gerencial, atvId);
	}
	
	public void removeTarefa(String id,String gerencial, String atvId) {
		this.removeTarefa(id, gerencial, atvId);
	}

	
	public String exibeTarefaGerencial(String idTarefa){
		return this.as.exibeTarefaGerencial(idTarefa);
	}
	
	public int contaTarefas(String idTarefa) {
		return this.as.contaTarefas(idTarefa);
	}
	
	public ArrayList<Pessoas> exibirPessoas(String termos){
		return this.bs.exibirPessoas(termos);
	}
	
	public ArrayList<Atividade> buscaAtividade(String termos){
		return this.bs.buscaAtividade(termos);
	}
	
	public ArrayList<Tarefa> buscaTarefa(String termos){
		return this.buscaTarefa(termos);
	}
	
	public ArrayList<Tarefa> buscaTarefa(String id,String termos){
		return this.bs.buscaTarefa(id, termos);
	}
	
	public ArrayList<Tarefa> sugerirTarefa(String id){
		return this.sugerirTarefa(id);
	}
	
	public String buscasRecentes(int numero){
		return this.bs.buscasRecentes(numero);
	}
	
	public String exibeHistoricoBuscas(int index){
		return this.exibeHistoricoBuscas(index);
	}
}
