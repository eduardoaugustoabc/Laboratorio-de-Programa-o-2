package sapo;

public class Comentario {
	
	private String autor;
	private String descricao;
	
	public Comentario(String autor, String descricao) {
		this.autor = autor;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		String representacao= "-- " + this.descricao + " (" + this.autor + ")";
		return representacao;
	}
}
