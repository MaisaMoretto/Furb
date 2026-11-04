package trabalho;

import trabalho.Fila.Fila;
import trabalho.Fila.FilaLista;
import trabalho.Pilha.Pilha;
import trabalho.Pilha.PilhaLista;

public class Calculadora {

    /**
     * Etapa B
     * Extração de termos
     * Objetivo: extrair caracteres: números, operadores e parênteses.
     * Os espaços devem ser descartados.
     * Resultado para (15 + 5) / 4: fila A = (15+5)/4, com 7 termos.
     * @param expressao
     * @return
     */
    public Fila<String> extrairTermos(String expressao) {

        //Rejeita expressões nulas ou vazias
        if (expressao == null || expressao.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe a expressão");
        }

        // "termosExtraidos" é a fila A, que será devolvida ao final para prosseguir com as outras etapas
        Fila<String> termosExtraidos = new FilaLista<String>();

        String ultimoProcessado = null;
        int i = 0;

        while (i < expressao.length()) {
            char c = expressao.charAt(i);

            // Se for um espaço, ignora e vai para o próximo caractere
            if (c == ' ') {
                i++;
            } else {

            String termo;

            // Valida o número negativo
            if (eDigito(c) || (c == '-' && sinalEhNegativo(ultimoProcessado))) {
                int fim = fimDoNumero(expressao, i + 1);
                termo = expressao.substring(i, fim);
                i = fim;

                //Verifica se é operador ou parênteses
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                termo = String.valueOf(c);
                i++;

                // Se não se enquadrar nos if's anteriores, a expressão é inválida
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
    public Fila<String> gerarExpressaoPosfixada(Fila<String> exprInfixada) {
        Pilha<String> pilhaB = new PilhaLista<String>();   // pilha responsável por guardar os operadores e parênteses
        Fila<String> filaC = new FilaLista<String>();      // resultado (pós-fixada)

        while (!exprInfixada.estaVazia()) {
            String termo = exprInfixada.retirar();

            if (eOperador(termo)) {
                // tira da pilha os operadores com precedência igual ou maior
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
                // é um operando (número)
                filaC.inserir(termo);
            }
        }

        // enquanto sobrar algo na pilha B, será passado para a fila C
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
    public double calcularExpressaoPosfixada(Fila<String> expressaoPosfixada){
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
                double a = pilha.pop(); // operando da esquerda
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
