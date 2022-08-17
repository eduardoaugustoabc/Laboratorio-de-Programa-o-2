package sapo;

import org.junit.jupiter.api.*;

public class BaseTest {
	
	protected PessoasController pc;
	
	@BeforeEach
	public void base() {
		this.pc = new PessoasController();
	}
}