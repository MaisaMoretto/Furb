package pilha.q5.validacao.delimitadores;

import pilha.q1.vetor.PilhaVetor;

public class ValidadorDelimitadores {
    public boolean validar(String expressao) {
        PilhaVetor<Character> pilha = new PilhaVetor<>(expressao.length());

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pilha.estaVazia()) {
                    return false;
                }
                char aberto = pilha.pop();
                if (!correspondem(aberto, c)) {
                    return false;
                }
            }
        }

        return pilha.estaVazia();
    }

    private boolean correspondem(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
                (abertura == '[' && fechamento == ']') ||
                (abertura == '{' && fechamento == '}');
    }
}
