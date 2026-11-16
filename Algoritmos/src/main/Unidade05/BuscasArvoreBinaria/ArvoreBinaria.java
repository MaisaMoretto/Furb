package BuscasArvoreBinaria;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    public void setRaiz(NoArvore<T> raiz){
        setRaiz(raiz);
    }

    @Override
    public NoArvore<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    private NoArvore<T> buscar(NoArvore<T> no, T info) {
        if (no == null) {
            return null;
        }
        if (no.getInfo().equals(info)) {
            return no;
        }
        NoArvore<T> achado = buscar(no.getEsq(), info);
        if (achado != null) {
            return achado;
        }
        return buscar(no.getDir(), info);
    }
}
