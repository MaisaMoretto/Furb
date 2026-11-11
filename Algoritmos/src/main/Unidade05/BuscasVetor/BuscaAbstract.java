package BuscasVetor;

public abstract class BuscaAbstract<T extends Comparable<T>> {
    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }
}
