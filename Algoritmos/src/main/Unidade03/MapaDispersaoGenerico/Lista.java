package MapaDispersaoGenerico;

public class Lista<T> {
    private NoLista<T> primeiro;

    public Lista() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>(valor);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

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
        NoLista<T> p = primeiro;
        int contador = 0;

        while (p != null) {
            contador = contador + 1;
            p = p.getProximo();
        }
        return contador;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException("Índice inválido: " + idx);
        }

        NoLista<T> p = primeiro;
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

        NoLista<T> p = primeiro;
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