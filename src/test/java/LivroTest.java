

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LivroTest {
	@Test
	public void testVerificaLivro() {

		Livro livroDisponivel = new Livro(3);
		assertTrue(livroDisponivel.verificaLivro());


		Livro livroIndisponivel = new Livro(1);
		assertFalse(livroIndisponivel.verificaLivro());

		
		Livro livroLimiteInferior = new Livro(Integer.MIN_VALUE);
		assertFalse(livroLimiteInferior.verificaLivro());

		Livro livroLimiteSuperior = new Livro(Integer.MAX_VALUE);
		assertFalse(livroLimiteSuperior.verificaLivro());
	}
}
 