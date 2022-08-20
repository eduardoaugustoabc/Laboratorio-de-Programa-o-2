package sapo.atividades;

import java.util.HashMap;
import java.util.Map;

import sapo.pessoas.*;

import java.util.ArrayList;

public class AtividadesRepository {
	
	private Map<String, Atividade> atividades;
	private ArrayList<Atividade> atividadesListadas;
	
	public AtividadesRepository() {
		this.atividades = new HashMap<String, Atividade>();
		this.atividadesListadas = new ArrayList<Atividade>();
	}
	
	public String completaHashCode(Atividade a) {
		String ans = "";
		ans += a.meuHashCode() + "-";
		ans += Integer.toString(this.atividades.size());
		a.setMeuHashCode(ans);
		return ans;
	}
	
	public String cadastrarAtividade(String nome, String descricao, String cpf) {
		Atividade atv1 = new Atividade(nome, descricao,cpf);
		this.atividadesListadas.add(atv1);
		this.atividades.put(this.completaHashCode(atv1), atv1);
		return this.completaHashCode(atv1);
	}
	
	public Atividade getAtividade(String idAtividade) {
		return this.atividades.get(idAtividade);
	}
	
	
}
