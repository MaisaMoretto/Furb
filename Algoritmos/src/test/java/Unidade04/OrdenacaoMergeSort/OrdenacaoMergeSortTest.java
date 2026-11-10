package Unidade04.OrdenacaoMergeSort;

import OrdenacaoMergeSort.OrdenacaoMergeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OrdenacaoMergeSortTest {

    @Test
    public void testarOrdenar() {
        Integer[] vetor = {70, 2, 88, 15, 90, 30};

        OrdenacaoMergeSort<Integer> ordenacao = new OrdenacaoMergeSort<Integer>();
        ordenacao.setInfo(vetor);
        ordenacao.ordenar();

        Integer[] esperado = {2, 15, 30, 70, 88, 90};
        assertArrayEquals(esperado, ordenacao.getInfo());
    }
}