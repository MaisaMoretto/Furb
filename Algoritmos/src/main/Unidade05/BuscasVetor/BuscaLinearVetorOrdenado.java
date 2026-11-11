package BuscasVetor;

public class BuscaLinearVetorOrdenado <T extends Comparable<T>> extends BuscaAbstract<T> {

    public int buscar(T valor){
        T[] info = getInfo();
        int n = info.length;

        for (int i = 0; i < n - 1; i++){
            if (info[i] == valor){
                return i;
            } else if (valor.compareTo(info[i]) < 0){
                break;
            }
        }
        return -1;
    }
}