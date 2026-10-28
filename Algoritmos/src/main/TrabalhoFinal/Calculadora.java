import Fila.Fila;
import Fila.FilaLista;

public class Calculadora {

// OBSERVAÇÃO: os números sempre estarão corretos, isso é: não haverá erro na composição numérica.
// Também não haverá omissão de símplos * em multiplicações

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
            }
        }
    }

    private boolean digito(char c){
        return (c >= 0 && c <=9);
    }
}
