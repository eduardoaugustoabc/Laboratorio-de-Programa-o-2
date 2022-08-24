package sapo;

import org.junit.jupiter.api.*;

import sapo.atividades.AtividadeService;
import sapo.busca.BuscaService;
import sapo.*;
import sapo.pessoas.*;

public class BaseTest {
	
	protected PessoasService ps;
	protected AtividadeService as;
	protected BuscaService bs;
	
	@BeforeEach
	public void base() {
		this.ps = new PessoasService();
		this.as = new AtividadeService();
		this.bs = new BuscaService();
	}
}