package trabalho;

import trabalho.Fila.Fila;
import trabalho.Fila.FilaLista;
import trabalho.Pilha.Pilha;
import trabalho.Pilha.PilhaLista;

public class Calculadora {

    //Etapa B
    public Fila<String> extrairTermos(String expressao) {

        if (expressao == null || expressao.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe a expressão");
        }

        Fila<String> termosExtraidos = new FilaLista<String>();

        String ultimoProcessado = null;
        int i = 0;

        while (i < expressao.length()) {
            char c = expressao.charAt(i);

            if (c == ' ') {
                i++;
            } else {

            String termo;

            if (eDigito(c) || (c == '-' && sinalEhNegativo(ultimoProcessado))) {
                int fim = fimDoNumero(expressao, i + 1);
                termo = expressao.substring(i, fim);
                i = fim;

            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                termo = "" + c;
                i++;

            } else {
                throw new IllegalArgumentException("Caractere inválido '" + c + "'");
            }

            termosExtraidos.inserir(termo);
            ultimoProcessado = termo;
        }
    }
        return termosExtraidos;
    }

    //Etapa C
    public Fila<String> gerarExprPosfixada(Fila<String> exprInfixada) {
        Pilha<String> pilhaB = new PilhaLista<String>();
        Fila<String> filaC = new FilaLista<String>();

        while (!exprInfixada.estaVazia()) {
            String termo = exprInfixada.retirar();

            if (eOperador(termo)) {
                while (!pilhaB.estaVazia() && eOperador(pilhaB.peek())
                        && precedencia(pilhaB.peek()) >= precedencia(termo)) {
                    filaC.inserir(pilhaB.pop());
                }
                pilhaB.push(termo);

            } else if (termo.equals("(")) {
                pilhaB.push(termo);

            } else if (termo.equals(")")) {
                boolean achouAbertura = false;
                while (!pilhaB.estaVazia() && !achouAbertura) {
                    String topo = pilhaB.pop();
                    if (topo.equals("(")) {
                        achouAbertura = true;
                    } else {
                        filaC.inserir(topo);
                    }
                }
                if (!achouAbertura) {
                    throw new IllegalArgumentException("Parênteses desbalanceados");
                }

            } else {
                filaC.inserir(termo);
            }
        }

        while (!pilhaB.estaVazia()) {
            String topo = pilhaB.pop();
            if (topo.equals("(")) {
                throw new IllegalArgumentException("Parênteses desbalanceados");
            }
            filaC.inserir(topo);
        }

        return filaC;
    }

    private boolean eDigito(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean eOperador(String termo) {
        return termo.equals("+") || termo.equals("-") || termo.equals("*") || termo.equals("/");
    }

    //Etapa D
    public double calcularExprPosfixada(Fila<String> expressaoPosfixada){
        Pilha<Double> pilha = new PilhaLista<Double>();

        while (!expressaoPosfixada.estaVazia()){
            String termo = expressaoPosfixada.retirar();

            if (eOperador(termo)){
                if (pilha.estaVazia()){
                    throw new IllegalArgumentException("Expressão inválida");
                }
                double b = pilha.pop();
                if (pilha.estaVazia()){
                    throw new IllegalArgumentException("Expressão inválida.");
                }
                double a = pilha.pop();
                pilha.push(aplicar(termo.charAt(0), a, b));
            } else {
                pilha.push(Double.parseDouble(termo.replace(',', '.')));
            }
        }
        if (pilha.estaVazia()){
            throw new IllegalArgumentException("Expressão inválida.");
        }
        double resultado = pilha.pop();
        if (!pilha.estaVazia()){
            throw new IllegalArgumentException("Expressão inválida.");
        }
        return resultado;
    }

    /**
     * O "-" na expressão será de um número negativo apenas se vier no começo da expressão, depois de um operador ou
     * após a abertura de um parênteses
     * @param ultimoProcessado
     * @return
     */
    private boolean sinalEhNegativo(String ultimoProcessado) {
        return ultimoProcessado == null || eOperador(ultimoProcessado) || ultimoProcessado.equals("(");
    }

    private int fimDoNumero(String s, int inicio) {
        int j = inicio;
        while (j < s.length() && (eDigito(s.charAt(j)) || s.charAt(j) == ',')) {
            j++;
        }
        return j;
    }

    private int precedencia(String operador) {
        if (operador.equals("*") || operador.equals("/")) {
            return 2;
        }
        return 1;
    }

    private double aplicar(char operador, double a, double b) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Erro: Divisão por zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operador desconhecido: " + operador);
        }
    }
}
