package sapo.atividades;
import java.util.ArrayList;


import java.util.List;

import sapo.pessoas.Pessoas;

public class Tarefa {
	
	protected int duracao;
	protected String nome;
	protected String[] habilidades;
	protected boolean concluido;
	protected ArrayList<String> cpfs;
	protected String codigo;
	
	public Tarefa(String nome, String[] habilidades) {
		this.nome = nome;
		this.habilidades = habilidades;
		this.duracao = 0;
		this.concluido = false;
		this.cpfs = new ArrayList<String>();
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
	
	public String[] getHabilidades() {
		return this.habilidades;
	}
	
	public int getHoras() {
		return this.duracao;
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
		
		
		this.cpfs.add(cpf);
	}

	public void removePessoa(String cpf){
		this.cpfs.remove(cpf);
	}
	
	public ArrayList<String> getTermos(){
		ArrayList<String> representacao = new ArrayList<String>();
		String[] nomeSplit = this.nome.split(" ");
		for(int i=0; i < nomeSplit.length;i++) {
		
			representacao.add(nomeSplit[i]);
		}
		return representacao;
	}
	
	public Double calculaSimilaridade(Pessoas trf) {
		Double similaridade = 0.0;
		ArrayList<String> habilidades = new ArrayList<String>();
		for(int a = 0 ; a< this.habilidades.length;a++) {
			habilidades.add(this.habilidades[a]);
		}
		for(int i =0; i < trf.getHabilidades().length; i ++) {
			if(habilidades.contains(trf.getHabilidades()[i])) {
				similaridade ++;
			}
		}
		
		if(this.concluido == true) {
			similaridade = null;
		}
		
		if(this.cpfs.size() == 0) {
			similaridade += 0.1;
		}
		return similaridade;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	@Override
	public String toString() {
		return this.codigo + " " + this.nome;
	}
	
	public int contaTarefas() {
		return 1;
	}
}
