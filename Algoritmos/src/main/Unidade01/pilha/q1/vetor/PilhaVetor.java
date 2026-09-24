package pilha.q1.vetor;

import pilha.Pilha;
import pilha.PilhaCheiaException;
import pilha.PilhaVaziaException;

public class PilhaVetor<T> implements Pilha<T> {
    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }
    public Object[] getInfo() {
        return info;
    }
    public void setInfo(Object[] info) {
        this.info = info;
    }
    public int getLimite() {
        return limite;
    }
    public void setLimite(int limite) {
        this.limite = limite;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }


    @Override
    public void push(T v) {
        if (limite == tamanho){
            throw new PilhaCheiaException();
        }
        info[tamanho] = v;
        tamanho++;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return (T) info[tamanho - 1];
    }

    @Override
    public T pop() {
        T valor = peek();
        info[tamanho-1] = null;
        tamanho--;
        return valor;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
    //a opção mais eficiente seria criar um novo vetor

    while (!estaVazia()){
            pop();
        }
    }

    public String toString() {
        String resultado = "";
        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i];
            if (i > 0) {
                resultado += ",";
            }
        }
        return resultado;
    }

    public void concatenar(PilhaVetor<T> p) {
        if (this.tamanho - p.tamanho > this.limite) {
            throw new PilhaCheiaException();
        }
        for (int i = 0; i < p.tamanho; i++) {
            this.push((T) p.info[i]);
        }
    }
}
