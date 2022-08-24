package sapo;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PessoasTest extends BaseTest {

	@Test
	void testBusca(){
		String[] palavras2 = {"cachorro", "sol", "sorvete","futebol"};
		String cpf1 = "388-567-123-65";	
		this.ps.cadastrarPessoa(cpf1, "joao victor", palavras2);
		String[] palavras3 = {"sorvete","futebol"};
		String cpf2 = "388-567-123-33";
		this.ps.cadastrarPessoa(cpf2, "joao pedro", palavras3);
		
		assertEquals(2,this.ps.busca("joao").size());
	}
	
	@Test
	void testBuscaAtivida(){
		
		String cpf1 = "388-567-123-65";
		
		this.as.cadastrarAtividade("ana","Joao Pedro Campos Porto", cpf1);
		
		assertEquals(1,this.as.buscaAtividade("pedro").size());
	}
	
	@Test
	void testBuscaTarefa(){
		
		String cpf1 = "388-567-123-65";
		String[] habilidades = {"guerra" , "luta"};
		this.ps.cadastrarPessoa(cpf1, "ana", habilidades);
		this.as.cadastrarAtividade("Joao","aluno", cpf1);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		assertEquals(1,this.as.buscaTarefas("correr").size());
	}
	
	@Test
	void testBuscaTarefaPeloId(){
		
		String cpf1 = "388-567-123-65";
		String[] habilidades = {"guerra" , "luta"};
		this.ps.cadastrarPessoa(cpf1, "ana", habilidades);
		this.as.cadastrarAtividade("Joao","aluno", cpf1);
		this.as.cadastraTarefa("JXX-0", "correr", habilidades);
		this.as.associarPessoaTarefa(cpf1, "JXX-0-0");
		assertEquals(1,this.as.buscaTarefas("JXX-0", "correr").size());
	}
	

}
