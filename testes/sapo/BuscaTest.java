package sapo;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sapo.atividades.AtividadeService;
import sapo.busca.BuscaService;
import sapo.pessoas.PessoasService;

class BuscaTest extends BaseTest {

	@Test
	void testBusca(){
		ps = new PessoasService();
		
		String[] palavras2 = {"cachorro", "sol", "sorvete","futebol"};
		String cpf1 = "388-567-123-65";	
		ps.cadastrarPessoa(cpf1, "joao victor", palavras2);
		String[] palavras3 = {"sorvete","futebol"};
		String cpf2 = "388-567-123-33";
		ps.cadastrarPessoa(cpf2, "joao pedro", palavras3);
		as = new AtividadeService(ps);
		bs = new BuscaService(ps, as);
		assertEquals(2,this.bs.exibirPessoas("joao").size());
	}
	
	@Test
	void testBuscaAtivida(){
		
		String cpf1 = "388-567-123-65";
		this.as = new AtividadeService(this.ps);
		this.as.cadastrarAtividade("ana","Joao Pedro Campos Porto", cpf1);
		this.bs = new BuscaService(this.ps,this.as);
		assertEquals(1,this.bs.buscaAtividade("pedro").size());
	}
	
	@Test
	void testBuscaTarefa(){
		
		String cpf1 = "388-567-123-65";
		String[] habilidades = {"guerra" , "luta"};
		this.ps.cadastrarPessoa(cpf1, "ana", habilidades);
		this.as = new AtividadeService(this.ps);
		
		this.as.cadastrarAtividade("Joao","aluno", cpf1);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		this.bs = new BuscaService(this.ps,this.as);
		assertEquals(1,this.bs.buscaTarefa("correr").size());
	}
	
	@Test
	void testBuscaTarefaPeloId(){
		
		String cpf1 = "388-567-123-65";
		String[] habilidades = {"guerra" , "luta"};
		this.ps.cadastrarPessoa(cpf1, "ana", habilidades);
		this.as = new AtividadeService(this.ps);
		this.as.cadastrarAtividade("Joao","aluno", cpf1);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		this.bs = new BuscaService(this.ps,this.as);
		assertEquals(1,this.bs.buscaTarefa("JXX-0", "correr").size());
	}
	
	@Test
	void testSugereTarefa(){
		
		String cpf1 = "388-567-123-65";
		String[] habilidades = {"guerra" , "luta"};
		this.ps.cadastrarPessoa(cpf1, "ana", habilidades);
		this.as = new AtividadeService(this.ps);
		
		this.as.cadastrarAtividade("Joao","aluno", cpf1);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		this.as.cadastraTarefa("JXX-0", "nadar", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		this.bs = new BuscaService(this.ps,this.as);
		assertEquals(2,this.bs.sugerirTarefa(cpf1).size());
	}
	
	@Test
	void testHistorico(){
		
		String cpf1 = "388-567-123-65";
		String[] habilidades = {"guerra" , "luta"};
		this.ps.cadastrarPessoa(cpf1, "ana", habilidades);
		this.as = new AtividadeService(this.ps);
		
		this.as.cadastrarAtividade("Joao","aluno", cpf1);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		this.as.cadastraTarefa("JXX-0", "nadar", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		this.bs = new BuscaService(this.ps,this.as);
		this.bs.sugerirTarefa(cpf1);
		assertEquals("SUGESTÃO\n"
				+ "JXX-0-0 correr\n"
				+ "JXX-0-1 nadar\n"
				,this.bs.exibeHistoricoBuscas(0));
	}
	
	@Test
	void testBuscaEspecifica(){
		
		String cpf1 = "388-567-123-65";
		String[] habilidades = {"guerra" , "luta"};
		this.ps.cadastrarPessoa(cpf1, "ana", habilidades);
		this.as = new AtividadeService(this.ps);
		
		this.as.cadastrarAtividade("Joao","aluno", cpf1);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		this.as.cadastraTarefa("JXX-0", "nadar", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		this.bs = new BuscaService(this.ps,this.as);
		this.bs.sugerirTarefa(cpf1);
		assertEquals("SUGESTÃO\n"
				+ "JXX-0-0 correr\n"
				+ "JXX-0-1 nadar\n"
				+ "\n"
				,this.bs.buscasRecentes(1));
	}

}