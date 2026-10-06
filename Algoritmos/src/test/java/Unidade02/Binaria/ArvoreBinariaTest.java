package Unidade02.Binaria;

import Binaria.ArvoreBinaria;
import Binaria.NoArvore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArvoreBinariaTest {

    private ArvoreBinaria<Integer> arvore;

    @BeforeEach
    void criarArvoreDoPlano() {
        NoArvore<Integer> no4 = new NoArvore<>(4);
        NoArvore<Integer> no2 = new NoArvore<>(2, null, no4);
        NoArvore<Integer> no5 = new NoArvore<>(5);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no3 = new NoArvore<>(3, no5, no6);
        NoArvore<Integer> no1 = new NoArvore<>(1, no2, no3);

        arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);
    }

    @Test
    public void estaVazia(){
        ArvoreBinaria<Integer> vazia = new ArvoreBinaria<>();
        assertTrue(vazia.estaVazia());
    }

    @Test
    public void naoEstaVazia(){
        ArvoreBinaria<Integer> novaArvore = new ArvoreBinaria<>();
        novaArvore.setRaiz(new NoArvore<>(5));
        assertFalse(novaArvore.estaVazia());
    }

    @Test
    public void tpStringOrdem(){
        assertEquals("<1<2<><4<><>>><3<5<><>><6<><>>>>", arvore.toString());
    }

    @Test
    public void pertenceRaiz(){
        assertTrue(arvore.pertence(1));
    }

    @Test
    public void pertenceInterno(){
        assertTrue(arvore.pertence(3));
    }

    @Test
    public void pertenceFolha(){
        assertTrue(arvore.pertence(6));
    }

    @Test
    public void naoPertence(){
        assertFalse(arvore.pertence(10));
    }

    @Test
    public void contarNos(){
        assertEquals(6, arvore.contarNos());
    }

}