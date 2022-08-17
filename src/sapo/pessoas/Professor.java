package sapo.pessoas;

public class Professor implements Funcao {

	private int codigo;
    private String[] disciplinas;

	public Professor(int codigo, String[] disciplinas) {
		this.codigo = codigo;
        this.disciplinas = disciplinas;
	}

	@Override
	public String gerarDetalhes(Pessoas p) {
		return "PROFESSOR! ";// + this.dpto  + " " + p.getCPF();
	}

}