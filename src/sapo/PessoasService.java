package sapo;

import java.util.Map;

public class PessoasService {
	
	private Map<String, Pessoas> repositorioPessoas;
	
	public PessoasService() {
		
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
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		String nomeAutor = this.repositorioPessoas.get(autorCpf).getNome();
		this.repositorioPessoas.get(cpf).adicionarComentarioPessoa(autorCpf, comentario);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return this.repositorioPessoas.get(cpf).listaComentarios();
	}
}
