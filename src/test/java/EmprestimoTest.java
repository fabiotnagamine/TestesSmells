 

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EmprestimoTest {
	
	Livro[] livros = {
		    new Livro(1),
		    new Livro(2),
		    new Livro(3),
		    new Livro(4),
		    new Livro(5),
		    new Livro(6),
		    new Livro(7),
		    new Livro(8),
		    new Livro(9),
		    new Livro(10)
		};
	
	   public ArrayList<Livro> criaListaLivro() {
	        ArrayList<Livro> livrosAlem = new ArrayList<>();
	        for (int i = 0; i < 20; i++) {
	            livrosAlem.add(new Livro(i + 1)); // Adiciona livros com códigos de 1 a 20
	        }
	        return livrosAlem;
	    }


	public int codigoLivro;
	public int qtdeLivrosEmprestado;
	public static final int QTDEMAXIMADELIVROS = 10;
	
	
	//Magic Numbers
    @Test
    public void testEmprestarNenhumLivro() {
    	qtdeLivrosEmprestado = 0;
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        assertFalse(emprestimo.emprestar(livros,qtdeLivrosEmprestado));
    }

    //Magic Numbers
    @Test
    public void testEmprestarPeloMenosUmLivro() {
    	qtdeLivrosEmprestado = 1;
    	codigoLivro = 666;
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(codigoLivro)); 
        assertTrue(emprestimo.emprestar(livros,qtdeLivrosEmprestado));
    }

  
    //Magic Numbers
    //Redundant Assertion
//    @Test
//    public void testEmprestarPeloMenosUmLivroParticaoEquivalencia() {
//    	qtdeLivrosEmprestado = 1;
//    	codigoLivro = 7;
//        Emprestimo emprestimo = new Emprestimo();
//        List<Livro> livros = new ArrayList<>();
//        livros.add(new Livro(codigoLivro)); 
//        assertTrue(emprestimo.emprestar(livros,qtdeLivrosEmprestado));
//    }
    
    


    //Magic Numbers
    @Test
    public void testEmprestarMaximoLivros() {
    	qtdeLivrosEmprestado = 10;
        Emprestimo emprestimo = new Emprestimo();
        assertTrue(emprestimo.emprestar(Arrays.asList(livros),qtdeLivrosEmprestado));
    }
    
    //Eager test
//  List<Livro> livros = new ArrayList<>();
//  Random generator = new Random();
//  for (int i = 0; i < qtdeLivrosEmprestado; i++) {
//      livros.add(new Livro(generator.nextInt()));
//  }
    

    @Test
    public void testEmprestarNenhumLivroParticaoEquivalencia() {
    	qtdeLivrosEmprestado = 2;
        Emprestimo emprestimo = new Emprestimo();
        List<Livro> livros = new ArrayList<>();
        assertFalse(emprestimo.emprestar(livros, qtdeLivrosEmprestado));
    }
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    
    @Test
    public void testEmprestarAlem() {
    	qtdeLivrosEmprestado = 18;
    	
        Emprestimo emprestimo = new Emprestimo();
        Random generator = new Random();

        
        
        //Eager test
        // Adiciona 18 livros à lista
//        for (int i = 0; i < qtdeLivrosEmprestado; i++) {
//            livros.add(new Livro(generator.nextInt()));
//        }

        /**	Exceções esperadas (test Smell)
        assertThrows(Error.class, () -> {
        emprestimo.emprestar(livros, qtdeLivrosEmprestado);
    }); 
    *
    */
        // Utiliza assertThrows para verificar se a exceção é lançada ao tentar emprestar mais de 10 livros
        
        assertThrows(RuntimeException.class, () -> {
            emprestimo.emprestar(criaListaLivro(), qtdeLivrosEmprestado);
        });
    }
    
 
}
