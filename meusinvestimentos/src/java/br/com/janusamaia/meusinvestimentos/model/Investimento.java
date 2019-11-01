/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.model;

import java.util.Date;

/**
 *
 * @author janusam
 */
public class Investimento implements java.io.Serializable{
    private int id;
    private int nomeInvestimento;
    private Date dataDoInvestimento;
    private Date dataDeVencimento;
    private double taxaPactuada;
    private String indice;

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
    public int getNomeInvestimento() {
        return nomeInvestimento;
    }

    /**
     * @param nomeInvestimento the nomeInvestimento to set
     */
    public void setNomeInvestimento(int nomeInvestimento) {
        this.nomeInvestimento = nomeInvestimento;
    }

    /**
     * @return the dataDoInvestimento
     */
    public Date getDataDoInvestimento() {
        return dataDoInvestimento;
    }

    /**
     * @param dataDoInvestimento the dataDoInvestimento to set
     */
    public void setDataDoInvestimento(Date dataDoInvestimento) {
        this.dataDoInvestimento = dataDoInvestimento;
    }

    /**
     * @return the dataDeVencimento
     */
    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    /**
     * @param dataDeVencimento the dataDeVencimento to set
     */
    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    /**
     * @return the taxaPactuada
     */
    public double getTaxaPactuada() {
        return taxaPactuada;
    }

    /**
     * @param taxaPactuada the taxaPactuada to set
     */
    public void setTaxaPactuada(double taxaPactuada) {
        this.taxaPactuada = taxaPactuada;
    }

    /**
     * @return the indice
     */
    public String getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(String indice) {
        this.indice = indice;
    }

    
}
