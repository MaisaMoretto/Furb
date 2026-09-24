package Usabilidade;

public enum CategoriaReceita {
    SALARIO("Salário"),
    DECIMO_TERCEIRO("Décimo terceiro"),
    FERIAS("Férias"),
    OUTRAS_RECEITAS("Outras receitas");
	
    /**
     * Listando as categorias possíveis para receitas.
     */
    private final String descricao;

    /**
     * Cada constante (enum) carrega um texto em português (com acentos) para
     * ser exibido na interface.
     *
     * @param descricao
     */
    CategoriaReceita(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    /**
     * Sobrescreve o método padrão de Object para retornar a descrição legível
     * (ex: "Salário") em vez do nome da constante ("SALARIO"). Isso é usado nas
     * tabelas da interface para melhorar a experiência do usuário.
     *
     * @param descricao
     * @return
     */
    public static CategoriaReceita fromDescricao(String descricao) {
        for (CategoriaReceita categoria : values()) {
            if (categoria.descricao.equals(descricao)) {
                return categoria;
            }
        }

        throw new IllegalArgumentException("Categoria inválida: " + descricao);
    }
}
