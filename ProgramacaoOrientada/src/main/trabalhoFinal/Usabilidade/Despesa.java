package poo.trabalhoFinal.Usabilidade;

import java.time.LocalDate;

public class Despesa extends Lancamento {

    private CategoriaDespesa categoria;

    public Despesa(String descricao, double valor, LocalDate data, CategoriaDespesa categoria) {
        super(descricao, valor, data, Tipo.DESPESA);
        this.categoria = categoria;
    }

    public CategoriaDespesa getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDespesa categoria) {
        this.categoria = categoria;
    }
}
