package BuscasArvoreBinaria;

public class ArvoreBinariaBusca<T extends Comparable <T>> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvore<T> buscar(T info) {
        NoArvore<T> p = getRaiz();

        while ((p != null) && (p.getInfo() != info)){
            if (info.compareTo(p.getInfo()) < 0){
                p = p.getEsq();
            }

            if (info.compareTo(p.getInfo()) > 0){
                p = p.getDir();
            }
        }
        return p;
    }

    public void inserir(T info){
        NoArvore<T> novo = new NoArvore<T>(info);


        if (getRaiz() == null){
            setRaiz(novo);
        } else {
            NoArvore<T> p = getRaiz();

            while (true){
                NoArvore<T> pai = p;

                if (info.compareTo(p.getInfo()) < 0){
                    p = pai.getEsq();

                    if (p == null){
                        pai.setEsq(novo);
                        return;
                    }
                } else {
                    p = pai.getDir();
                    if (p == null){
                        pai.setDir(novo);
                        return;
                    }
                }
            }
        }
    }
}
