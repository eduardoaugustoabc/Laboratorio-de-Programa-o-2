package sapo.atividades;

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
}
