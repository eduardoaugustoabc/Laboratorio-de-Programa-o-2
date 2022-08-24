package sapo;

import static org.junit.jupiter.api.Assertions.*;

import sapo.atividades.Atividade;
import sapo.atividades.AtividadeService;
import sapo.busca.BuscaService;
import sapo.pessoas.*;

import org.junit.jupiter.api.Test;

class AtividadesTest extends BaseTest{
	
	@Test
	void testHashCode() {
		
		
		assertEquals("RCR-0",  this.facade.cadastrarAtividade("Ricardo", "estudante", "388-567-123-65"));
	}

	@Test
	void testHashCodePoucasConsoantes() {
		
		assertEquals("JXX-0", this.facade.cadastrarAtividade("Joao", "estudante", "388-567-123-65"));
	}
	
	@Test
	void testCadastraAtividade() {
		this.facade.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		assertEquals(1, this.as.getRepositorio().size());
	}

	@Test
	void testAlteraDescricaoAtividade() {
		this.facade.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.facade.alterarDescricaoAtividade("JXX-0", "professor");
		assertEquals("professor", this.facade.getAtiv().get("JXX-0").getDescricao());
	}
	
	
	
	@Test
	void testEncerrarAtividade() {
		String[] habilidades = {"andar", "pular"};
		this.facade.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.facade.cadastraTarefa("JXX-0", "correr", habilidades);
		this.facade.concluirTarefa("JXX-0-0");
		this.facade.encerrarAtividade("JXX-0");
		assertEquals("encerrada", this.facade.getAtiv().get("JXX-0").getStatus());
	}
	
	/**@Test
	void testDesativarAtividade() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.concluirTarefa("JXX-0-0");
		this.as.desativarAtividade("JXX-0");
		assertEquals("desativada", this.as.getRepositorio().get("JXX-0").getStatus());
	}*/
	
	@Test
	void testExibirAtividade() {
		String[] habilidades = {"andar", "pular"};
		String cpf = "388.567.123-65";
		this.facade.cadastrarAtividade("Joao", "estudante", cpf);
		this.facade.cadastraTarefa("JXX-0", "correr", habilidades);
		String ans = this.facade.exibirAtividade("JXX-0");
		String esperado = "JXX-1: Joao\nResponsável: ana - 388.567.123-65\n===\nestudante\n=== \nTarefas: 0/1\n- correr - JXX-0-0\n";
		assertEquals(esperado, ans);
	}
	
	@Test
	void testReabrirAtividade() {
		this.facade.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.facade.encerrarAtividade("JXX-0");
		this.facade.reabrirAtividade("JXX-0");
		assertEquals("aberta", this.as.getRepositorio().get("JXX-0").getStatus());
	}
}