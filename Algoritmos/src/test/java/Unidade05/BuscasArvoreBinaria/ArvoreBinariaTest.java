package Unidade05.BuscasArvoreBinaria;

import BuscasArvoreBinaria.ArvoreBinariaBusca;
import BuscasArvoreBinaria.NoArvore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

class ArvoreBinariaTest {

    @Test
    public void inserir(){
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.inserir(25);
        arvore.inserir(75);
        arvore.inserir(65);
        arvore.inserir(35);
        arvore.inserir(60);

        assertEquals("<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>", arvore.toString());
    }

    @Test
    public void removerFolha(){
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(25);
        arvore.inserir(40);

        //verificar método de remoção na terça
    }

    @Test
    public void removerNoUmFilho(){
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(80);
        arvore.inserir(52);
        arvore.inserir(90);
        arvore.inserir(48);
        arvore.inserir(71);
        arvore.inserir(63);
        arvore.inserir(67);

        //verificar método de remoção na terça - conteúdo n apresentado
    }


    //TESTES DE BUSCA - não solicitado na lista
    private ArvoreBinariaBusca<Integer> arvore;

    @BeforeEach
    public void montarArvore() {
        arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.inserir(25);
        arvore.inserir(75);
        arvore.inserir(65);
        arvore.inserir(35);
        arvore.inserir(60);
    }

    @Test
    public void testarBuscarRaiz() {
        NoArvore<Integer> no = arvore.buscar(50);
        assertEquals(50, arvore.buscar(50).getInfo());
    }

    @Test
    public void testarBuscarArvoreVazia() {
        ArvoreBinariaBusca<Integer> vazia = new ArvoreBinariaBusca<>();
        assertEquals(null, vazia.buscar(50));
    }

    @Test
    public void testarNumInexistente() {
        assertEquals(null, arvore.buscar(1000000));
    }
}