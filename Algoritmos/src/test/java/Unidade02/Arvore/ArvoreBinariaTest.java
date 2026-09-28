package Unidade02.Arvore;

import Arvore.ArvoreBinaria;
import Arvore.NoArvoreBinaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArvoreBinariaTest {

    private ArvoreBinaria<Integer> arvore;

    @BeforeEach
    void criarArvoreDoPlano() {
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

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
        novaArvore.setRaiz(new NoArvoreBinaria<>(5));
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