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
		
		Atividade atv = new Atividade("Ricardo", "estudante", "388-567-123-65");
		this.facade
		String ans = this.as.completaHashCode(atv);
		assertEquals("RCR-0", ans);
	}

	@Test
	void testHashCodePoucasConsoantes() {
		Atividade atv = new Atividade("Joao", "estudante", "388-567-123-65");
		String ans = this.as.completaHashCode(atv);
		assertEquals("JXX-0", ans);
	}
	
	@Test
	void testCadastraAtividade() {
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		assertEquals(1, this.as.getRepositorio().size());
	}

	@Test
	void testAlteraDescricaoAtividade() {
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.alterarDescricaoAtividade("JXX-0", "professor");
		assertEquals("professor", this.as.getRepositorio().get("JXX-0").getDescricao());
	}
	
	@Test
	void testAlteraResponsavelAtividade() {
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.alterarResponsavelAtividade("JXX-0", "000-000-000-00");
		assertEquals("000-000-000-00", this.as.getRepositorio().get("JXX-0").getCpf());
	}
	
	@Test
	void testEncerrarAtividade() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.concluirTarefa("JXX-0-0");
		this.as.encerrarAtividade("JXX-0");
		assertEquals("encerrada", this.as.getRepositorio().get("JXX-0").getStatus());
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
		this.as.cadastrarAtividade("Joao", "estudante", cpf);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		String ans = this.as.exibirAtividade("JXX-0");
		String esperado = "JXX-1: Joao\nResponsável: ana - 388.567.123-65\n===\nestudante\n=== \nTarefas: 0/1\n- correr - JXX-0-0\n";
		assertEquals(esperado, ans);
	}
	
	@Test
	void testReabrirAtividade() {
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.encerrarAtividade("JXX-0");
		this.as.reabrirAtividade("JXX-0");
		assertEquals("aberta", this.as.getRepositorio().get("JXX-0").getStatus());
	}
}