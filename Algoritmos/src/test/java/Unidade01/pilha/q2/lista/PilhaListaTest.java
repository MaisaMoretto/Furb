package Unidade01.pilha.q2.lista;

import org.junit.jupiter.api.Test;
import pilha.q2.lista.PilhaLista;

import static org.junit.jupiter.api.Assertions.*;

class PilhaListaTest {

    @Test
    public void estaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void naoEstaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    @Test
    void empilhaDesempilha() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());
        assertTrue(pilha.estaVazia());
    }

    @Test
    void conferirPeek() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek());
        assertEquals(30, pilha.pop());
    }

    @Test
    void conferirLiberar() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();

        assertTrue(pilha.estaVazia());
    }
}
