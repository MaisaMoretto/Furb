package lista.encadeada.exe01;

public class NoListaSimplesmente<T> {
    private T info;
    private NoListaSimplesmente<T> proximo;

    public NoListaSimplesmente(T info) {
        this.info = info;
        this.proximo = null;
    }

    public NoListaSimplesmente<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaSimplesmente<T> proximo) {
        this.proximo = proximo;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
