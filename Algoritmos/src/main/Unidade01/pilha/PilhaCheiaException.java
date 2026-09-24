package pilha;

public class PilhaCheiaException extends RuntimeException {
  public PilhaCheiaException() {
    super("A pilha está cheia!");
  }
}