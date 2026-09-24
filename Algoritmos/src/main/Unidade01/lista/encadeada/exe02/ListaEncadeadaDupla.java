package lista.encadeada.exe02;

public class ListaEncadeadaDupla<T> {
    private NoListaDupla<T> primeiro;

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>(valor);
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);

        if (p != null) {
            if (primeiro == p) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    public void exibirOrdemInversa() {
        if (estaVazia()) {
            return;
        }

        NoListaDupla<T> p = primeiro;
        while (p.getProximo() != null) {
            p = p.getProximo();
        }

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> p = primeiro;

        while (p != null) {
            NoListaDupla<T> proximo = p.getProximo();
            p.setProximo(null);
            p.setAnterior(null);
            p = proximo;
        }

        primeiro = null;
    }

    public int obterComprimento() {
        NoListaDupla<T> p = primeiro;
        int contador = 0;

        while (p != null) {
            contador++;
            p = p.getProximo();
        }
        return contador;
    }

    public NoListaDupla<T> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException("Índice inválido: " + idx);
        }

        NoListaDupla<T> p = primeiro;
        int posicaoAtual = 0;

        while (p != null) {
            if (posicaoAtual == idx) {
                return p;
            }
            p = p.getProximo();
            posicaoAtual++;
        }

        throw new IndexOutOfBoundsException("Índice inválido: " + idx);
    }

    public String toString() {
        String resultado = "";

        NoListaDupla<T> p = primeiro;
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