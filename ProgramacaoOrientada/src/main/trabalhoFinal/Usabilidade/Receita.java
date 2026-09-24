package Usabilidade;

import java.time.LocalDate;

public class Receita extends Lancamento {
	private CategoriaReceita categoria;

	public Receita(String descricao, double valor, LocalDate data, CategoriaReceita categoria) {
		super(descricao, valor, data, Tipo.RECEITA);
		this.categoria = categoria;
                
	}

	public CategoriaReceita getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaReceita categoria) {
		this.categoria = categoria;
	}
	
	
}
