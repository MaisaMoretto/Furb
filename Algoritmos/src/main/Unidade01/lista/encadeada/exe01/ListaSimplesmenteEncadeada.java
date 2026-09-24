package lista.encadeada.exe01;

public class ListaSimplesmenteEncadeada<T> {
    private NoListaSimplesmente<T> primeiro;

    public ListaSimplesmenteEncadeada() {
        this.primeiro = null;
    }

    public NoListaSimplesmente<T> getPrimeiro() { //método getter da classe NoLista
        return primeiro; // retorna a referência do primeiro nó (ou null se vazia)
    }

    public void inserir(T valor) {
        NoListaSimplesmente<T> novo = new NoListaSimplesmente<>(valor); //cria um nó novo, ainda vazio
        novo.setProximo(primeiro); //o "próximo" do novo nó passa a ser quem era o primeiro até agora
        this.primeiro = novo; //agora o novo nó passa a ser o primeiro da lista
    }

    public boolean estaVazia() {
        if (primeiro == null) { //se não há nó nenhum encadeado...
            return true;        //... está vazia
        } else {
            return false;       //se não, tem um ou mais nós
        }
    }

    /**
     * p serve como um "ponteiro" que vai andar pela lista, começando no primeiro nó.
     * Enquanto ele não chegar ao final da lista (linha 40), executa:
     * -Se o conteúdo do nó atual (onde o p está) for igual ao valor buscado, retorna o nó.
     * -Caso contrário, se não encontrar, vai avançando para o próximo nó.
     * Quando chegar ao final do while, ou seja, quando o p for null, retorna null (percorreu tudo e não encontrou o valor)
     *
     * @param valor
     * @return
     */
    public NoListaSimplesmente<T> buscar(T valor) {
        NoListaSimplesmente<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    /**
     * Percorre a lista guardando o nó anterior (anterior) enquanto anda com p.
     * Se achar o valor, "religa" a lista pulando o nó removido —
     * tratando à parte o caso do nó ser o primeiro do caso geral. Se não achar, não faz nada.
     *
     * @param valor
     */
    public void retirar(T valor) {
        NoListaSimplesmente<T> anterior = null;
        NoListaSimplesmente<T> p = primeiro;

        while ((p != null) && (!p.getInfo().equals(valor))) { //percorre enquanto não acabar a lista e não achar o valor
            anterior = p; //guarda quem era o "atual" (no caso, o valor em p) como sendo o "anterior"
            p = p.getProximo(); //avança p para o próximo nó
        }

        if (p != null) { //se p não é null, significa que achou um nó com o valor procurado
            if (p == primeiro) { //caso especial: o nó a remover é o primeiro da lista
                this.primeiro = p.getProximo(); //"primeiro" passa a apontar para o nó que vinha logo depois do removido
            } else {
                anterior.setProximo(p.getProximo()); //caso geral: o "anterior" pula o nó removido e aponta pro próximo dele
            }
        }
    }

    public int obterComprimento() {
        NoListaSimplesmente<T> p = primeiro;
        int contador = 0;

        while (p != null) {
            contador = contador + 1;
            p = p.getProximo();
        }
        return contador;
    }

    public NoListaSimplesmente<T> obterNo(int idx) {
        if (idx < 0) { //usuário fornce o incíce, compara se é menor que zero
            throw new IndexOutOfBoundsException("Índice inválido: " + idx); //se sim, retorna IndexOutOfBoundsException
        }

        //se não, continua:
        NoListaSimplesmente<T> p = primeiro;
        int posicaoAtual = 0;

        while (p != null) {
            if (posicaoAtual == idx) {
                return p;
            }
            p = p.getProximo();
            posicaoAtual = posicaoAtual + 1;
        }
        throw new IndexOutOfBoundsException("Índice inválido: " + idx);
    }

    public String toString() {
        String resultado = "";

        NoListaSimplesmente<T> p = primeiro;
        while (p != null) {
            resultado += p.getInfo();

            if (p.getProximo() != null) {
                resultado += ",";
            }
            p = p.getProximo();
        }
        return resultado;
    }
}
