package src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Item {
    //Cada Item tem um livro associado
	Livro livro;
    LocalDateTime dataDevolucao ;
    
    //Quando um item � criado, um livro � associado a ele
	public Item(Livro livro) {
		super();
		this.livro = livro;
		
	}


	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDateTime localDate) {
		this.dataDevolucao = localDate;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
    // Método para calcular a data de Devolucao de cada Item
    public LocalDateTime calculaDataDevolucao(LocalDateTime data, int num) {
    	dataDevolucao = LocalDateTime.now();
    	int aux = num;
    	int diasAdicionais;
        if (aux == 1) {
            diasAdicionais = 5;
        } else if (aux >= 2 && aux <= 10) {
            diasAdicionais = 5 + 2 * (aux - 1);
        } else {
            throw new IllegalArgumentException("Número inválido de livros");
        }
        dataDevolucao = data.plusDays(diasAdicionais);
        return dataDevolucao;
    }

}
