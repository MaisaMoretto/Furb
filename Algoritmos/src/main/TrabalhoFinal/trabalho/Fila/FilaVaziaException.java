package trabalho.Fila;

public class FilaVaziaException extends RuntimeException {
  public FilaVaziaException() {
    super("A pilha está vazia!");
  }
}