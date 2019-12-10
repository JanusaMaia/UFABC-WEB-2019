/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author janusam
 */
public class Investimento implements java.io.Serializable{
    private int id;
    private String nomeInvestimento;
    private String categoria;
    private Timestamp dataDoInvestimento;
    private Timestamp dataDeVencimento;
    private Double valorInicial;
    private Double valorAtual;
    private Conta conta;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeInvestimento
     */
    public String getNomeInvestimento() {
        return nomeInvestimento;
    }

    /**
     * @param nomeInvestimento the nomeInvestimento to set
     */
    public void setNomeInvestimento(String nomeInvestimento) {
        this.nomeInvestimento = nomeInvestimento;
    }

    
    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    /**
     * @return the valorInicial
     */
    public Double getValorInicial() {
        return valorInicial;
    }

    /**
     * @param valorInicial the valorInicial to set
     */
    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    /**
     * @return the valorAtual
     */
    public Double getValorAtual() {
        return valorAtual;
    }

    /**
     * @param valorAtual the valorAtual to set
     */
    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    /**
     * @return the dataDoInvestimento
     */
    public Timestamp getDataDoInvestimento() {
        return dataDoInvestimento;
    }

    /**
     * @param dataDoInvestimento the dataDoInvestimento to set
     */
    public void setDataDoInvestimento(Timestamp dataDoInvestimento) {
        this.dataDoInvestimento = dataDoInvestimento;
    }

    /**
     * @return the dataDeVencimento
     */
    public Timestamp getDataDeVencimento() {
        return dataDeVencimento;
    }

    /**
     * @param dataDeVencimento the dataDeVencimento to set
     */
    public void setDataDeVencimento(Timestamp dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    
}
