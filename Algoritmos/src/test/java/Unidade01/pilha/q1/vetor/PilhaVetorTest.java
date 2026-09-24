package Unidade01.pilha.q1.vetor;

import pilha.PilhaCheiaException;
import pilha.PilhaVaziaException;
import org.junit.jupiter.api.Test;
import pilha.q1.vetor.PilhaVetor;

import static org.junit.jupiter.api.Assertions.*;

class PilhaVetorTest {

    @Test
    public void estaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void naoEstaVazia() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(1);
        assertFalse(pilha.estaVazia());
    }

    @Test
    public void empilhaDesempilha() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void conferirPilhaCheiaException() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertThrows(PilhaCheiaException.class, () -> pilha.push(40));
    }

    @Test
    public void conferirPilhaVaziaException() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        assertThrows(PilhaVaziaException.class, () -> pilha.pop());
    }

    @Test
    public void conferirPeek() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek());
        assertEquals(30, pilha.pop());
    }

    @Test
    public void conferirLiberar() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void conferirConcatenar() {
        PilhaVetor<Integer> pilha1 = new PilhaVetor<>(5);
        pilha1.push(10);
        pilha1.push(20);
        pilha1.push(30);

        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(5);
        pilha2.push(40);
        pilha2.push(50);

        pilha1.concatenar(pilha2);
        assertEquals("50,40,30,20,10", pilha1.toString());
    }
}
