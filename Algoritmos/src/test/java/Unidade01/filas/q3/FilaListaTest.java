package Unidade01.filas.q3;

import filas.FilaVaziaException;
import filas.q3.FilaLista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaListaTest {

    @Test
    public void filaVazia() {
        FilaLista<Integer> fila = new FilaLista<>();
        assertTrue(fila.estaVazia());
    }

    @Test
    public void filaComElemento() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    public void enfileirarDesenfileirar() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void retirarDeFilaVazia() {
        FilaLista<Integer> fila = new FilaLista<>();

        assertThrows(FilaVaziaException.class, () -> fila.retirar());
    }

    @Test
    public void peekRetornaInicio() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.peek());
        assertEquals(10, fila.retirar());
    }

    @Test
    public void liberar() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();

        assertTrue(fila.estaVazia());
    }
}
