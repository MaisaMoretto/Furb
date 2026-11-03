package OrdenacaoBolhaQuicksort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrdenacaoTeste {

    @Test
    public void ordenacaoBolha(){
        Integer[] vetor = {70, 2, 88, 15, 90, 30};
        OrdenacaoBolha<Integer> ordenacao = new OrdenacaoBolha<>();
        ordenacao.setInfo(vetor);
        ordenacao.ordenar();
        assertArrayEquals(new Integer[]{2, 15, 30, 70, 88, 90}, ordenacao.getInfo());
    }

    @Test
    public void ordenacaoBolhaOtimizado(){
        Integer[] vetor = {70, 2, 88, 15, 90, 30};
        OrdenacaoBolhaOtimizada<Integer> ordenacao = new OrdenacaoBolhaOtimizada<>();
        ordenacao.setInfo(vetor);
        ordenacao.ordenar();
        assertArrayEquals(new Integer[]{2, 15, 30, 70, 88, 90}, ordenacao.getInfo());
    }

    @Test
    public void ordenacaoQuicksort(){
        Integer[] vetor = {70, 2, 88, 15, 90, 30};
        OrdenacaoQuickSort<Integer> ordenacao = new OrdenacaoQuickSort<>();
        ordenacao.setInfo(vetor);
        ordenacao.ordenar();
        assertArrayEquals(new Integer[]{2, 15, 30, 70, 88, 90}, ordenacao.getInfo());
    }
}