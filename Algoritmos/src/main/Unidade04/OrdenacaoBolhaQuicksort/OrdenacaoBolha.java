package OrdenacaoBolhaQuicksort;

public class OrdenacaoBolha <T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    //vetor com 100 posições, irá passar 99 vezes.

    /**
     * OrdenacaoBolha trabalha com passagens
     * Um vetor com 100 posições, terá 99 passagens até que sua ordenação seja finalizada.
     *
     * Exemplo: 1,2,3,4
     * Qtd de passagens: 3
     *
     * Qtd de posições do vetor - 1
     * Exemplo: Vetor com 100 posições, na 30ª está ordenado -> na 99ª ele para com passagens
     */

    @Override
    public void ordenar() {
        int n = getInfo().length;

        for (int i = n - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (getInfo()[j].compareTo(getInfo()[j+1]) > 0){
                    trocar(j, j+1);
                }
            }
        }
    }
}
