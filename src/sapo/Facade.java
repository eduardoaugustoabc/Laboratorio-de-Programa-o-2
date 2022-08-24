package sapo;

import java.util.ArrayList;
import java.util.Map;

import sapo.atividades.Atividade;
import sapo.atividades.AtividadeService;
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
	
	public String completaHashCode(Atividade a) {
		return this.as.completaHashCode(a);
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		return this.as.cadastrarAtividade(nome, descricao, cpf);
	}
	
	public void encerrarAtividade(String atividadeId) {
		this.as.encerrarAtividade(atividadeId);
	}
	
	public void desativarAtividade(String atividadeId) {
		this.as.desativarAtividade(atividadeId);
	}
	
	public void reabrirAtividade(String atividadeId) {
		this.as.reabrirAtividade(atividadeId);
	}
	
	public String listaTarefas(String atividadeId) {
		return this.as.listaTarefas(atividadeId);
	}
	
	public String exibirAtividade(String atividadeId) {
		return this.as.exibirAtividade(atividadeId);
	}
	
	public void alterarDescricaoAtividade(String atividadeId,String descricao) {
		this.as.alterarDescricaoAtividade(atividadeId, descricao);
	}
	
	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		this.as.alterarResponsavelAtividade(atividadeId, cpf);
	}
	
	public String cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
		return this.as.cadastraTarefa(atividadeId, nome, habilidades);
	}
	
	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		this.as.alterarNomeTarefa(idTarefa, novoNome);
	}
	
	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		this.as.alterarHabilidadesTarefa(idTarefa, habilidades);
	}
	
	public void adicionarHorasTarefa(String idTarefa, int horas) {
		this.as.adicionarHorasTarefa(idTarefa, horas);
	}
	
	public void removerHorasTarefa(String idTarefa, int horas) {
		this.as.removerHorasTarefa(idTarefa, horas);
	}
	
	public void concluirTarefa(String idTarefa) {
		this.as.concluirTarefa(idTarefa);
	}
	
	public void removerTarefa(String idTarefa) {
		this.as.removerTarefa(idTarefa);
	}
	
	public String listaEquipe(String idTarefa){
		return this.as.listaEquipe(idTarefa);
	}
	
	public String exibeTarefa(String idTarefa){
		return this.as.exibeTarefa(idTarefa);
	}
	
	public void cadastrarPessoa(String cpf, String nome , String[] habilidades) {
		this.ps.cadastrarPessoa(cpf, nome, habilidades);
	}
	
	public String exibirPessoa(String cpf) {
		return this.ps.exibirPessoa(cpf);
	}
	
	public void alterarNomePessoa(String cpf,String novoNome) {
		this.ps.alterarNomePessoa(cpf, novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		this.ps.alterarHabilidadesPessoa(cpf, novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		this.ps.removerPessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorNome) {
		this.ps.adicionarComentarioPessoa(cpf, comentario, autorNome);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return this.ps.listarComentariosPessoa(cpf);
	}
	
	public Map<String, Pessoas> getRepositorio(){
		return this.ps.getRepositorio();
	}
	
	public void cadastrarAluno(String cpf, String nome, String matr, int periodo, String[] habilidades){
		this.ps.cadastrarAluno(cpf, nome, matr, periodo, habilidades);
	}
	
	public void cadastrarProfessor(String cpf, String nome, int siape, String[] disciplinas){
		this.ps.cadastrarProfessor(cpf, nome, siape, disciplinas);
	}
	
	public void definirFuncaoProfessor(String cpf, int siape, String[] disciplinas){
		this.ps.definirFuncaoProfessor(cpf, siape, disciplinas);
	}
	
	public void definirFuncaoAluno(String cpf, String matr, int periodo){
		this.ps.definirFuncaoAluno(cpf, matr, periodo);
	}
	
	public void removerFuncao(String cpf){
		this.ps.removerFuncao(cpf);
	}
	
	public Pessoas getPessoa(String cpf){
		return this.ps.getPessoa(cpf);
	}
}
