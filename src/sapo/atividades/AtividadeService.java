package sapo.atividades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

import sapo.pessoas.*;


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
	private ArrayList<Atividade> atividadesListadas;
	
	/**
	 * Construtor padrão, criando também um PessoasService para auxiliá-lo
	 * a realizar as operações das atividades que interagem com alguma Pessoa,
	 * bem como preparando o repositório de atividades.
	 */
	public AtividadeService(PessoasService ps) {
		this.repositorioAtividades = new HashMap<String, Atividade>();
		this.ps = ps;
		this.atividadesListadas = new ArrayList<Atividade>();
		this.ar = new AtividadesRepository();
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
		String uso = ar.completaHashCode(atv1); 
		
		this.repositorioAtividades.put(uso, atv1);
		this.atividadesListadas.add(atv1);
		return ar.completaHashCode(atv1);
		
	}
	
	/**
	 * Realiza o encerramento da atividade, impossibilitando-a de receber novas 
	 * tarefas.
	 * @param atividadeId id da atividade a ser tratada.
	 */
	public void encerrarAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		//ver se ela possui tarefas pendentes.
		//se houver, lan�ar excecao como manda a documenta��o.
		if (!atv.getStatus().equals("encerrada")) {
			atv.setStatus("encerrada");
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
	}
	
	/**
	 * Realiza a desativação da atividade, impossibilitando-a de receber novas 
	 * tarefas.
	 * @param atividadeId id da atividade a ser tratada.
	 */
	public void desativarAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);

		//ver se ela possui tarefas pendentes.
		//se houver, lançar excecao como manda a documenta��o.
		if (!atv.getStatus().equals("desativada")) {
			atv.setStatus("desativada");
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
	}
	
	/**
	 * Realiza a reabertura da atividade, possibilitando-a de voltar
	 * a receber novas tarefas.
	 * @param atividadeId id da atividade a ser tratada.
	 */
	public void reabrirAtividade(String atividadeId) {
		Atividade atv = this.repositorioAtividades.get(atividadeId);

		//ver se ela possui tarefas pendentes.
		//se houver, lan�ar excecao como manda a documenta��o.


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
			tf1.setCodigo(trfId);
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

	public ArrayList<Atividade> buscaAtividade(String termos) {
		String[] termosArray = termos.split(" ");
		ArrayList<Atividade> atividadeTermos = new ArrayList<Atividade>();
		
		atividadeTermos.addAll(this.atividadesListadas);
		Atividade[] atividade = new Atividade[atividadeTermos.size()];
		for(int q = 0 ; q < atividadeTermos.size(); q ++) {
			
			atividade[q] = atividadeTermos.get(q);
		}
		for(int z = 0 ; z < atividade.length; z ++) {
			for(int u = 0; u < termosArray.length; u++) {
				if(atividade[z] != null) {
					if(!atividade[z].getTermos().contains(termosArray[u].toLowerCase())) {
						atividade[z] = null;
					}
				}
			}
			
			
		}
		
		ArrayList<Atividade> atividadeFim = new ArrayList<Atividade>();
		for(int q = 0 ; q < atividade.length; q ++) {
			
			if ((atividade[q] != null)) {
				
				atividadeFim.add(atividade[q]);
		
			}
		}
		return atividadeFim;
		
		
	}
	
	public ArrayList<Tarefa> buscaTarefas(String termos) {
		String[] termosArray = termos.split(" ");
		ArrayList<Tarefa> tarefasTermos = new ArrayList<Tarefa>();
		
		for(int w = 0 ; w < this.atividadesListadas.size(); w ++) {
			
			for(int j = 0; j < this.atividadesListadas.get(w).getTarefas().size(); j++) {
				tarefasTermos.add(this.atividadesListadas.get(w).getTarefasListada().get(j));
			}
		
		}
		Tarefa[] tarefas = new Tarefa[tarefasTermos.size()];
		for(int s = 0; s < tarefasTermos.size(); s ++) {
			
			tarefas[s] = tarefasTermos.get(s);
		}
		
			
		for(int j = 0; j < tarefasTermos.size(); j++) {
			for(int u = 0; u < termosArray.length; u++) {
				if(!tarefasTermos.get(j).getTermos().contains(termosArray[u].toLowerCase())) {
					tarefas[j] = null;
				}
			}
		}
		
		ArrayList<Tarefa> tarefaFim = new ArrayList<Tarefa>();
		for(int q = 0 ; q < tarefas.length; q ++) {
			
			if ((tarefas[q] != null)) {
				
				tarefaFim.add(tarefas[q]);
		
			}
		}
		
		return tarefasTermos;
		
		
	}
	
	public ArrayList<Tarefa> buscaTarefas(String id ,String termos) {
		String[] termosArray = termos.split(" ");
		ArrayList<Tarefa> tarefasTermos = new ArrayList<>();
		

		for(int j = 0; j < this.repositorioAtividades.get(id).getTarefas().size(); j++) {
			tarefasTermos.add(this.repositorioAtividades.get(id).getTarefasListada().get(j));
		}
		
		Tarefa[] tarefas = new Tarefa[tarefasTermos.size()];
		for(int s = 0; s < tarefasTermos.size(); s ++) {
			
			tarefas[s] = tarefasTermos.get(s);
		}
			
		for(int j = 0; j < tarefasTermos.size(); j++) {
			for(int u = 0; u < termosArray.length; u++) {
				if(!tarefasTermos.get(j).getTermos().contains(termosArray[u].toLowerCase())) {
					tarefas[j] = null;
				}
			}
		}
		
		ArrayList<Tarefa> tarefaFim = new ArrayList<Tarefa>();
		for(int q = 0 ; q < tarefas.length; q ++) {
			
			if ((tarefas[q] != null)) {
				
				tarefaFim.add(tarefas[q]);
		
			}
		}
		
		
		return tarefaFim;
		
		
	}
	
	public ArrayList<Tarefa> sugerirTarefas(String id) {
	
		Pessoas pessoa = this.ps.getPessoa(id);
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		Tarefa guardada;
		
		
		for(int w = 0 ; w < this.atividadesListadas.size(); w ++) {
			
			for(int j = 0; j < this.atividadesListadas.get(w).getTarefas().size(); j++) {
				if(this.atividadesListadas.get(w).getTarefasListada().get(j).calculaSimilaridade(pessoa) != null) {
					tarefas.add(this.atividadesListadas.get(w).getTarefasListada().get(j));
				}
			}
		}
		
		for(int l = 0 ; l < tarefas.size(); l ++) {
			
			for(int p = 0; p < tarefas.size(); p++) {
				if(tarefas.get(p).calculaSimilaridade(pessoa) > tarefas.get(l).calculaSimilaridade(pessoa)) {
					guardada = tarefas.get(l);
					tarefas.set(l, tarefas.get(p));
					tarefas.set(p, guardada);
					
				}
				
				if(tarefas.get(p).calculaSimilaridade(pessoa) == tarefas.get(l).calculaSimilaridade(pessoa)) {
					if (tarefas.get(p).getCodigo().compareTo(tarefas.get(p).getCodigo()) > 0 ) {
					guardada = tarefas.get(l);
					tarefas.set(l, tarefas.get(p));
					tarefas.set(p, guardada);
					}
				}
				
			}
		}
		
		return tarefas;
	}
	
	
	public String  CadastraTarefaGerencial(String atividadeId,String nome, String[] habilidades, String[] idTarefas) {
		String trfId = "";
		Atividade atv = this.repositorioAtividades.get(atividadeId);
		ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
		ArrayList<String> ids = new ArrayList<String>();
		for(int a = 0; a <idTarefas.length;a++) {
			
			tarefas.add(atv.getTarefas().get(idTarefas[a]));
			ids.add(idTarefas[a]);
		}
		Tarefa tf1 = new TarefaGerencial(nome, habilidades,ids, tarefas);
		
		trfId = atividadeId + "-" + Integer.toString(atv.getTarefas().size());
		if (atv.getStatus().equals("aberta")) {
			
			atv.adicionaTarefa(trfId, tf1);
			tf1.setCodigo(trfId);
			atv.adicionaListas(tf1.getNome(), trfId);
		}else {
			throw new IllegalArgumentException("Atividade não está aberta!");
		}
		
		return trfId;
	}
	
	public void adicionaTarefa(String id,String gerencial, String atvId) {
		TarefaGerencial trfgrl = (TarefaGerencial) this.repositorioAtividades.get(atvId).getTarefa(gerencial);
		trfgrl.adicionaTarefa(atvId, this.repositorioAtividades.get(atvId).getTarefa(id));
		
		this.repositorioAtividades.get(atvId).adicionaTarefa(id,trfgrl);
		
	}
	
	public void removeTarefa(String id,String gerencial, String atvId) {
		
		TarefaGerencial trfgrl = (TarefaGerencial) this.repositorioAtividades.get(atvId).getTarefa(gerencial);
		trfgrl.removePessoa(id);
		Tarefa trfgrl1 = (Tarefa) trfgrl;
		this.repositorioAtividades.get(atvId).adicionaTarefa(id, trfgrl);
		
	}
	
	public String listaEquipe(String idTarefa){
		String ans = "";
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		List<String> cpfs = trf.getEquipe();
		for (int i = 0; i < cpfs.size(); i++) {
			ans += this.ps.getPessoa(cpfs.get(i)).getNome() +  " - " + cpfs.get(i) + "\n";
		}
		return ans;
	}

	public String exibeTarefa(String idTarefa){
		String exibicao = "";
		String cpf = "388.567.123-65";
		String[] palavras = {"cachorro", "sol", "sorvete","futebol"};
		this.ps.cadastrarPessoa(cpf, "ana", palavras);
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		Tarefa trf = atv.getTarefa(idTarefa);
		exibicao += trf.getNome() + " - " + idTarefa + "\n" + "- " + atv.getNome() + "\n";
		//FAZER A LINHA QUE NAO ENTENDI O QUE ERA
		exibicao += "(" + trf.getHoras() + " hora(s) executada(s))" + "\n" + "===\n";
		exibicao += "Equipe:" + "\n";
		exibicao += listaEquipe(idTarefa);
		return exibicao;
	}
	
	public String exibeTarefaGerencial(String idTarefa){
		String exibicao = "";
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		TarefaGerencial trf = (TarefaGerencial) atv.getTarefa(idTarefa);
		exibicao += trf.getNome() + " - " + idTarefa + "\n" + "- " + atv.getNome() + "\n";
		//FAZER A LINHA QUE NAO ENTENDI O QUE ERA
		exibicao += "(" + trf.getHoras() + " hora(s) executada(s))" + "\n" + "===\n";
		exibicao += "Equipe:" + "\n";
		exibicao += listaEquipe(idTarefa);
		for(int a = 0; a < trf.getTarefas().size();a++) {
			exibicao += trf.getTarefas().get(a) + "\n";
		}
		return exibicao;
	}
	
	public int contaTarefas(String idTarefa) {
		String[] ArrayIdAtv = idTarefa.split("-");
		String idAtv = ArrayIdAtv[0] + "-" + ArrayIdAtv[1];
		Atividade atv = this.repositorioAtividades.get(idAtv);
		TarefaGerencial trf = (TarefaGerencial) atv.getTarefa(idTarefa);
		int conta = 0;
		for(int a = 0; a < trf.getTarefas().size();a++) {
			conta += trf.getTarefas().get(a).contaTarefas();
		}
		
		return conta;
	}
}
