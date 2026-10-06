package Binaria;

public class ArvoreBinaria<T> {
    private NoArvore<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia(){
        return raiz == null;
    }

    public boolean pertence(T info){
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info){
        if (no == null){
            return false;
        } else {
            return (no.getInfo().equals(info))
                    || pertence(no.getEsq(), info)
                    || pertence(no.getDir(), info);
        }
    }

    public String toString(){
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvore<T> no){
        if (no == null){
            return "<>";
        }
        return "<" + no.getInfo() + arvorePre(no.getEsq()) + arvorePre(no.getDir()) + ">";
    }

    public int contarNos(){
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsq()) + contarNos(no.getDir());
    }
}
