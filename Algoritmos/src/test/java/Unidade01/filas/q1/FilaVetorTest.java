package Unidade01.filas.q1;

import filas.FilaCheiaException;
import filas.FilaVaziaException;
import filas.q1.FilaVetor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaVetorTest {

    @Test
    public void filaVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        assertTrue(fila.estaVazia());
    }

    @Test
    public void filaComElemento() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }

    @Test
    public void enfileirarDesenfileirar() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.retirar());
        assertEquals(20, fila.retirar());
        assertEquals(30, fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void inserirEmFilaCheia() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertThrows(FilaCheiaException.class, () -> fila.inserir(40));
    }

    @Test
    public void retirarDeFilaVazia() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        assertThrows(FilaVaziaException.class, () -> fila.retirar());
    }

    @Test
    public void peekRetornaInicio() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(10, fila.peek());
        assertEquals(10, fila.retirar()); //peek não removeu, retirar deve retornar o mesmo valor
    }

    @Test
    public void liberarElementos() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();

        assertTrue(fila.estaVazia());
    }

    @Test
    public void concatenarFilas() {
        FilaVetor<Integer> f1 = new FilaVetor<>(5);
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);

        FilaVetor<Integer> f2 = new FilaVetor<>(3);
        f2.inserir(40);
        f2.inserir(50);

        FilaVetor<Integer> f3 = f1.criarFilaConcatenada(f2);

        assertEquals("10,20,30,40,50", f3.toString());
        assertEquals("10,20,30", f1.toString());
        assertEquals("40,50", f2.toString());
        assertEquals(8, f3.getLimite());
    }
}
