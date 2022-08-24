package sapo.pessoas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PessoasService {
	

	private PessoasRepository repositorioPessoas;
	
	public PessoasService() {
		this.repositorioPessoas = new PessoasRepository();
	}
	
	public void cadastrarPessoa(String cpf, String nome , String[] habilidades) {
		this.repositorioPessoas.put(cpf, new Pessoas(cpf,nome,habilidades));
		
		if (cpf.equals("") || nome.equals("")) {
			throw new IllegalArgumentException();
		}
		else {
			
		
			Pessoas pessoa = new Pessoas(cpf,nome,habilidades);
			this.repositorioPessoas.put(cpf, pessoa);
		}

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
	
	public ArrayList<Pessoas> busca(String termos) {
		return this.repositorioPessoas.busca(termos);

	}

	public void cadastrarAluno(String cpf, String nome, String matr, int periodo, String[] habilidades){
		Pessoas aluno = new Pessoas(cpf, nome, habilidades, new Aluno(matr, periodo));
		aluno.setAuxiliar(2);
		this.repositorioPessoas.put(cpf, aluno);
	}

	public void cadastrarProfessor(String cpf, String nome, int siape, String[] disciplinas){
		Pessoas professor = new Pessoas(cpf, nome, disciplinas, new Professor(siape, disciplinas));
		professor.setAuxiliar(1);
		this.repositorioPessoas.put(cpf, professor);
	}

	public void definirFuncaoProfessor(String cpf, int siape, String[] disciplinas){
		Pessoas atual = this.getPessoa(cpf);
		atual.setProfessor(siape, disciplinas);
	}

	public void definirFuncaoAluno(String cpf, String matr, int periodo){
		Pessoas atual = this.getPessoa(cpf);
		atual.setAluno(matr, periodo);
	}

	public void removerFuncao(String cpf){
		Pessoas atual = this.getPessoa(cpf);
		atual.setAuxiliar(0);
	}

	public Pessoas getPessoa(String cpf){
		return this.repositorioPessoas.get(cpf);
	}
	
	/**public List<String> listarPessoas() {
		List<String> ans = new ArrayList();
		List<Pessoas> lista = this.repositorioPessoas.getListaPessoas();
		for (int i = 0; i < this.repositorioPessoas.getTamanho(); i++) {
			ans.add(lista.get(i).)
		}
	}*/
}
