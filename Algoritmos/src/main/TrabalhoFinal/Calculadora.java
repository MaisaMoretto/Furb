import Fila.Fila;
import Fila.FilaLista;
import Pilha.Pilha;
import Pilha.PilhaLista;

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

            // Se for um espaço, ignora e vai para o próximo caractere
            if (c == ' ') {
                i++;
                continue;
            }

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

    /**
     * O "-" na expressão será de um número negativo apenas se vier no começo da expressão, depois de um operador ou
     * após a abertura de um parênteses
     * @param ultimoProcessado
     * @return
     */
    private boolean sinalEhNegativo(String ultimoProcessado) {
        return ultimoProcessado == null || eOperador(ultimoProcessado) || ultimoProcessado.equals("(");
    }

    // Devolve a posição logo depois do último caractere do número
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
}
