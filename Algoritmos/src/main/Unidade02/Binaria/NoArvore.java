package Binaria;

public class NoArvore<T> {
    private T info;
    private NoArvore esq;
    private NoArvore dir;

    public NoArvore(T info, NoArvore esq, NoArvore dir) {
        this.info = info;
        this.esq = esq;
        this.dir = dir;
    }
    public NoArvore(T info) {
        this(info, null, null);
    }
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public NoArvore getEsq() {
        return esq;
    }
    public void setEsq(NoArvore esq) {
        this.esq = esq;
    }
    public NoArvore getDir() {
        return dir;
    }
    public void setDir(NoArvore dir) {
        this.dir = dir;
    }
}
