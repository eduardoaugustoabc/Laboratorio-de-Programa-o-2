package sapo.atividades;

import java.util.Map;

/**
 * Classe de representação de uma atividade e que lida com os seus
 * pormenores, com métodos de auxílio para fins maiores, informações
 * de acesso e que lida com certas obrigações relacionadas à tarefas,
 * visto que essas estão presentes em uma atividade.
 */
public class Atividade {
	private String nome;
	private String descricao;
	private String cpf;
	private String status;
	private Map<String, Tarefa> tarefas;
	
	/**
	 * Construtor padrão, criando uma atividade com suas respectivas
	 * informações.
	 * @param nome nome da atividade.
	 * @param descricao descrição da atividade.
	 * @param cpf cpf do responsável pela atividade.
	 */
	public Atividade(String nome, String descricao, String cpf) {
		this.nome = nome;
		this.descricao = descricao;
		this.cpf = cpf;
		this.status = "aberta";
	}
	
	/**
	 * Realiza a criação parcial do id de atividade, visto que não
	 * pode ser completo apenas com as informações que tem esta classe.
	 * @return o id parcial da atividade.
	 */
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
	
	/**
	 * Realiza a sobrescrição do toString da classe.
	 * @return a representação textual da atividade.
	 */
	@Override
	public String toString() {
		String resposta = "";
		resposta += this.meuHashCode() + ": " + this.nome + "\n Responsavel: " ;
		resposta += "pessoa \n" + "=== \n" + this.descricao + "=== \n" + "Tarefas: ";
		return resposta;
	}
	
	/**
	 * Realiza o chamamento do nome da atividade.
	 * @return o nome da atividade.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Realiza o chamamento do status da atividade.
	 * @return o status da atividade.
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Realiza a alteração do status da atividade.
	 * @param novoStatus novo status da atividade.
	 */
	public void setStatus(String novoStatus) {
		this.status = novoStatus;
	}
	
	/**
	 * Realiza o chamamento da descrição da atividade.
	 * @return a descricao da atividade.
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * Realiza a alteração da descrição da atividade.
	 * @param novaDescricao nova descrição da atividade.
	 */
	public void setDescricao(String novaDescricao) {
		this.descricao = novaDescricao;
	}
	
	/**
	 * Realiza o chamamento das tarefas da atividade.
	 * @return as tarefas da atividade.
	 */
	public Map<String, Tarefa> getTarefas() {
		return this.tarefas;
	}
	
	/**
	 * Realiza o chamamento de determinada tarefa da atividade.
	 * @param idTarefa id da tarefa a ser tratada.
	 * @return determinada tarefa da atividade.
	 */
	public Tarefa getTarefa(String idTarefa) {
		return this.tarefas.get(idTarefa);
	}
	
	/**
	 * Realiza a remoção de determinada tarefa da atividade.
	 * @param idTarefa id da tarefa a ser tratada.
	 */
	public void removerTarefa(String idTarefa) {
		this.tarefas.remove(idTarefa);
	}
	
	/**
	 * Realiza a validação de todas as tarefas da atividade,
	 * com o intuito de saber se estão todas concluidas ou não,
	 * para a efetuação de outros métodos. 
	 * @return valor booleano se está valida ou não.
	 */
	public boolean validaTarefas() {
		boolean check = true;
		for (Tarefa tarefa : this.tarefas.values()) {
			if (tarefa.getConcluido() == false) {
				check = false;
			}
		}
		if (check == false) {
			return false;
		}else {
			return true;
		}
	}
}
