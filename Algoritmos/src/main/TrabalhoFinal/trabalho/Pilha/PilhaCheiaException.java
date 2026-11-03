package trabalho.Pilha;

public class PilhaCheiaException extends RuntimeException {
  public PilhaCheiaException() {
    super("A pilha está cheia!");
  }
}