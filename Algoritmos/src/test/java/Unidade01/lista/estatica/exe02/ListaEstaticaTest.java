package Unidade01.lista.estatica.exe02;

import lista.estatica.exe02.ListaEstatica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEstaticaTest {

    //Caso 1
    @Test
    public void testarInclusaoDeDadosNaLista() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("5,10,15,20", lista.toString());
    }

    //Caso 2
    @Test
    public void testarObtencaoDeTamanhoDaLista() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.getTamanho());
    }

    //Caso 3
    @Test
    public void testarBuscarComElementoExistente() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(2, lista.buscar(15));
    }

    //Caso 4
    @Test
    public void testarBuscarComElementoInexistente() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(-1, lista.buscar(30));
    }

    //Caso 5
    @Test
    public void testarMetodoRetirar() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("5,15,20", lista.toString());
    }

    //Caso 6
    @Test
    public void testarInclusaoQueProvoqueRedimensionamento() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        for (int i = 1; i <= 15; i++) {
            lista.inserir(i);
        }

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());
    }

    //Caso 7
    @Test
    public void testarMetodoObterElemento() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.obterElemento(3));
    }

    //Caso 8
    @Test
    public void testarLancamentoDeExcecaoNoObterElemento() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.obterElemento(5));
    }

    //Caso 9
    @Test
    public void certificarQueLiberarRemoveTodosOsElementos() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertTrue(lista.estaVazia());
    }

    //Caso 10
    @Test
    public void testarInverterComQuantidadeParDeDados() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.inverter();

        assertEquals("20,15,10,5", lista.toString());
    }

    //Caso 11
    @Test
    public void testarInverterComQuantidadeImparDeDados() {
        ListaEstatica<Integer> lista = new ListaEstatica<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);

        lista.inverter();

        assertEquals("25,20,15,10,5", lista.toString());
    }
}
