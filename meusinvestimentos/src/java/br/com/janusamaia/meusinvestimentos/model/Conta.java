/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.model;

import java.util.List;

/**
 *
 * @author janusam
 */
public class Conta implements java.io.Serializable{
    private int id;
    private String banco;
    private String apelidoConta;
    private int agencia;
    private int conta;
    private int digito;
    
    private List<Investimento> investimentos;

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
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the apelidoConta
     */
    public String getApelidoConta() {
        return apelidoConta;
    }

    /**
     * @param apelidoConta the apelidoConta to set
     */
    public void setApelidoConta(String apelidoConta) {
        this.apelidoConta = apelidoConta;
    }

    /**
     * @return the agencia
     */
    public int getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the conta
     */
    public int getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(int conta) {
        this.conta = conta;
    }

    /**
     * @return the digito
     */
    public int getDigito() {
        return digito;
    }

    /**
     * @param digito the digito to set
     */
    public void setDigito(int digito) {
        this.digito = digito;
    }

    /**
     * @return the investimentos
     */
    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    /**
     * @param investimentos the investimentos to set
     */
    public void setInvestimentos(List<Investimento> investimentos) {
        this.investimentos = investimentos;
    }

    
}
