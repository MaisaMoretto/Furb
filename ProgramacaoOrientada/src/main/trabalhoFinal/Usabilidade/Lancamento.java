package Usabilidade;

import java.time.LocalDate;

public abstract class Lancamento {

    protected Tipo tipo;
    protected String descricao;
    protected double valor;
    protected LocalDate data;

    public Lancamento(String descricao, double valor, LocalDate data, Tipo tipo) {
    	setDescricao(descricao);
        setValor(valor);
        setData(data);
        setTipo(tipo);
        
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo inválido!");
        }
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Preencha a descrição!");
        }
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido. Preencha o campo com um valor válido!");
        }
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ser nula.");
        }
        if (data.getYear() < 2000 || data.getYear() > 2100) {
            throw new IllegalArgumentException("Data inválida! Informe um ano entre 2000 e 2100.");
        }
        if (data.getMonthValue() < 1 || data.getMonthValue() > 12) {
            throw new IllegalArgumentException("Data inválida! Mês deve ser entre 01 e 12.");
        }
        this.data = data;
    }

}
