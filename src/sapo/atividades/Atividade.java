package atividades;

import java.util.Map;

public class Atividade {
	private String nome;
	private String descricao;
	private String cpf;
	private String status;
	private Map<String, Tarefa> tarefas;
	
	public Atividade(String nome, String descricao, String cpf) {
		this.nome = nome;
		this.descricao = descricao;
		this.cpf = cpf;
		this.status = "aberta";
	}
	
	public String meuHashCode() {
		String codigo = "";
		String[] teste = this.nome.split("");
		int counter = 0;
		for (int i = 0; i < teste.length; i++) {
			if (counter > 2) {
				break;
			}
			if (!teste[i].equals("a") || !teste[i].equals("e") || !teste[i].equals("i") || !teste[i].equals("o") || !teste[i].equals("u")) {
				codigo += teste[i];
				counter += 1;
			}
		}
		if (codigo.length() < 3) {
			for (int j = 0; j < 3; j++) {
				codigo += "X";
				if (codigo.length() > 2) {
					break;
				}
			}
		}
		return codigo;
	}
	
	@Override
	public String toString() {
		String resposta = "";
		resposta += this.meuHashCode() + ": " + this.nome + "\n Responsavel: " ;
		resposta += "pessoa \n" + "=== \n" + this.descricao + "=== \n" + "Tarefas: ";
		return resposta;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String novoStatus) {
		this.status = novoStatus;
	}
	
	public void setDescricao(String novaDescricao) {
		this.descricao = novaDescricao;
	}
	
	public Map<String, Tarefa> getTarefas() {
		return this.tarefas;
	}
	
	//AJEITAR ESSE METODO PRA FUNCIONAR, SO UMA IDEIA
	public void concluirTarefa(String idTarefa) {
		this.tarefas.get(idTarefa);
	}
}
