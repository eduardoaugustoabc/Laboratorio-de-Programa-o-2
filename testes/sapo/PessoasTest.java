package sapo;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PessoasTest extends BaseTest {

	
	
	@Test
	void testCria1() {
		
		String[] palavras = {"gato", "lua", "sorvete","musica"};
		String cpf = "111-377-199-33";
		this.pc.cadastrarPessoa("111-377-199-33", "joao", palavras);
		
		assertEquals(cpf,this.pc.getService().getRepositorio().get("111-377-199-33").getCpf());
	}
	
   
}