package sapo.pessoas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PessoasRepository {
	
	private Map<String, Pessoas> repositorioPessoas;
	private ArrayList<Pessoas> listaPessoas;
	
	public PessoasRepository() {
		this.repositorioPessoas = new HashMap<String, Pessoas>();
		this.listaPessoas = new ArrayList<Pessoas>();
	}
	
	public Pessoas get(String id) {
		return this.repositorioPessoas.get(id);
	}
	
	public void put(String id, Pessoas pessoa) {
		this.repositorioPessoas.put(id, pessoa);
		this.listaPessoas.add(pessoa);
		
	}
	
	public void remove(String id) {
		this.repositorioPessoas.remove(id);
	}
	
	public Map<String, Pessoas> getMap() {
		return this.repositorioPessoas;
	}
	
	public ArrayList<Pessoas> busca(String termos) {
		String[] termosArray = termos.split(" ");
		ArrayList<Pessoas> pessoasTermos = new ArrayList<Pessoas>();
		for(int b = 0 ; b < this.listaPessoas.size(); b ++) {
			pessoasTermos.add(this.listaPessoas.get(b));
			System.out.println(pessoasTermos.get(b));
		}
		
			for(int a = 0 ; a < pessoasTermos.size(); a ++) {
				
				for(int u = 0; u < termosArray.length; u++) {
					if(!pessoasTermos.get(a).getTermos().contains(termosArray[u])) {
						pessoasTermos.remove(a);
					}
				}
			}
		return pessoasTermos;
		
		
	}	
}
