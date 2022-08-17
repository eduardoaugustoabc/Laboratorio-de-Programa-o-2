package sapo.busca;

import java.util.ArrayList;

import sapo.pessoas.*;

public class BuscaPessoas implements Busca{
	private ArrayList<Pessoas> pessoas;
	private String tipo;
	
	public BuscaPessoas(ArrayList<Pessoas> pessoas) {
		this.pessoas = new ArrayList<Pessoas>();
		this.tipo = "PESSOAS";
	}
}
