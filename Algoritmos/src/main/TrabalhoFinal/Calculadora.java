import Fila.Fila;
import Fila.FilaLista;

public class Calculadora {


    public Fila<String> extrairTermos (String expressao){
        if (expressao == null || expressao.trim().isEmpty()){
            throw new IllegalArgumentException("Informe a expressão");
        }

        Fila<String> termosExtraidos = new FilaLista<String>();
        String ultimoProcessado = null;
        int i = 0;
        int tamanhoExpressao = expressao.length();

        while (i<tamanhoExpressao){
            char c = expressao.charAt(i);

            if (c == ' '){
                i++;
            } else {
                String termoCompleto;
                if (digito(c)){

                }
            }
        }
    }

    private boolean digito(char c){
        return (c >= 0 && c <=9);
    }

    /**
     *
     * @param s -> representa a expressão inteira
     * @param inicio -> é a posição atual em que estamos dentro da expressao, o indice atual
     * @return
     */
    private int fimDoNumero(String s, int inicio) {
        int j = inicio;
        int qtdVirgulas = 0;

        /**
         * ENQUANTO: estiver dentro da string e o caractere da posição j for um dígito ou uma vírgula, continue no laço
         */
        while (j < s.length() && (digito(s.charAt(j)) || s.charAt(j) == ',')) {

            /**
             * Nessa validação, se encontrar vírgula, incrementa na variavel qtdVirgulas.
             * Um número pode ter apenas uma única vírgula. Este contador é utilizado mais abaixo para avaliar se
             * um número decimal válido ou não
             */
            if (s.charAt(j) == ',') {
                qtdVirgulas++;
            }
            j++;
        }

        /**
         * Se tiver mais de uma vírgula -> retorna inválido, ou
         * Se encontrou uma vírgula e, após ela, não há nenhum carcater -> retorna inválido
         */
        if (qtdVirgulas > 1 || s.charAt(j - 1) == ',') {
            throw new IllegalArgumentException("Número inválido: '" + s.substring(inicio, j) + "'");
        }

        /**
         * Se passar de todas essas validações, retorna o indice atual,
         * isso é: até qual posição o nº decimal consta.
         */
        return j;
    }
}
