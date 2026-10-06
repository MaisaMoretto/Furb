package Variavel;

import java.util.Objects;

public class ArvoreVariavel<T> {
    private NoArvore<T> raiz;

    public ArvoreVariavel() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() { return raiz; }
    public void setRaiz(NoArvore<T> raiz) { this.raiz = raiz; }

    @Override
    public String toString() {
        if (raiz == null) {
            return "";
        }
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String resultado = "<" + no.getInfo();
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            resultado += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        return resultado + ">";
    }

    public boolean pertence(T info) {
        if (raiz == null) {
            return false;
        }
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (Objects.equals(no.getInfo(), info)) {
            return true;
        }
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            if (pertence(p, info)) {
                return true;
            }
            p = p.getProximo();
        }
        return false;
    }

    public int contarNos() {
        if (raiz == null) {
            return 0;
        }
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        int total = 1;
        NoArvore<T> p = no.getPrimeiro();
        while (p != null) {
            total += contarNos(p);
            p = p.getProximo();
        }
        return total;
    }
}