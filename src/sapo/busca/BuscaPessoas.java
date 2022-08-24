package sapo.busca;

import java.util.ArrayList;

import sapo.pessoas.*;

public class BuscaPessoas implements Busca{
	private ArrayList<Pessoas> pessoas;
	private String tipo;
	
	public BuscaPessoas(ArrayList<Pessoas> pessoas) {
		this.pessoas = pessoas;
		this.tipo = "PESSOAS";
	}
	
	@Override
	public String representacaoBusca(){
		String representacao = "";
		representacao += (tipo) + "\n" ;
		for(int a = 0; a < this.pessoas.size();a++) {
			representacao += this.pessoas.get(a).toString() + "\n";
		}
		return representacao;
	}
}
