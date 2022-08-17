package sapo;

import java.util.Map;

public class PessoasService {
	
	private Map<String, Pessoas> repositorioPessoas;
	
	public PessoasService() {
		
	}
	
	public void cadastrarPessoa(String cpf, String nome , String[] habilidades) {
		this.repositorioPessoas.put(cpf, new Pessoas(cpf,nome,habilidades));
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
	
	public Map<String, Pessoas> getRepositorio(){
		return this.repositorioPessoas;
	}

	public void cadastrarAluno(String cpf, String nome, int matr, int periodo, String[] habilidades){
		Pessoas aluno = new Pessoas(cpf, nome, habilidades, new Aluno(matr, periodo));
		this.repositorioPessoas.put(cpf, aluno);
	}

	public void cadastrarProfessor(String cpf, String nome, int siape, String[] disciplinas){
		Pessoas professor = new Pessoas(cpf, nome, disciplinas, new Professor(siape, disciplinas));
		this.repositorioPessoas.put(cpf, professor);
	}

	public void definirFuncaoProfessor(String cpf, int siape, String[] disciplinas){
		Pessoas atual = this.getPessoa(cpf);
		//atual.setProfessor(f);
	}

	public Pessoas getPessoa(String cpf){
		return this.repositorioPessoas.get(cpf);
	}
}
