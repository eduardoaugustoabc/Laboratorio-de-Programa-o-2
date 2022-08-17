package sapo.pessoas;

public class Aluno implements Funcao {

	private String matr;
    private int periodo;

	public Aluno(String matr, int periodo) {
		this.matr = matr;
        this.periodo = periodo;
	}

	@Override
	public String gerarDetalhes(Pessoas p) {
		return "ALUNO!! " + this.matr;
	}

}