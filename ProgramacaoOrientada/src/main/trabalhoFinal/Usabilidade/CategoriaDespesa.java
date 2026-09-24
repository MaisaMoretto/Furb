package poo.trabalhoFinal.Usabilidade;

public enum CategoriaDespesa {
    ALIMENTACAO("Alimentação"),
    TRANSPORTE("Transporte"),
    RESIDENCIA("Residência"),
    SAUDE("Saúde"),
    EDUCACAO("Educação"),
    ENTRETENIMENTO("Entretenimento"),
    OUTRAS_DESPESAS("Outras despesas");

    /**
     * Listando as categorias possíveis para despesas.
     */
    private final String descricao;

    /**
     * Cada constante (enum) carrega um texto em português (com acentos) para
     * ser exibido na interface.
     * @param descricao
     */
    CategoriaDespesa(String descricao) {
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
    public static CategoriaDespesa fromDescricao(String descricao) {
        for (CategoriaDespesa categoria : values()) {
            if (categoria.descricao.equals(descricao)) {
                return categoria;
            }
        }

        throw new IllegalArgumentException("Categoria inválida: " + descricao);
    }
}
