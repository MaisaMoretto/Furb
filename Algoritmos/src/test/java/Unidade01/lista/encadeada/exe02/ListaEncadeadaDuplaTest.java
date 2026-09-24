package Unidade01.lista.encadeada.exe02;

import lista.encadeada.exe02.ListaEncadeadaDupla;
import lista.encadeada.exe02.NoListaDupla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEncadeadaDuplaTest {

    @Test
    public void caso01_IncluirDados() {
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        String resulta = lista.toString();
        assertEquals("20,15,10,5", resulta);
    }

    @Test
    public void caso01_IncluirDados02() {
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        // navegação do primeiro até o último
        NoListaDupla<Integer> no1 = lista.getPrimeiro();
        assertNotNull(no1);
        assertEquals(20, no1.getInfo());

        NoListaDupla<Integer> no2 = no1.getProximo();
        assertNotNull(no2);
        assertEquals(15, no2.getInfo());

        NoListaDupla<Integer> no3 = no2.getProximo();
        assertNotNull(no3);
        assertEquals(10, no3.getInfo());

        NoListaDupla<Integer> no4 = no3.getProximo();
        assertNotNull(no4);
        assertEquals(5, no4.getInfo());

        NoListaDupla<Integer> no5 = no4.getProximo();
        assertNull(no5);

        // navegação do último até o primeiro
        assertEquals(no3, no4.getAnterior());
        assertEquals(no2, no3.getAnterior());
        assertEquals(no1, no2.getAnterior());
        assertNull(no1.getAnterior());
    }

    @Test
    public void caso02_BuscarElementoInicio() {
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> encontrado = lista.buscar(20);
        assertNotNull(encontrado);
        assertEquals(20, encontrado.getInfo());
    }

    @Test
    public void caso03_BuscarElementoMeio() {
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> encontrado = lista.buscar(10);
        assertNotNull(encontrado);
        assertEquals(10, encontrado.getInfo());
    }

    @Test
    public void caso04_RemoverElementoInicio() {
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void caso05_RetirarElementoMeio() {
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("20,15,5", lista.toString());
    }

    @Test
    public void caso06_RetirarElementoFim() {
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(5);

        assertEquals("20,15,10", lista.toString());
    }

    @Test
    public void caso07_LiberarDados() {
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> no5 = lista.buscar(5);
        NoListaDupla<Integer> no10 = lista.buscar(10);
        NoListaDupla<Integer> no15 = lista.buscar(15);
        NoListaDupla<Integer> no20 = lista.buscar(20);

        lista.liberar();

        assertTrue(lista.estaVazia());
        assertNull(lista.getPrimeiro());

        assertNull(no5.getAnterior());
        assertNull(no5.getProximo());
        assertNull(no10.getAnterior());
        assertNull(no10.getProximo());
        assertNull(no15.getAnterior());
        assertNull(no15.getProximo());
        assertNull(no20.getAnterior());
        assertNull(no20.getProximo());
    }
}
