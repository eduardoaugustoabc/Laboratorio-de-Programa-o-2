package sapo;

import java.util.ArrayList;

public class Pessoas {

	private String cpf;
	private String nome;
	private String[] habilidades;
	private ArrayList<String> comentarios;
	
	public Pessoas(String cpf, String nome, String[] habilidades) {
		this.cpf = cpf;
		this.habilidades = habilidades;
		this.nome = nome;
		this.comentarios = new ArrayList();
		
	}
	
	@Override
	public String toString() {
		String representacao = nome + " - " + cpf;
		String temp;
		for (int i = 0; i < this.habilidades.length; i++) {
            for (int j = i + 1; j < this.habilidades.length; j++) {
                
               
                if (this.habilidades[i].compareTo(this.habilidades[j]) > 0) {
                    temp = this.habilidades[i];
                    this.habilidades[i] = this.habilidades[j];
                    this.habilidades[j] = temp;
                }
            }
        }
		for(int a = 0;a< this.habilidades.length;a ++) {
			representacao = representacao + "\n" + "- " + this.habilidades[a];
		}
		
		return representacao;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setHabilidades(String[] novasHabilidades) {
		this.habilidades = novasHabilidades;
	}
	
	public void adicionarComentarioPessoa(String autor, String descricao) {
		Comentario coment = new Comentario(autor,descricao);
		
		this.comentarios.add(coment.toString());
	}
	
	public String listaComentarios() {
		String representacao = nome + " - " + cpf + "\n" + "Comentários:";
		for(int a = 0;a< this.comentarios.size();a ++) {
			representacao = representacao + "\n" + this.comentarios.get(a);
		}
		return representacao;
	}
	
	public String[] getHabilidades(){
		return this.habilidades;
	}
	
	public ArrayList<String> getTermos() {
		ArrayList<String> representacao = new ArrayList<String>();
		representacao.add(this.nome);
		representacao.add(this.cpf);
		for(int i=0; i < this.habilidades.length;i++) {
			String[] habilidade = this.habilidades[i].split(" ");
			for(int j = 0; j < habilidade.length;j ++) {
				representacao.add(habilidade[j]);
			}
		}
		
		
		return representacao;
	}
	
	
}