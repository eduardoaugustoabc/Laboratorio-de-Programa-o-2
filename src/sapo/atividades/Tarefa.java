package sapo.atividades;
import java.util.ArrayList;


public class Tarefa {
	
	private int duracao;
	private String nome;
	private String[] habilidades;
	private boolean concluido;
	
	public Tarefa(String nome, String[] habilidades) {
		this.nome = nome;
		this.habilidades = habilidades;
		this.duracao = 0;
		this.concluido = false;
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
	
	public ArrayList<String> getTermos(){
		ArrayList<String> representacao = new ArrayList<String>();
		String[] nomeSplit = this.nome.split(" ");
		for(int i=0; i < nomeSplit.length;i++) {
		
			representacao.add(nomeSplit[i]);
		}
		return representacao;
	}
}
