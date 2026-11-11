package Unidade05.BuscasVetor;
import BuscasVetor.BuscaBinaria;
import BuscasVetor.BuscaLinear;
import BuscasVetor.BuscaLinearVetorOrdenado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuscasEmVetorTest {

    @Test
    public void localizaEmBuscaLinear(){
        Integer[] vetor = {0,10,20,30,40,50,60,70,80,90,100};
        BuscaLinear<Integer> busca = new BuscaLinear<Integer>();
        busca.setInfo(vetor);

        assertEquals(2, busca.buscar(20));
    }

    @Test
    public void localizaEmBuscaLinearOrdenado(){
        Integer[] vetor = {0,10,20,30,40,50,60,70,80,90,100};
        BuscaLinearVetorOrdenado<Integer> busca = new BuscaLinearVetorOrdenado<>();
        busca.setInfo(vetor);

        assertEquals(4, busca.buscar(40));
    }

    @Test
    public void localizaEmBuscaBinaria(){
        Integer[] vetor = {0,10,20,30,40,50,60,70,80,90,100};
        BuscaBinaria<Integer> busca = new BuscaBinaria<Integer>();
        busca.setInfo(vetor);

        assertEquals(7, busca.buscar(70));
    }

    @Test
    public void naoLocalizaEmBuscaBinaria(){
        Integer[] vetor = {0,10,20,30,40,50,60,70,80,90,100};
        BuscaBinaria<Integer> busca = new BuscaBinaria<Integer>();
        busca.setInfo(vetor);

        assertEquals(-1, busca.buscar(75));
    }
}