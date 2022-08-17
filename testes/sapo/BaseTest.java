package sapo;

import org.junit.jupiter.api.*;

import sapo.atividades.AtividadeService;
import sapo.pessoas.*;

public class BaseTest {
	
	protected PessoasService ps;
	protected AtividadeService as;
	
	@BeforeEach
	public void base() {
		this.ps = new PessoasService();
		this.as = new AtividadeService();
	}
}