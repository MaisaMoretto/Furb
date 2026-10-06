package Unidade02.Variavel;

import Variavel.ArvoreVariavel;
import Variavel.NoArvore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArvoreVariavelTest {

    private ArvoreVariavel<Integer> arvore;

    @BeforeEach
    void criarArvore() {
        NoArvore<Integer> no10 = new NoArvore<>(10);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        NoArvore<Integer> no8 = new NoArvore<>(8);
        NoArvore<Integer> no7 = new NoArvore<>(7);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no5 = new NoArvore<>(5);

        NoArvore<Integer> no4 = new NoArvore<>(4);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);

        NoArvore<Integer> no3 = new NoArvore<>(3);
        no3.inserirFilho(no8);

        NoArvore<Integer> no2 = new NoArvore<>(2);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);

        NoArvore<Integer> no1 = new NoArvore<>(1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);

        arvore = new ArvoreVariavel<>();
        arvore.setRaiz(no1);
    }

    @Test
    void representacaoTextual() {
        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    @Test
    void pertenceEncontraValor() {
        assertTrue(arvore.pertence(7));
    }

    @Test
    void pertenceNaoEncontraValor() {
        assertFalse(arvore.pertence(55));
    }

    @Test
    void contarNos() {
        assertEquals(10, arvore.contarNos());
    }
}