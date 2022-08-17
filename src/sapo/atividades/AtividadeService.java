package sapo.atividades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sapo.PessoasService;

/**
 * AtividadeService é responsável por centralizar toda as operações de lógica
 * das atividades.
 * 
 * O AtividadeService tem como atribuições validar, manejar e alterar as atividades
 * em questão, bem como cadastrá-las no repositório de atividades.
 * 
 * Além disso trata de operações das tarefas, também, visto que essas estão
 * presentes dentro de cada atividade e são, como as atividades, tratadas,
 * validadas e cadastradas no AtividadeService.
 */

public class AtividadeService {
	

	private AtividadesRepository ar;
	private Map<String, Atividade> repositorioAtividades;
	private int concluidas;
	private PessoasService ps;
	
	/**
	 * Construtor padrão, criando também um PessoasService para auxiliá-lo
	 * a realizar as operações das atividades que interagem com alguma Pessoa,
	 * bem como preparando o repositório de atividades.
	 */
	public AtividadeService() {
		this.repositorioAtividades = new HashMap<String, Atividade>();
		this.ps = new PessoasService();
		//this.ar = new AtividadesRepository();
	}
	
	/**
	 * Método responsável pela complementação da id da atividade, visto que é
	 * necessária a informação da quantidade de atividades cadastradas, que está
	 * presente apenas no repositório de atividades.
	 * @param a atividade a ter a id complementada.
	 * @return id da atividade.
	 */
	public String completaHashCode(Atividade a) {
		String ans = "";
		ans += a.meuHashCode() + "-";
		ans += Integer.toString(this.repositorioAtividades.size());
		a.setMeuHashCode(ans);
		return ans;
	}
	
