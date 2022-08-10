package sapo.atividades;

import java.util.HashMap;
import java.util.Map;

public class AtividadeService {
	
	private AtividadesRepository ar;
	private Map<String, Atividade> repositorioAtividades;
	
	public AtividadeService() {
		this.repositorioAtividades = new HashMap<String, Atividade>();
		//this.ar = new AtividadesRepository();
	}
	
	public String completaHashCode(Atividade a) {
		String ans = "";
		ans += a.meuHashCode() + "-";
		ans += Integer.toString(this.repositorioAtividades.size());
		return ans;
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		Atividade atv1 = new Atividade(nome, descricao, cpf);
		this.repositorioAtividades.put(ar.completaHashCode(atv1), atv1);
		return ar.completaHashCode(atv1);
	}
	
	public void encerrarAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		//Atividade atv1 = ar.getAtividade(atividadeId);
		//ver se ela possui tarefas pendentes.
		//se houver, lançar excecao como manda a documentação.
		if (!atv.getStatus().equals("encerrada")) {
			atv.setStatus("encerrada");
		}
	}
	
	public void desativarAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		//ver se ela possui tarefas pendentes.
		//se houver, lançar excecao como manda a documentação.
		if (!atv.getStatus().equals("desativada")) {
			atv.setStatus("desativada");
		}
	}
	
	public void reabrirAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		//ver se ela possui tarefas pendentes.
		//se houver, lançar excecao como manda a documentação.
		if (!atv.getStatus().equals("aberta")) {
			atv.setStatus("aberta");
		}
	}
	
	public String exibirAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		String pronto = this.completaHashCode(atv);
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
	
	public void alterarNomeTarefa(String idTarefa, String novoNome) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		trf.setNome(novoNome);
	}
	
	public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		trf.setHabilidades(habilidades);
	}
	
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
	
	public void concluirTarefa(String idTarefa) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		trf.setConcluido();
	}
	
	public void removerTarefa(String idTarefa) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		atv.removerTarefa(idTarefa);
	}
}
