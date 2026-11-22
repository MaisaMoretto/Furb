package BuscasArvoreBinaria;

public class BuscaArvoreBinaria<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    @Override
    public NoArvore<T> buscar(T info) {
        NoArvore<T> p = getRaiz();

        while ((p != null) && (p.getInfo() != info)) {
            if (info.compareTo(p.getInfo()) < 0) {
                p = p.getEsq();
            }

            if (info.compareTo(p.getInfo()) > 0) {
                p = p.getDir();
            }
        }
        return p;
    }

    public void inserir(T info) {
        NoArvore<T> novo = new NoArvore<T>(info);

        if (getRaiz() == null) {
            setRaiz(novo);
        } else {
            NoArvore<T> p = getRaiz();

            while (true) {
                NoArvore<T> pai = p;

                if (info.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsq();

                    if (p == null) {
                        pai.setEsq(novo);
                        return;
                    }
                } else {
                    p = pai.getDir();
                    if (p == null) {
                        pai.setDir(novo);
                        return;
                    }
                }
            }
        }
    }


    public void retirar(T info) {
        NoArvore<T> p = getRaiz();
        NoArvore<T> pai = null;
        boolean filhoEsquerda = false;

        // localizar o nó a ser removido
        while ((p != null) && (!p.getInfo().equals(info))) {
            pai = p;
            if (info.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsq();
            } else {
                filhoEsquerda = false;
                p = p.getDir();
            }
        }

        if (p != null) {
            if ((p.getEsq() == null) && (p.getDir() == null)) {
                //Caso 1
                if (p == getRaiz()) {
                    setRaiz(null);
                } else if (filhoEsquerda) {
                    pai.setEsq(null);
                } else {
                    pai.setDir(null);
                }
            } else {
                //Caso 2
                if (p.getDir() == null) {
                    if (p == getRaiz()) {
                        setRaiz(p.getEsq());
                    } else if (filhoEsquerda) {
                        pai.setEsq(p.getEsq());
                    } else {
                        pai.setDir(p.getEsq());
                    }
                } else {
                    if (p.getEsq() == null) {
                        if (p == getRaiz()) {
                            setRaiz(p.getDir());
                        } else if (filhoEsquerda) {
                            pai.setEsq(p.getDir());
                        } else {
                            pai.setDir(p.getDir());
                        }
                    } else {

                        //Caso 3
                        NoArvore sucessor = extrairSucessor(p);
                        if (p == getRaiz()){
                            setRaiz(sucessor);
                        } else if (filhoEsquerda){
                            pai.setEsq(sucessor);
                        } else {
                            pai.setDir(sucessor);
                        }
                        sucessor.setEsq(p.getEsq());
                    }
                }
            }
        }
    }

    private NoArvore<T> extrairSucessor(NoArvore<T> p){
        NoArvore<T> atual = p.getDir();
        NoArvore<T> paiSucessor = p;
        NoArvore<T> sucessor = p;

        while (atual != null){
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        if (sucessor != p.getDir()){
            paiSucessor.setEsq(sucessor.getDir());
            sucessor.setDir(p.getDir());
        }

        return sucessor;
    }
}
