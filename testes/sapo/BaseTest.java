package sapo;

import sapo.atividades.AtividadeService;
import sapo.busca.BuscaService;
import sapo.pessoas.PessoasService;

public class BaseTest {
	protected PessoasService ps;
	protected AtividadeService as;
	protected BuscaService bs;
	protected Facade facade;
	
	public BaseTest() {
		this.ps = new PessoasService();
		this.as = new AtividadeService(ps);
		this.bs = new BuscaService(ps, as);
		this.facade = new Facade(ps,as,bs);
	}
}
