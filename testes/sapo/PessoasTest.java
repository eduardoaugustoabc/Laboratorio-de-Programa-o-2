package sapo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sapo.pessoas.Pessoas;

class PessoasTest {

	@Test
	void testCria1() {
		String[] palavras = {"gato", "lua", "sorvete","musica"};
		Pessoas pessoa = new Pessoas("111-377-199-33", "joao", palavras);
		assertEquals(pessoa.getNome(),"joao", "Nome Correto");
	}
	
	@Test
	void testCria2() {
		
	}
}
