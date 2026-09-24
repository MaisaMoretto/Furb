package pilha.q2.lista;

import Unidade01.pilha.Pilha;
import Unidade01.pilha.PilhaVaziaException;

public class PilhaLista<T> implements Pilha<T> {
    private ListaSimplesmenteEncadeada<T> lista;

    public PilhaLista() {
        this.lista = new ListaSimplesmenteEncadeada<>();
    }
    public ListaSimplesmenteEncadeada<T> getLista() {
        return lista;
    }
    public void setLista(ListaSimplesmenteEncadeada<T> lista) {
        this.lista = lista;
    }

    @Override
    public void push(T v) {
        lista.inserir(v);
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T pop() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }

    public String toString() {
        return lista.toString();
    }
}