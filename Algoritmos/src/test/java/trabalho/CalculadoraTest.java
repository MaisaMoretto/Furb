package trabalho;
import org.junit.jupiter.api.Test;
import trabalho.Fila.Fila;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    private double calcular(String expressao) {
        Calculadora c = new Calculadora();
        Fila<String> infixada = c.extrairTermos(expressao);
        Fila<String> posfixada = c.gerarExpressaoPosfixada(infixada);
        return c.calcularExpressaoPosfixada(posfixada);
    }

    private String filaParaTexto(Fila<String> fila) {
        String texto = "";
        while (!fila.estaVazia()) {
            texto = texto + fila.retirar() + " ";
        }
        return texto.trim();
    }

    @Test
    public void extrairTermos(){
        Calculadora c = new Calculadora();
        assertEquals("( 25 + 10 ) / 3,5", filaParaTexto(c.extrairTermos("(25 + 10) / 3,5")));
        assertEquals("15 / 3", filaParaTexto(c.extrairTermos("15/3")));
        assertEquals("15 / 3", filaParaTexto(c.extrairTermos("  15 /3 ")));
        assertEquals("2 * -3", filaParaTexto(c.extrairTermos("2*-3")));
        assertEquals("5 - 3", filaParaTexto(c.extrairTermos("5-3")));
    }

    @Test
    public void gerarPosfixada() {
        Calculadora c = new Calculadora();
        assertEquals("15 5 + 3 /", filaParaTexto(c.gerarExpressaoPosfixada(c.extrairTermos("(15 + 5) / 3"))));
        assertEquals("15 5 3 / +", filaParaTexto(c.gerarExpressaoPosfixada(c.extrairTermos("15 + 5 / 3"))));
        assertEquals("20 5 + 8 2 - / 3 *", filaParaTexto(c.gerarExpressaoPosfixada(c.extrairTermos("(20 + 5) / (8 - 2) * 3"))));
        assertEquals("2 1 10 2 / + *", filaParaTexto(c.gerarExpressaoPosfixada(c.extrairTermos("2 * (1 + (10 / 2))"))));
    }

    @Test
    public void operacoesBasicas() {
        assertEquals(8.0, calcular("5 + 3"), 0.0001);
        assertEquals(2.0, calcular("5 - 3"), 0.0001);
        assertEquals(15.0, calcular("5 * 3"), 0.0001);
        assertEquals(2.5, calcular("5 / 2"), 0.0001);   // divisão decimal
    }

    @Test
    public void precedenciaEParenteses() {
        assertEquals(15.0 + 5.0 / 3.0, calcular("15 + 5 / 3"), 0.0001);
        assertEquals(8.0, calcular("2 * (5 - 1)"), 0.0001);
        assertEquals(12.5, calcular("(20 + 5) / (8 - 2) * 3"), 0.0001);
        assertEquals(12.0, calcular("2 * (1 + (10 / 2))"), 0.0001);
        assertEquals(5.0, calcular("8 - 2 - 1"), 0.0001);  // da esquerda para a direita
    }

    @Test
    public void decimaisENegativos() {
        assertEquals(10.0, calcular("(25 + 10) / 3,5"), 0.0001);
        assertEquals(4.0, calcular("1,5 + 2,5"), 0.0001);
        assertEquals(2.0, calcular("-3 + 5"), 0.0001);
        assertEquals(-6.0, calcular("2 * -3"), 0.0001);
        assertEquals(8.0, calcular("5 - -3"), 0.0001);
        assertEquals(0.0, calcular("(1+2)-3"), 0.0001);
    }

    @Test
    public void espacosVariados() {
        assertEquals(5.0, calcular("15/3"), 0.0001);
        assertEquals(5.0, calcular("15     / 3"), 0.0001);
        assertEquals(5.0, calcular("  15 /3         "), 0.0001);
    }

    @Test
    public void erros() {
        assertThrows(ArithmeticException.class, () -> calcular("5 / 0"));
        assertThrows(IllegalArgumentException.class, () -> calcular("(1 + 2"));
        assertThrows(IllegalArgumentException.class, () -> calcular("1 + 2)"));
        assertThrows(IllegalArgumentException.class, () -> calcular("1 + a"));
        assertThrows(IllegalArgumentException.class, () -> calcular("1 + ((5+7) + 1))"));
    }


    //VALIDAÇÃO COMPLEXA - EXPRESSÕES COMPLEXAS

    @Test
    void aninhamentoProfundo() {
        // 3 -> 9 -> 5 -> 1
        assertEquals(1.0, calcular("((((1 + 2) * 3) - 4) / 5)"), 0.0001);
        // 7-4=3 -> 6/3=2 -> 5-2=3 -> 4*3=12 -> 3+12=15 -> 2*15
        assertEquals(30.0, calcular("2 * (3 + (4 * (5 - (6 / (7 - 4)))))"), 0.0001);
        assertEquals(55.0, calcular("(1 + (2 + (3 + (4 + (5 + (6 + (7 + (8 + (9 + 10)))))))))"), 0.0001);
        assertEquals(7.0, calcular("(((((7)))))"), 0.0001);
        assertEquals(20.0, calcular("(((2 + 3))) * ((4))"), 0.0001);
        assertEquals(42.0, calcular("42"), 0.0001);   // só um número
    }

    // ---------- Precedência e associatividade (esquerda -> direita) ----------
    @Test
    void precedenciaEAssociatividade() {
        assertEquals(28.0, calcular("1 + 2 * 3 - 4 / 2 + 5 * 6 - 7"), 0.0001);
        assertEquals(5.0, calcular("100 / 5 / 2 / 2"), 0.0001);          // (((100/5)/2)/2)
        assertEquals(40.0, calcular("100 - 30 - 20 - 10"), 0.0001);
        assertEquals(4.0, calcular("2 * 3 / 4 * 8 / 3"), 0.0001);        // 6 -> 1,5 -> 12 -> 4
        assertEquals(-1.0, calcular("3 + 4 * 2 / (1 - 5) * 2"), 0.0001);  // 8/-4=-2 -> *2=-4 -> 3-4
        assertEquals(55.0, calcular("1+2+3+4+5+6+7+8+9+10"), 0.0001);
        assertEquals(-53.0, calcular("1-2-3-4-5-6-7-8-9-10"), 0.0001);    // sem espaços: testa o '-'
        assertEquals(1024.0, calcular("2*2*2*2*2*2*2*2*2*2"), 0.0001);
        assertEquals(1.0, calcular("1024/2/2/2/2/2/2/2/2/2/2"), 0.0001);
    }

    // ---------- Números negativos em todo lugar ----------
    @Test
    void negativos() {
        assertEquals(5.0, calcular("-5 + -3 * -2 - -4"), 0.0001);          // -5 + 6 + 4
        assertEquals(-6.0, calcular("(-2 + 5) * (-3 - -1)"), 0.0001);      // 3 * -2
        assertEquals(10.0, calcular("2 * (-3 + (-4 * -2))"), 0.0001);      // 2 * (-3 + 8)
        assertEquals(3.0, calcular("-1,5 * -2"), 0.0001);
        assertEquals(-7.0, calcular("-7"), 0.0001);
        // (10-14) * -1 = 4  e  100 / (2*5) = 10
        assertEquals(14.0, calcular("(10 - 2 * (3 + 4)) * -1 + (100 / (2 * (3 + 2)))"), 0.0001);
    }

    // ---------- Decimais ----------
    @Test
    void decimais() {
        assertEquals(24.0, calcular("(1,5 + 2,5) * (3,5 - 0,5) / 0,5"), 0.0001);   // 4 * 3 / 0,5
        assertEquals(3.0, calcular("10 / 4 + 0,25 * 2"), 0.0001);
        assertEquals(0.875, calcular("0,5 + 0,25 + 0,125"), 0.0001);
        assertEquals(2.5, calcular("(-1,5 + 4) * (2 - -0,5) / (0,5 * 5)"), 0.0001); // 2,5 * 2,5 / 2,5
        assertEquals(3.5, calcular("7 / 2"), 0.0001);
        assertEquals(7.0, calcular("7 / 2 * 2"), 0.0001);
    }

    // ---------- Expressões grandes ----------
    @Test
    void expressoesGrandes() {
        // (40 - 4) * 17 / 5 = 612 / 5
        assertEquals(122.4, calcular("((15 + 5) * (8 - 2) / 3 - 4) * (2 + 3 * (6 - 1)) / (7 - 2)"), 0.0001);
        // (45 - 75) / 5
        assertEquals(-6.0, calcular("((2 + 3) * (4 + 5) - (6 - 1) * (7 + 8)) / ((9 - 4) * 2 - 5)"), 0.0001);
        assertEquals(9999800002.0, calcular("99999 * 99999 + 1"), 0.0001);
        assertEquals(1000000000000.0, calcular("1000000 * 1000000"), 0.0001);
    }

    // ---------- Espaços ----------
    @Test
    void espacosExtremos() {
        assertEquals(20.0, calcular("   (  2   +   3  )   *   4   "), 0.0001);
        assertEquals(5.0, calcular("(2+3)*(4-1)/(6-3)"), 0.0001);
    }

    // ---------- Erros no limite ----------
    @Test
    void errosNoLimite() {
        assertThrows(ArithmeticException.class, () -> calcular("5 / (3 - 3)"));
        assertThrows(IllegalArgumentException.class, () -> calcular("((1 + 2)"));
        assertThrows(IllegalArgumentException.class, () -> calcular("(1 + 2))"));
        assertThrows(IllegalArgumentException.class, () -> calcular("1 +"));
        assertThrows(IllegalArgumentException.class, () -> calcular("2 3"));
        assertThrows(IllegalArgumentException.class, () -> calcular("()"));
    }
}