package filas;

public class FilaCheiaException extends RuntimeException {
  public FilaCheiaException() {
    super("A pilha está cheia!");
  }
}