package sapo;

public class Aluno implements Funcao {

	private int matr;
    private int periodo;

	public Aluno(int matr, int periodo) {
		this.matr = matr;
        this.periodo = periodo;
	}

	@Override
	public String gerarDetalhes(Pessoas p) {
		return "ALUNO!! " + this.matr;
	}

}