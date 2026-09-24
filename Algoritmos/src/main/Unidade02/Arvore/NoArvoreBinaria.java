package Arvore;

public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria esq;
    private NoArvoreBinaria dir;

    public NoArvoreBinaria(T info, NoArvoreBinaria esq, NoArvoreBinaria dir) {
        this.info = info;
        this.esq = esq;
        this.dir = dir;
    }
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public NoArvoreBinaria getEsq() {
        return esq;
    }
    public void setEsq(NoArvoreBinaria esq) {
        this.esq = esq;
    }
    public NoArvoreBinaria getDir() {
        return dir;
    }
    public void setDir(NoArvoreBinaria dir) {
        this.dir = dir;
    }
}
