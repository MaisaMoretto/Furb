package lista.estatica.exe02;

public class ListaEstatica<T> {

    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new Object[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Object[] novo = new Object[info.length + 10];
        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }
        info = novo;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(info[i] + " ");
        }
        System.out.println();
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) {
        int posicao = buscar(valor);
        if (posicao > -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
            info[tamanho] = null;
        }
    }

    public void liberar() {
        info = new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int posicao) { //Ajustado
        if (posicao >= 0 && (posicao < tamanho)){
            return (T) info[posicao];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < tamanho; i++) { //Ajustado
            if (i >= 0) {
                resultado += info[i];
                resultado += ",";
            }
        }
        return resultado;
    }

    public void inverter(){ //Ajustado
        int esquerda = 0;
        int direita = tamanho - 1;

        Object backup;

        int qtdTrocas = tamanho/2;
        while (qtdTrocas > 0){
            backup = info[esquerda];
            info[esquerda] = info[direita];
            info[direita] = backup;

            esquerda++;
            direita--;

            qtdTrocas--;

        }
    }
}
