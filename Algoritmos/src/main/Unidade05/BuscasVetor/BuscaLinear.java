package BuscasVetor;

public class BuscaLinear <T extends Comparable<T>> extends BuscaAbstract<T> {

    public int buscar(T valor){
        T[] info = getInfo();
        int n = info.length;

        for (int i = 0; i < n - 1; i++){
            if (info[i].compareTo(valor) == 0){
                return i;
            }
        }
        return -1;
    }
}
