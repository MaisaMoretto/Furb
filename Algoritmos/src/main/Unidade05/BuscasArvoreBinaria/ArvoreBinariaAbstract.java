package BuscasArvoreBinaria;

public abstract class ArvoreBinariaAbstract<T> {
    private NoArvore<T> raiz;

    public ArvoreBinariaAbstract(){
        raiz = null;
    }
    public NoArvore<T> getRaiz() {
        return raiz;
    }
    protected void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia(){
        return raiz == null;
    }

    public boolean pertence(T info){
        return buscar(info) != null;
    }

    public abstract NoArvore<T> buscar(T info);

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
