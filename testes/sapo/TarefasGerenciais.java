package sapo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sapo.atividades.Tarefa;

class TarefasGerenciais extends BaseTest {

	@Test
	void testCadastraTarefa() {
		String[] habilidades = {"andar", "pular"};
		this.as.cadastrarAtividade("Joao", "estudante", "388-567-123-65");
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		String[] ts = {"JXX-0-0"};
		assertEquals(1, this.as.CadastraTarefaGerencial("JXX-0", "JOAO",ts, habilidades));
		
	}

}
