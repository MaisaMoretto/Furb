package Unidade03.q2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import MapaDispersao.q1.MapaDispersao;
import MapaDispersao.q2.Aluno;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    private MapaDispersao<Aluno> mapa;

    @BeforeEach
    void criarMapa(){
        mapa = new MapaDispersao<>(53);
    }

    @Test
    public void inserirBuscarDado(){
        Aluno obj1 = new Aluno(12000,"Jean", LocalDate.of(2000,1,1));
        mapa.inserir(12000,obj1);

        assertEquals(obj1, mapa.buscar(12000));
    }

    @Test
    public void inserirBuscarObjs(){
        Aluno aluno1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno aluno2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno aluno3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno aluno4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(12000, aluno1);
        mapa.inserir(14000, aluno2);
        mapa.inserir(12500, aluno3);
        mapa.inserir(13000, aluno4);

        assertEquals(aluno1, mapa.buscar(12000));
        assertEquals(aluno2, mapa.buscar(14000));
        assertEquals(aluno3, mapa.buscar(12500));
        assertEquals(aluno4, mapa.buscar(13000));
    }

    @Test
    public void inserirBuscarObjsColisao(){
        Aluno aluno1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno aluno2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno aluno3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        Aluno aluno4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(12000, aluno1);
        mapa.inserir(14000, aluno2);
        mapa.inserir(14226, aluno3);
        mapa.inserir(17180, aluno4);

        assertEquals(aluno1, mapa.buscar(12000));
        assertEquals(aluno2, mapa.buscar(14000));
        assertEquals(aluno3, mapa.buscar(14226));
        assertEquals(aluno4, mapa.buscar(17180));
    }
}