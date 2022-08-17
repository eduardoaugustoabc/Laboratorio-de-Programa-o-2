package sapo;

import java.util.ArrayList;
import java.util.Map;

public class PessoasService {
	
	private PessoasRepository repositorioPessoas = new PessoasRepository();
	
	public PessoasService() {
		
	}
	
	public void cadastrarPessoa(String cpf, String nome , String[] habilidades) {
		Pessoas pessoa = new Pessoas(cpf,nome,habilidades);
		this.repositorioPessoas.put(cpf, pessoa);
	}
	
	public String exibirPessoa(String cpf) {
		return this.repositorioPessoas.get(cpf).toString();
	}
	
	public void alterarNomePessoa(String cpf,String novoNome) {
		this.repositorioPessoas.get(cpf).setNome(novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		this.repositorioPessoas.get(cpf).setHabilidades(novasHabilidades);
	}
	
	public void removerPessoa(String cpf) {
		this.repositorioPessoas.remove(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		
		this.repositorioPessoas.get(cpf).adicionarComentarioPessoa(autorCpf, comentario);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return this.repositorioPessoas.get(cpf).listaComentarios();
	}
	
	public Map<String, Pessoas> getRepositorio(){
		return this.repositorioPessoas.getMap();
	}
	
	public ArrayList<Pessoas> busca(String termos) {
		return this.repositorioPessoas.busca(termos);
	}
}
