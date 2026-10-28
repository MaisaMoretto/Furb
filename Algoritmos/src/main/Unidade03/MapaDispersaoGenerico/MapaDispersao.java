package MapaDispersaoGenerico;

public class MapaDispersao<K, T> {
    private Lista<NoMapa<K,T>>[] info;

    public MapaDispersao(int tamanho){
        info = new Lista[tamanho];
    }

    private int calcularHash(K chave) {
        return (Math.abs(chave.hashCode()) % info.length);
    }

    public void inserir(K chave, T valor) {
        int indice = calcularHash(chave);

        if (info[indice] == null) {
            info[indice] = new Lista<>();
        }

        NoMapa<K, T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setValor(valor);

        info[indice].inserir(noMapa);
    }

    public void remover(K chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<K, T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            info[indice].retirar(noMapa);
        }
    }

    public T buscar(K chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<K, T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<K, T>> no = info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getValor();
            }
        }
        return null;
    }

    public double calcularFatorCarga() {
        int qtdObjetosAdicionados = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] != null) {
                qtdObjetosAdicionados = qtdObjetosAdicionados + info[i].obterComprimento();
            }
        }

        return 1.0 + qtdObjetosAdicionados / info.length;
    }

}