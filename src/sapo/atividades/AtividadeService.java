package sapo.atividades;

import java.util.HashMap;
import java.util.Map;

public class AtividadeService {
	
	private AtividadesRepository ar;
	private Map<String, Atividade> repositorioAtividades;
	
	public AtividadeService() {
		this.repositorioAtividades = new HashMap<String, Atividade>();
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		Atividade atv1 = new Atividade(nome, descricao, cpf);
		this.repositorioAtividades.put(ar.completaHashCode(atv1), atv1);
		return ar.completaHashCode(atv1);
	}
	
	public void encerrarAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		//ver se ela possui tarefas pendentes.
		//se houver, lan�ar excecao como manda a documenta��o.
		if (!atv.getStatus().equals("encerrada")) {
			atv.setStatus("encerrada");
		}
	}
	
	public void desativarAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		//ver se ela possui tarefas pendentes.
		//se houver, lan�ar excecao como manda a documenta��o.
		if (!atv.getStatus().equals("desativada")) {
			atv.setStatus("desativada");
		}
	}
	
	public void reabrirAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		//ver se ela possui tarefas pendentes.
		//se houver, lan�ar excecao como manda a documenta��o.
		if (!atv.getStatus().equals("aberta")) {
			atv.setStatus("aberta");
		}
	}
	
	public String exibirAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		String exibition = atv.toString();
		return exibition;
	}
	
	public void alterarDescricaoAtividade(String atividadeId,String descricao) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		atv.setDescricao(descricao);
	}
	
	public String cadastraTarefa(String atividadeId, String nome, String[] habilidades) {
		String trfId = "";
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		Tarefa tf1 = new Tarefa(nome, habilidades);
		trfId = atividadeId + "-" + Integer.toString(atv.getTarefas().size());
		atv.getTarefas().put(trfId, tf1);
		return trfId;
	}
}
