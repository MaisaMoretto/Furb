package q1;

import java.util.Objects;

public class NoMapa<T> {
    private int chave;
    private T info;

    public NoMapa() {
    }
    public NoMapa(int chave, T info) {
        this.chave = chave;
        this.info = info;
    }
    public int getChave() {
        return chave;
    }
    public void setChave(int chave) {
        this.chave = chave;
    }
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NoMapa<?> noMapa = (NoMapa<?>) o;
        return chave == noMapa.chave;
    }
}