	/**
	 * Realiza o cadastro de uma atividade no sistema, retornando a sua id em formato
	 * de string e recebendo como parâmetro suas informações.
	 * @param nome nome da atividade.
	 * @param descricao descrição da atividade.
	 * @param cpf cpf do responsável pela atividade.
	 * @return id da atividade.
	 */
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		Atividade atv1 = new Atividade(nome, descricao, cpf);
		this.repositorioAtividades.put(ar.completaHashCode(atv1), atv1);
		return ar.completaHashCode(atv1);
	}
	
	/**
	 * Realiza o encerramento da atividade, impossibilitando-a de receber novas 
	 * tarefas.
	 * @param atividadeId id da atividade a ser tratada.
	 */
	public void encerrarAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		if (atv.validaTarefas() == true) {
			if (!atv.getStatus().equals("encerrada")) {
				atv.setStatus("encerrada");
			}else {
				throw new IllegalArgumentException("Atividade já encerrada!");
			}
		}else {
			throw new IllegalArgumentException("Atividade possui tarefas pendentes!");
		}
	}
	
	/**
	 * Realiza a desativação da atividade, impossibilitando-a de receber novas 
	 * tarefas.
	 * @param atividadeId id da atividade a ser tratada.
	 */
	public void desativarAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		if (atv.validaTarefas() == true) {
			if (!atv.getStatus().equals("desativada")) {
				atv.setStatus("desativada");
			}else {
				throw new IllegalArgumentException("Atividade j� desativada!");
			}
		}else {
			throw new IllegalArgumentException("Atividade possui tarefas pendentes!");
		}
	}
	
	/**
	 * Realiza a reabertura da atividade, possibilitando-a de voltar
	 * a receber novas tarefas.
	 * @param atividadeId id da atividade a ser tratada.
	 */
	public void reabrirAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		if (!atv.getStatus().equals("aberta")) {
			atv.setStatus("aberta");
		}else {
			throw new IllegalArgumentException("Atividade já aberta!");
		}
	}

	public String listaTarefas(String atividadeId) {
		String res = "";
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		for (int i = atv.getNomesTarefas().size() - 1; i > atv.getNomesTarefas().size() - 4; i--) {
			res += "- " +  atv.getNomesTarefas().get(i) + " - " + atv.getIdsTarefas().get(i) + "\n";
		}
		return res;
	}
	
	/**
	 * Realiza a exibição da representação textual de determinada
	 * atividade.
	 * @param atividadeId id da atividade a ser tratada.
	 * @return a representação textual da atividade em questão.
	 */
	public String exibirAtividade(String atividadeId) {
		String exibicao = "";
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		String hashCompleto = this.completaHashCode(atv);
		String responsavel = this.ps.getPessoa(atv.getCpf()).toStringBasico();
		exibicao += hashCompleto + ": " + atv.getNome() + "\n Responsável: ";
		exibicao += responsavel + "\n" + "=== \n" + atv.getDescricao() + "\n === \\n";
		exibicao += "Tarefas: " + Integer.toString(this.concluidas) + "/";
		exibicao += Integer.toString(atv.getTarefas().size()) + "\n";
		exibicao += listaTarefas(atividadeId);
		return exibicao;
	}
	
	/**
	 * Realiza a alteração da descrição da atividade.
	 * @param atividadeId id da atividade a ser tratada.
	 * @param descricao nova descrição da atividade.
	 */
	public void alterarDescricaoAtividade(String atividadeId,String descricao) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		atv.setDescricao(descricao);
	}

	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		atv.setCpf(cpf);
	}
	
	/**
	 * Realiza o cadastro de uma tarefa em determinada atividade,
	 * retornando a sua id em formato de string e recebendo como 
	 * parâmetro suas informações.
	 * @param atividadeId id da atividade a ser tratada.
	 * @param nome nome da tarefa. 
	 * @param habilidades habilidades competentes à tarefa.
	 * @return id da tarefa.
	 */
	public String cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
		String trfId = "";
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		Tarefa tf1 = new Tarefa(nome, habilidades);
		trfId = atividadeId + "-" + Integer.toString(atv.getTarefas().size());
		if (atv.getStatus().equals("aberta")) {
			atv.adicionaTarefa(trfId, tf1);
			atv.adicionaListas(tf1.getNome(), trfId);
		}else {
			throw new IllegalArgumentException("Atividade não está aberta!");
		}
		return trfId;
	}
	
	/**
	 * Realiza a alteração do nome da tarefa.
	 * @param idTarefa id da tarefa a ser tratada.
	 * @param novoNome novo nome da tarefa.
	 */
	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		trf.setNome(novoNome);
	}
	
	/**
	 * Realiza a alteração das habilidades de determinada tarefa.
	 * @param idTarefa id da tarefa a ser tratada.
	 * @param habilidades novas habilidades competentes à tarefa.
	 */
	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		trf.setHabilidades(habilidades);
	}
	
	/**
	 * Realiza a adição de horas a determinada tarefa.
	 * @param idTarefa id da tarefa a ser tratada.
	 * @param horas horas a serem acrescentadas a determinada tarefa.
	 */
	public void adicionarHorasTarefa(String idTarefa, int horas) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		if (trf.getConcluido() == false) {
			trf.aumentarHoras(horas);
		}else {
			throw new IllegalArgumentException("Tarefa já concluída!");
		}
	}
	
	/**
	 * Realiza a remoção de horas de determinada tarefa.
	 * @param idTarefa id da tarefa a ser tratada.
	 * @param horas horas a serem removidas de determinada tarefa.
	 */
	public void removerHorasTarefa(String idTarefa, int horas) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		if (trf.getConcluido() == false) {
			trf.removerHoras(horas);
		}else {
			throw new IllegalArgumentException("Tarefa já concluída!");
		}
	}
	
	/**
	 * Realiza a conclusão de determinada tarefa.
	 * @param idTarefa id da tarefa a ser tratada.
	 */
	//VALIDAR SE JÁ ESTAVA CONCLUIDA OU NÃO.
	public void concluirTarefa(String idTarefa) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		this.concluidas += 1;
		trf.setConcluido();
	}
	
	/**
	 * Realiza a remoção de determinada tarefa de determinada
	 * atividade.
	 * @param idTarefa id da tarefa a ser tratada.
	 */
	public void removerTarefa(String idTarefa) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		atv.removerTarefa(idTarefa);
	}
	
	public void associarPessoaTarefa(String cpf, String idTarefa){
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		trf.associaPessoa(cpf);
	}

	public void removerPessoaTarefa(String cpf, String idTarefa){
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		trf.removePessoa(cpf);
	}
}
