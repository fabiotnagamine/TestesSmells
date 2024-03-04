
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AlunoTest {

	public String identificador;

	// Magic number
	@Test
	public void verificaAlunoCod10Test() {
		identificador = "10";
		Aluno aluno = new Aluno(identificador);
		assertFalse(aluno.verficaAluno());
	}

	// Magic Number
	@Test
	public void testVerficaAlunoCodigoDiferente10() {
		identificador = "12345";
		Aluno aluno = new Aluno(identificador);
		assertTrue(aluno.verficaAluno());
	}

	// Magic Number
	@Test
	public void testVerficaAlunoVazioOuNulo() {
		identificador = "";
		Aluno aluno = new Aluno(identificador);
		assertTrue(aluno.verficaAluno());
	}

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	// Magic Number
	@Test
	public void testVerificaDebitoCodigo4() {
		identificador = "4";
		Aluno aluno = new Aluno("4");
		assertFalse(aluno.verificaDebito());
	}

	// Magic Number
	@Test
	public void testVerificaDebitoCodigoDiferente4() {
		identificador = "123";
		Aluno aluno = new Aluno(identificador);
		assertTrue(aluno.verificaDebito());
	}

	@Test
	public void testVerificaDebitoComValorString() {
		exceptionRule.expect(NumberFormatException.class);
		// Alteração testSmell (Exibição de uma mensagem de erro
		exceptionRule.expectMessage("Esperava-se números, e não letras Ex: 123456789");
		Aluno aluno = new Aluno("AlgumaCoisa");
		assertTrue(aluno.verificaDebito());
	}

	@Test
	public void testVerificaDebitoCodigoVazioOuNulo() {
		exceptionRule.expect(NumberFormatException.class);
		Aluno aluno = new Aluno("");
		assertTrue(aluno.verificaDebito());
	}
}
