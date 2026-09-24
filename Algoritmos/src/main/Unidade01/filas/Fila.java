package filas;

public interface Fila<T> {
    void inserir (T v);
    boolean estaVazia();
    T peek();
    T retirar();
    void liberar();
}
