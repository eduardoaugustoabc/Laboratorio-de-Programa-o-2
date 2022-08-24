package sapo.atividades;
import java.util.ArrayList;


import java.util.List;

import sapo.pessoas.Pessoas;
import sapo.pessoas.PessoasService;

public class Tarefa {
	
	private int duracao;
	private String nome;
	private String[] habilidades;
	private boolean concluido;
	private List<String> cpfs;
	private PessoasService ps;
	
	public Tarefa(String nome, String[] habilidades) {
		this.nome = nome;
		this.habilidades = habilidades;
		this.duracao = 0;
		this.concluido = false;
		this.cpfs = new ArrayList<String>();
		this.ps = new PessoasService();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setHabilidades(String[] habilidades) {
		this.habilidades = habilidades;
	}
	
	public void aumentarHoras(int horas) {
		this.duracao += horas;
	}
	
	public void removerHoras(int horas) {
		this.duracao -= horas;
	}
	
	public boolean getConcluido() {
		return this.concluido;
	}
	
	public void setConcluido() {
		this.concluido = true;
	}

	public void associaPessoa(String cpf){
		//Pessoas ex = this.ps.getRepositorio().get(cpf);
		//ex.adicionaTarefa(this.nome);
		this.cpfs.add(cpf);
	}

	public void removePessoa(String cpf){
		this.cpfs.remove(cpf);
	}

	public int getDuracao(){
		return this.duracao;
	}

	public List<String> getEquipe(){
		return this.cpfs;
	}
	
	public String[] getHabilidades(){
		return this.habilidades;
	}
	
	public ArrayList<String> getTermos(){
		ArrayList<String> representacao = new ArrayList<String>();
		String[] nomeSplit = this.nome.split(" ");
		for(int i=0; i < nomeSplit.length;i++) {
		
			representacao.add(nomeSplit[i]);
		}
		return representacao;
	}
}
