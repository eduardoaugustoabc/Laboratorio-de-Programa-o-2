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
		this.ps.cadastrarPessoa(cpf1, "ana", palavras2);
		String[] palavras3 = {"sorvete","futebol"};
		String cpf2 = "388-567-123-33";
		this.ps.cadastrarPessoa(cpf2, "joao", palavras3);
		
		assertEquals(1,this.ps.busca("sol").size());
	}
	
	@Test
	void testBuscaAtivida(){
		
		String cpf1 = "388-567-123-65";
		
		this.as.cadastrarAtividade("ana","Joao Pedro Campos Porto", cpf1);
		
		assertEquals(1,this.as.buscaAtividade("Joao").size());
	}
	

}
