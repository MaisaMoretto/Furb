package Usabilidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ControleFinanceiro {

    private ArrayList<Lancamento> lancamentos = new ArrayList<Lancamento>();

    /**
     * Lista que armazena todos os lançamentos (receitas e despesas juntos, pois
     * ambos são lancamentos).
     */
    public ControleFinanceiro() {
        this.lancamentos = new ArrayList<>();
    }

    public ArrayList<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    /**
     * Adiciona uma receita à lista de lançamentos.
     *
     * @param receita
     */
    public void adicionarReceita(Receita receita) {
        lancamentos.add(receita);
    }

    /**
     * Adiciona uma despe à lista de lançamentos.
     *
     * @param despesa
     */
    public void adicionarDespesa(Despesa despesa) {
        lancamentos.add(despesa);
    }

    /**
     * Percorre todos os lançamentos e soma receitas, subtraindo despesas.
     *
     * @return saldo
     */
    public double saldoTotal() {
        double saldo = 0.0;
        for (Lancamento lancamento : lancamentos) {
            if (lancamento.getTipo() == Tipo.RECEITA) {
                saldo += lancamento.getValor();
            } else {
                saldo -= lancamento.getValor();
            }
        }
        return saldo;
    }

    /**
     * Lista todas as receitas
     *
     * @return
     */
    public ArrayList<Receita> receitas() {
        ArrayList<Receita> resultado = new ArrayList<Receita>();
        for (Lancamento l : lancamentos) {
            if (l.getTipo() == Tipo.RECEITA) {
                resultado.add((Receita) l);
            }
        }
        return resultado;
    }

    /**
     * Lista todas as despesas
     *
     * @return
     */
    public ArrayList<Despesa> despesas() {
        ArrayList<Despesa> resultado = new ArrayList<Despesa>();
        for (Lancamento l : lancamentos) {
            if (l.getTipo() == Tipo.DESPESA) {
                resultado.add((Despesa) l);
            }
        }
        return resultado;
    }

    /**
     * Percorre todos os lançamentos e soma receitas, subtraindo despesas, no
     * entanto, ignora lançamentos com data posterior à data de hoje.
     *
     * Utilizando o LocalDate.now() para obter a data atual, e
     * !lancamento.getData().isAfter(hoje) para filtrar apenas os lançamentos
     * até hoje.
     *
     * Obs.: isAfter() é um método de LocalDate que retorna true se a data for
     * posterior à data comparada. O ! inverte a lógica: só entra no cálculo
     * quem não é posterior a hoje.
     *
     * @return resultado
     */
    public double saldoAtual() {
        LocalDate hoje = LocalDate.now();
        double saldo = 0.0;
        for (Lancamento lancamento : lancamentos) {
            if (!lancamento.getData().isAfter(hoje)) {
                if (lancamento.getTipo() == Tipo.RECEITA) {
                    saldo += lancamento.getValor();
                } else {
                    saldo -= lancamento.getValor();
                }
            }
        }
        return saldo;
    }

    // -------------------------------------------------------------------------
    // Funcionalidades Extrato
    // -------------------------------------------------------------------------
    /**
     * Cria uma cópia da lista de lançamentos e a ordena por data (do mais
     * antigo ao mais recente). O "Comparator.comparing(Lancamento::getData)"
     * cria um comparador que usa a data de cada lançamento para definir a
     * ordem.
     *
     * @return
     */
    public ArrayList<Lancamento> ordenarExtrato() {
        ArrayList<Lancamento> extrato = new ArrayList<Lancamento>(lancamentos);
        extrato.sort(Comparator.comparing(Lancamento::getData));
        return extrato;
    }

    /**
     * Calcula o saldo acumulado considerando todos os lançamentos do extrato
     * ordenado até a posição indice.
     *
     * @param indice
     * @return
     */
    public double saldoAcumuladoAte(int indice) {
        ArrayList<Lancamento> extrato = ordenarExtrato();
        if (indice < 0 || indice >= extrato.size()) {
            throw new IllegalArgumentException("Índice fora dos limites: " + indice);
        }
        double saldo = 0.0;
        for (int i = 0; i <= indice; i++) {
            Lancamento l = extrato.get(i);
            if (l.getTipo() == Tipo.RECEITA) {
                saldo += l.getValor();
            } else {
                saldo -= l.getValor();
            }
        }
        return saldo;
    }

}
