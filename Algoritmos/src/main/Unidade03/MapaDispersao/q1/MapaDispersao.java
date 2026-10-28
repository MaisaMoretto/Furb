package MapaDispersao.q1;

public class MapaDispersao<T> {
    private Lista<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho){
        info = new Lista[tamanho]; //vetor que possa guardar instancias de listas encadeadas
    }

    private int calcularHash(int chave){
        return (chave % info.length);
    }

    public void inserir(int chave, T dado){
        int indice = calcularHash(chave);

        if (info[indice] == null){
            info[indice] = new Lista<>();
        }

        NoMapa<T> noMapa = new NoMapa<>();
        noMapa.setChave(chave);
        noMapa.setInfo(dado);

        info[indice].inserir(noMapa);
    }

    public void remover(int chave){
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            info[indice].retirar(noMapa);
        }
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);

        if (info[indice] != null) {
            NoMapa<T> noMapa = new NoMapa<>();
            noMapa.setChave(chave);

            NoLista<NoMapa<T>> no = info[indice].buscar(noMapa);
            if (no != null) {
                return no.getInfo().getInfo();
            }
        }
        return null;
    }

    public double calcularFatorCarga(){
        int qtdObjetosAdicionados = 0;

        for (int i = 0; i < info.length; i++){
            if (info[i] != null){
                qtdObjetosAdicionados = qtdObjetosAdicionados+ info[i].obterComprimento();
            }
        }

        return 1.0 + qtdObjetosAdicionados / info.length;
    }
}
