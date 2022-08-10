package sapo.pessoas;

import java.util.Map;

public class PessoasService {
	
	private PessoasRepository repositorioPessoas;
	
	public PessoasService() {
		this.repositorioPessoas = new PessoasRepository();
	}
	
	public void cadastrarPessoa(String cpf, String nome , String[] habilidades) {
		this.repositorioPessoas.put(nome, new Pessoas(cpf,nome,habilidades));
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
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorNome) {
		
		this.repositorioPessoas.get(cpf).adicionarComentarioPessoa(autorNome, comentario);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return this.repositorioPessoas.get(cpf).listaComentarios();
	}
	
	public Map<String, Pessoas> getRepositorio(){
		return this.repositorioPessoas.getMap();
	}
}
