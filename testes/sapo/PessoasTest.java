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
		this.ps.cadastrarPessoa("111-377-199-33", "joao", palavras);
		
		assertEquals(cpf,this.ps.getRepositorio().get("111-377-199-33").getCpf());
	}
	
	@Test
	void testCria2() {
		
		String[] palavras2 = {"cachorro", "sol", "sorvete","futebol"};
		String cpf1 = "388-567-123-65";
		this.ps.cadastrarPessoa(cpf1, "ana", palavras2);
		assertEquals(cpf1,this.ps.getRepositorio().get("388-567-123-65").getCpf());
		
		String[] palavras = {"gato", "lua", "sorvete","musica"};
		String cpf = "111-377-199-33";
		this.ps.cadastrarPessoa("111-377-199-33", "joao", palavras);
		
		assertEquals(cpf1,this.ps.getRepositorio().get("388-567-123-65").getCpf());
		assertEquals(cpf,this.ps.getRepositorio().get("111-377-199-33").getCpf());
	}
	
	@Test
	void testCria1_2(){
		String[] palavras2 = {"cachorro", "sol", "sorvete","futebol"};
		String cpf1 = "388-567-123-65";
		this.ps.cadastrarPessoa(cpf1, "ana", palavras2);
		assertEquals(cpf1,this.ps.getRepositorio().get("388-567-123-65").getCpf());
		
	}
	
	@Test
	void testRemove1(){
		String[] palavras2 = {"cachorro", "sol", "sorvete","futebol"};
		String cpf1 = "388-567-123-65";
		this.ps.cadastrarPessoa(cpf1, "ana", palavras2);
		this.ps.removerPessoa(cpf1);
		assertEquals(null,this.ps.getRepositorio().get("388-567-123-65"));
		
	}
	
	@Test
	void testRemove2() {
		
		String[] palavras2 = {"cachorro", "sol", "sorvete","futebol"};
		String cpf1 = "388-567-123-65";
		this.ps.cadastrarPessoa(cpf1, "ana", palavras2);
		assertEquals(cpf1,this.ps.getRepositorio().get("388-567-123-65").getCpf());
		
		String[] palavras = {"gato", "lua", "sorvete","musica"};
		String cpf = "111-377-199-33";
		this.ps.cadastrarPessoa("111-377-199-33", "joao", palavras);
		this.ps.removerPessoa(cpf);
		this.ps.removerPessoa(cpf1);
		assertEquals(null,this.ps.getRepositorio().get("388-567-123-65"));
		assertEquals(null,this.ps.getRepositorio().get("111-377-199-33"));
	}
	
	@Test
	void testComentarios() {
		
		String[] palavras = {"gato", "lua", "sorvete","musica"};
		String cpf = "111-377-199-33";
		this.ps.cadastrarPessoa("111-377-199-33", "joao", palavras);
		
		assertEquals(cpf,this.ps.getRepositorio().get("111-377-199-33").getCpf());
		this.ps.adicionarComentarioPessoa(cpf, "Joao nasceu em joao pessoa", "yasmin");
		assertEquals("joao - 111-377-199-33\n"
				+ "Comentários:\n"
				+ "-- Joao nasceu em joao pessoa (yasmin)",this.ps.listarComentariosPessoa(cpf));
	}
	
	@Test
	void testMudaNome1() {
		
		String[] palavras = {"gato", "lua", "sorvete","musica"};
		String cpf = "111-377-199-33";
		this.ps.cadastrarPessoa("111-377-199-33", "joao", palavras);
		
		assertEquals("joao",this.ps.getRepositorio().get("111-377-199-33").getNome());
		this.ps.alterarNomePessoa(cpf, "joao pedro");
		assertEquals("joao pedro",this.ps.getRepositorio().get("111-377-199-33").getNome());
	}
	
	@Test
	void testMudHabilidades1() {
		
		String[] palavras = {"gato", "lua", "sorvete","musica"};
		String cpf = "111-377-199-33";
		this.ps.cadastrarPessoa("111-377-199-33", "joao", palavras);
		String[] palavras2 = {"aluno", "pleno", "dev web","programador"};
	
		this.ps.alterarHabilidadesPessoa(cpf, palavras2);
		assertEquals(palavras2,this.ps.getRepositorio().get("111-377-199-33").getHabilidades());
	}
	
	@Test
	void testExibeCOntao(){
		String[] palavras2 = {"cachorro", "sol", "sorvete","futebol"};
		String cpf1 = "388-567-123-65";
		this.ps.cadastrarPessoa(cpf1, "ana", palavras2);
		assertEquals(cpf1,this.ps.getRepositorio().get("388-567-123-65").getCpf());
		assertEquals("ana - 388-567-123-65\n"
				+ "- cachorro\n"
				+ "- futebol\n"
				+ "- sol\n"
				+ "- sorvete",this.ps.exibirPessoa(cpf1));
	}
	
	@Test
    public void testNomeVazio() {

    	try {
    		String[] palavras = {"gato", "lua", "sorvete","musica"};
    		String cpf = "111-377-199-33";
    		this.ps.cadastrarPessoa("111-377-199-33", "", palavras);
    		fail("era esperada uma exceção");
    		
    	} catch (IllegalArgumentException ile) {	

    		}
    }
	
	@Test
    public void testCpfVazio() {

    	try {
    		String[] palavras = {"gato", "lua", "sorvete","musica"};
    		String cpf = "111-377-199-33";
    		this.ps.cadastrarPessoa("", "joao", palavras);
    		fail("era esperada uma exceção");
    		
    	} catch (IllegalArgumentException ile) {	

    		}
    }
	
	@Test
	void testMudHabilidades1Vazio() {
		try {
    		
    		String[] palavras = {"gato", "lua", "sorvete","musica"};
    		String cpf = "111-377-199-33";
    		this.ps.cadastrarPessoa("111-377-199-33", "joao", palavras);
    		String[] palavras2 = {"aluno", "pleno", "dev web","programador"};
	
    		this.ps.alterarHabilidadesPessoa(cpf, palavras2);
    		this.ps.alterarHabilidadesPessoa("", palavras2);
		} catch (IllegalArgumentException ile) {	

		}
	}
}