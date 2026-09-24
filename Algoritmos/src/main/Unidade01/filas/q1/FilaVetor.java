package filas.q1;

import filas.Fila;
import filas.FilaCheiaException;
import filas.FilaVaziaException;

public class FilaVetor<T> implements Fila<T> {
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T v) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }

        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = v;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();

        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;

        return valor;
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.limite);

        for (int i = 0; i < this.tamanho; i++) {
            int posicao = (this.inicio + i) % this.limite;
            f3.inserir((T) this.info[posicao]);
        }

        for (int i = 0; i < f2.tamanho; i++) {
            int posicao = (f2.inicio + i) % f2.limite;
            f3.inserir((T) f2.info[posicao]);
        }

        return f3;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = inicio; i < inicio+tamanho; i++) {
            if (i != inicio){
                resultado += ",";
            }
            resultado = resultado + info[i % limite];
        }
        return resultado;
    }

    public int getLimite() {
        return limite;
    }
}