package Unidade01.lista.encadeada.exe01;

import lista.encadeada.exe01.ListaSimplesmenteEncadeada;
import lista.encadeada.exe01.NoListaSimplesmente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimplesmenteEncadeadaTest {

    //Caso 1
    @Test
    public void vazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        assertTrue(lista.estaVazia());
    }

    //Caso 2
    @Test
    public void naoVazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    //Caso 3
    @Test
    public void inserirNum() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);

        NoListaSimplesmente<Integer> primeiro = lista.getPrimeiro();
        assertNotNull(primeiro);
        assertEquals(5, primeiro.getInfo());
        assertNull(primeiro.getProximo());
    }

    //Caso 4
    @Test
    public void incluirTresNums() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5); //5
        lista.inserir(10);//10, 5
        lista.inserir(15);//15, 10, 5

        NoListaSimplesmente<Integer> no1 = lista.getPrimeiro();
        assertNotNull(no1);
        assertEquals(15, no1.getInfo()); //primeiro da lista, último inserido

        NoListaSimplesmente<Integer> no2 = no1.getProximo();
        assertNotNull(no2);
        assertEquals(10, no2.getInfo());

        NoListaSimplesmente<Integer> no3 = no2.getProximo();
        assertNotNull(no3);
        assertEquals(5, no3.getInfo()); //último da lista, primeiro que foi inserido

        assertNull(no3.getProximo()); //verifica se não há mais nenhum número na lista
    }

    //Caso 5
    @Test
    public void buscarPrimeiraPosicao() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5); //5
        lista.inserir(10);//10, 5
        lista.inserir(15);//15, 10, 5
        lista.inserir(20);//20, 15, 10, 5

        NoListaSimplesmente<Integer> encontrado = lista.buscar(20);
        assertNotNull(encontrado);
        assertEquals(20, encontrado.getInfo());
    }

    //Caso 6
    @Test
    public void buscarNoDadosMeio() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaSimplesmente<Integer> encontrado = lista.buscar(15);
        assertNotNull(encontrado);
        assertEquals(15, encontrado.getInfo());
    }

    //Caso 7
    @Test
    public void buscarDadoInexistente() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaSimplesmente<Integer> encontrado = lista.buscar(50);
        assertNull(encontrado);
    }

    //Caso 8
    @Test
    public void exclusaoPrimeiroElemento() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        assertEquals("15,10,5", lista.toString());
    }

    //Caso 9
    @Test
    public void exclusaoElementoDoMeio() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(15);

        assertEquals("20,10,5", lista.toString());
    }

    //Caso 10
    @Test
    public void obterNoPosicaoZero() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaSimplesmente<Integer> no = lista.obterNo(0);
        assertNotNull(no);
        assertEquals(20, no.getInfo());
    }

    //Caso 11
    @Test
    public void obterNoUltimaPosicao() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaSimplesmente<Integer> no = lista.obterNo(3);
        assertNotNull(no);
        assertEquals(5, no.getInfo());
    }

    //Caso 12
    @Test
    public void obterNoPosicaoInvalida() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.obterNo(10));
    }

    //Caso 13
    @Test
    public void obterComprimentoListaVazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        assertEquals(0, lista.obterComprimento());
    }

    //Caso 14
    @Test
    public void obterComprimentoListaNaoVazia() {
        ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.obterComprimento());
    }
}
