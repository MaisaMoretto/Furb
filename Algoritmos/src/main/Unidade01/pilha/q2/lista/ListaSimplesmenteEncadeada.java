package pilha.q2.lista;

public class ListaSimplesmenteEncadeada<T> {
    private NoListaSimplesmente<T> primeiro;

    public ListaSimplesmenteEncadeada() {
        this.primeiro = null;
    }

    public NoListaSimplesmente<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaSimplesmente<T> novo = new NoListaSimplesmente<>(valor);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoListaSimplesmente<T> buscar(T valor) {
        NoListaSimplesmente<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaSimplesmente<T> anterior = null;
        NoListaSimplesmente<T> p = primeiro;

        while ((p != null) && (!p.getInfo().equals(valor))) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    public int obterComprimento() {
        NoListaSimplesmente<T> p = primeiro;
        int contador = 0;

        while (p != null) {
            contador = contador + 1;
            p = p.getProximo();
        }
        return contador;
    }

    public NoListaSimplesmente<T> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException("Índice inválido: " + idx);
        }

        NoListaSimplesmente<T> p = primeiro;
        int posicaoAtual = 0;

        while (p != null) {
            if (posicaoAtual == idx) {
                return p;
            }
            p = p.getProximo();
            posicaoAtual = posicaoAtual + 1;
        }
        throw new IndexOutOfBoundsException("Índice inválido: " + idx);
    }

    public String toString() {
        String resultado = "";

        NoListaSimplesmente<T> p = primeiro;
        while (p != null) {
            resultado += p.getInfo();

            if (p.getProximo() != null) {
                resultado += ",";
            }
            p = p.getProximo();
        }
        return resultado;
    }
}