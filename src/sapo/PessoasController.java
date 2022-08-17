package sapo;

import java.util.ArrayList;

public class PessoasController {
	
	private PessoasService service;
	
	public PessoasController() {
		this.service = new PessoasService();
	}
	
	public void cadastrarPessoa(String cpf, String nome , String[] habilidades) {
		
		if (cpf.equals("") || nome.equals("")) {
			throw new IllegalArgumentException();
		}
		else {
			this.service.cadastrarPessoa(cpf, nome, habilidades);
		}
	}
	
	public String exibirPessoa(String cpf) {
		return this.service.exibirPessoa(cpf);
	}
	
	public void alterarNomePessoa(String cpf,String novoNome) {
		this.service.alterarNomePessoa(cpf, novoNome);
	}
	
	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		this.service.alterarHabilidadesPessoa(cpf, novasHabilidades);
	}
	public void removerPessoa(String cpf) {
		this.service.removerPessoa(cpf);
	}
	
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		this.service.adicionarComentarioPessoa(cpf, comentario, autorCpf);
	}
	
	public String listarComentariosPessoa(String cpf) {
		return this.service.listarComentariosPessoa(cpf);
	}
	
	public PessoasService getService() {
		return this.service;
	}
	
	public ArrayList<Pessoas> busca(String termos) {
		return this.service.busca(termos);
	}
}
