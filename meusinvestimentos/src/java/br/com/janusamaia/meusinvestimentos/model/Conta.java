/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.model;

import java.util.List;
import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 *
 * @author janusam
 */
public class Conta implements java.io.Serializable{
    private int id;
    private String banco;
    private String apelidoConta;
    private String agencia;
    private String numero;
    private Usuario usuario;
    
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
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the conta to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
}
