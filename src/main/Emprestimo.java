	package src;
	
	import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
	
	public class Emprestimo {
	
		Date dataEmprestimo = new Date();
		Date dataPrevista = new Date();
		Date data_aux = new Date();
		String nome;
		//Cada emprestimo tem um conjutno de itens
	    List<Item> item = new ArrayList<Item>();
	    int emprestimo=0;
		
		public Date getDataEmprestimo() {
			return dataEmprestimo;
		}
	
		public void setDataEmprestimo(Date dataEmprestimo) {
			this.dataEmprestimo = dataEmprestimo;
		}
	
		
		// Metodo respons�vel por realizar o empr�stimo
		public boolean emprestar(List<Livro> livros, int num) {
            if (livros.isEmpty() || num <= 0) {
                System.out.println("Nenhum livro para emprestar.");
                return false;
            }

            // Para o número de livros a ser emprestado
            for (int i = 0; i < num && i < livros.size() && i < 10; i++) {
                // Adiciona um novo item no conjunto de itens, e passa o livro a ser associado a ele
                item.add(new Item(livros.get(i)));

                // Chama o método para calcular a data de devolução caso tenha pelo menos um livro que possa ser emprestado
                System.out.print("\nNumero de Livros Emprestados: " + item.size());
                System.out.print("\nData de Empréstimo: " + this.dataEmprestimo);
                System.out.print("\nData de Devolução: " + CalculaDataDevolucao(num));
                return true;
            }

            throw new Error("Não se pode emprestar mais que 10 livros");
        }
	    
	    private LocalDateTime CalculaDataDevolucao(int num) {
	        LocalDateTime dataAtual = LocalDateTime.now();
	        int aux = num;
	        int diasAdicionais;


	        
	        if (aux == 1) {
	            diasAdicionais = 5;
	        } else if (aux >= 2 && aux <= 10) {
	            diasAdicionais = 5 + 2 * (aux - 1);
	        } else {
	            throw new IllegalArgumentException("Número inválido de livros");
	        }

	        LocalDateTime dataPrevista = dataAtual.plusDays(diasAdicionais);
	        
	        for (int j = 0; j < item.size(); j++) {
	            item.get(j).setDataDevolucao(dataPrevista);
	        }

	        return dataPrevista;
	    }
	
		
		
	}
