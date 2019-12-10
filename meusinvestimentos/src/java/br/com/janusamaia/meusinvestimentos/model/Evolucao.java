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
 * @author janus
 */
public class Evolucao implements java.io.Serializable{
    private int id;
    private Double valorAtualizado;
    private Timestamp data;
    private Investimento investimento;

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
     * @return the valorAtualizado
     */
    public Double getValorAtualizado() {
        return valorAtualizado;
    }

    /**
     * @param valorAtualizado the valorAtualizado to set
     */
    public void setValorAtualizado(Double valorAtualizado) {
        this.valorAtualizado = valorAtualizado;
    }

  

    /**
     * @return the investimento
     */
    public Investimento getInvestimento() {
        return investimento;
    }

    /**
     * @param investimento the investimento to set
     */
    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

    /**
     * @return the data
     */
    public Timestamp getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Timestamp data) {
        this.data = data;
    }
    
}
