package poo.trabalhoFinal.Usabilidade;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import poo.trabalhoFinal.Usabilidade.ControleFinanceiro;
import poo.trabalhoFinal.Usabilidade.Receita;
import poo.trabalhoFinal.Usabilidade.Despesa;
import poo.trabalhoFinal.Usabilidade.CategoriaReceita;
import poo.trabalhoFinal.Usabilidade.CategoriaDespesa;
import poo.trabalhoFinal.Usabilidade.Tipo;

public class LancamentoRepository {

    private static final String ARQUIVO = "lancamentos.csv";

    /**
     * Método para adicionar uma nova linha no arquivo CSV. Através do método,
     * verifica se o arquivo já existe com "f.exists()". Se não existir, cria e
     * adiciona o cabeçalho: Utiliza "FileOutputStream(ARQUIVO,true)" para que
     * novas informações sejam adicionadas ao final do conteúdo já existente, em
     * vez de sobrescrever o arquivo. Usa "OutputStreamWriter" com "UTF-8" para
     * garantir que acentos e caracteres especiais sejam salvos corretamente. O
     * "try-with-resources" fecha o arquivo automaticamente ao terminar, mesmo
     * se ocorrer um erro.
     *
     * @param tipo
     * @param descricao
     * @param valor
     * @param data
     * @param categoria
     */
    public void salvar(String tipo, String descricao, double valor, String data, String categoria) {
        File f = new File(ARQUIVO);
        boolean arquivoNovo = !f.exists();

        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(ARQUIVO, true), "UTF-8"); PrintWriter pw = new PrintWriter(osw)) {

            if (arquivoNovo) {
                pw.println("TIPO;DESCRIÇÃO;VALOR;DATA;CATEGORIA");
            }
            pw.println(tipo + ";" + descricao + ";" + valor + ";" + data + ";" + categoria);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lê o arquivo CSV linha por linha e retorna uma lista de arrays de texto,
     * onde cada array corresponde a uma linha do arquivo.
     *
     * Detalhes: Pula a primeira linha (o cabeçalho) com a variável primeiraLinha. 
     * Divide cada linha nos campos usando .split(";"), que retorna um array de String. 
     * Se o arquivo não existir, retorna uma lista vazia.
     *
     * @return
     */
    public ArrayList<String[]> listarTodos() {
        ArrayList<String[]> lista = new ArrayList<>();
        File f = new File(ARQUIVO);
        if (!f.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"))) {
            String linha;
            boolean primeiraLinha = true;
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                lista.add(linha.split(";"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Lê todos os dados do CSV e constrói um objeto ControleFinanceiro com
     * todos os lançamentos já instanciados.
     * 
     * Funcionamento:
     * 1) Chama listarTodos() para obter as linhas brutas. 
     * 2) Para cada linha, extrai os campos (tipo, descrição, valor, data, categoria).
     * 3) Converte a data de String para LocalDate usando "DateTimeFormatter.ofPattern("dd/MM/yyyy")". 
     * 4) Converte a categoria de String para o enum correspondente usando .valueOf(). 
     * 5) Cria o objeto Receita ou Despesa e o adiciona ao controle.
     * @return 
     */
    public ControleFinanceiro carregarParaControle() {
        ControleFinanceiro controle = new ControleFinanceiro();
        ArrayList<String[]> lista = listarTodos();

        for (String[] campos : lista) {
            String tipo = campos[0];
            String descricao = campos[1];
            double valor = Double.parseDouble(campos[2]);
            LocalDate data = LocalDate.parse(campos[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String categoria = campos[4];

            if (tipo.equals("RECEITA")) {
                CategoriaReceita cat = CategoriaReceita.valueOf(categoria); // "SALARIO" → enum
                controle.adicionarReceita(new Receita(descricao, valor, data, cat));
            } else {
                CategoriaDespesa cat = CategoriaDespesa.valueOf(categoria); // "ALIMENTACAO" → enum
                controle.adicionarDespesa(new Despesa(descricao, valor, data, cat));
            }
        }
        return controle;
    }
}
