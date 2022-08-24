package sapo;

import static org.junit.jupiter.api.Assertions.*;

import sapo.atividades.Atividade;
import sapo.atividades.AtividadeService;
import sapo.pessoas.*;

import org.junit.jupiter.api.Test;

class TarefasTest extends BaseTest {
	
	@Test
	void testCadastraTarefa() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		assertEquals(1, this.as.getRepositorio().get("JXX-0").getTarefas().size());
	}
	
	@Test
	void testAlteraNomeTarefa() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.alterarNomeTarefa("JXX-0-0", "nadar");
		assertEquals("nadar", this.as.getRepositorio().get("JXX-0").getTarefa("JXX-0-0").getNome());
	}
	
	@Test 
	void testAlteraHabilidadesTarefa(){
		String[] habilidades = {"andar", "pular"};
		String[] novasHabilidades = {"lutar", "trotar"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.alterarHabilidadesTarefa("JXX-0-0", novasHabilidades);
		assertEquals(novasHabilidades, this.as.getRepositorio().get("JXX-0").getTarefa("JXX-0-0").getHabilidades());
	}
	
	@Test
	void testAdicionaHorasTarefa() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.adicionarHorasTarefa("JXX-0-0", 10);
		assertEquals(10, this.as.getRepositorio().get("JXX-0").getTarefa("JXX-0-0").getDuracao());
	}
	
	@Test
	void testRemoverHorasTarefa() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.adicionarHorasTarefa("JXX-0-0", 10);
		this.as.removerHorasTarefa("JXX-0-0", 3);
		assertEquals(7, this.as.getRepositorio().get("JXX-0").getTarefa("JXX-0-0").getDuracao());
	}
	
	@Test
	void testConcluirTarefa() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.concluirTarefa("JXX-0-0");
		assertEquals(true, this.as.getRepositorio().get("JXX-0").getTarefa("JXX-0-0").getConcluido());
	}
	
	@Test
	void testRemoveTarefa() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.cadastraTarefa("JXX-0", "voar", habilidades);
		this.as.removerTarefa("JXX-0-0");
		assertEquals(1, this.as.getRepositorio().get("JXX-0").getTarefas().size());
	}
	
	@Test
	void testAssociaPessoaTarefa() {
		String[] palavras = {"cachorro", "sol", "sorvete","futebol"};
		String cpf = "388-567-123-65";	
		this.ps.cadastrarPessoa(cpf, "ana", palavras);
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf, "JXX-0-0");
		assertEquals(1, this.as.getRepositorio().get("JXX-0").getTarefa("JXX-0-0").getEquipe().size());
	}
	
	@Test
	void testRemoverPessoaTarefa() {
		String[] palavras = {"cachorro", "sol", "sorvete","futebol"};
		String cpf = "388-567-123-65";	
		this.ps.cadastrarPessoa(cpf, "ana", palavras);
		String[] palavras2 = {"sorvete","futebol"};
		String cpf2 = "388-567-123-33";
		this.ps.cadastrarPessoa(cpf2, "joao", palavras2);
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf, "JXX-0-0");
		this.as.associarPessoaTarefa(cpf2, "JXX-0-0");
		this.as.removerPessoaTarefa(cpf, "JXX-0-0");
		assertEquals(1, this.as.getRepositorio().get("JXX-0").getTarefa("JXX-0-0").getEquipe().size());
	}
	
	@Test
	void testExibirTarefa() {
		String[] habilidades = {"andar", "pular"};
		String cpf = "388.567.123-65";
		this.as.cadastrarAtividade("Joao", "estudante", cpf);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		String[] palavras = {"cachorro", "sol", "sorvete","futebol"};	
		this.ps.cadastrarPessoa(cpf, "ana", palavras);
		this.as.associarPessoaTarefa(cpf, "JXX-0-0");
		this.as.adicionarHorasTarefa("JXX-0-0", 7);
		String res = this.as.exibeTarefa("JXX-0-0");
		String esperado = "correr - JXX-0-0\n- Joao\n(7 hora(s) executada(s))\n===\nEquipe:\nana - 388.567.123-65\n";
		assertEquals(esperado, res);
	}
	
}