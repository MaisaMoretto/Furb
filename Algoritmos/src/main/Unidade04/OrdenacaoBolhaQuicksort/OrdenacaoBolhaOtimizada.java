package OrdenacaoBolhaQuicksort;

public class OrdenacaoBolhaOtimizada <T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    /**
     * OrdenacaoBolhaOtimizada reconhece se o vetor já está ordenado.
     * Valida se em uma passagem houve troca. Se constatar que não houve troca, finaliza a execução.
     *
     * Vetor: 1,2,4,3
     * Passagem 1: 1,2,3,4 - Houve troca: true
     * Passagem 2: 1,2,3,4 - Houve troca: false
     * Finaliza a execução
     *
     * Passagens com a última troca + 1
     * Exemplo: na 30ª está ordenado -> 31ª ele para com passagens
     */

    @Override
    public void ordenar() {
        int n = getInfo().length;
        boolean trocou;

        for (int i = n - 1; i > 0; i--) {
            trocou = false;

            for (int j = 0; j < i; j++) {
                if (getInfo()[j].compareTo(getInfo()[j + 1]) > 0) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }
    }
}
