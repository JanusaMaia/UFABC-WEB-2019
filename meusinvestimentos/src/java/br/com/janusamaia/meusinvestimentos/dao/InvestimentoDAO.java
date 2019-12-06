/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.dao;

import br.com.janusamaia.meusinvestimentos.model.Conta;
import br.com.janusamaia.meusinvestimentos.model.Investimento;
import br.com.janusamaia.meusinvestimentos.model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janus
 */
public class InvestimentoDAO implements GernericDAO{
    
    private DataSource dataSource;
    
    public InvestimentoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        try{
            if(o instanceof Investimento){
                Investimento investimento = (Investimento)o;
                String SQL = "INSERT INTO tblInvestimentos VALUES(null,?,?,?,?,?,?,?)";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, investimento.getNomeInvestimento());
                stm.setString(2, investimento.getCategoria());
                stm.setDate(3, (Date)investimento.getDataDoInvestimento());
                stm.setDate(4, (Date)investimento.getDataDeVencimento());
                stm.setInt(5, investimento.getConta().getId());
                stm.setDouble(6, investimento.getValorInicial());
                stm.setDouble(7, investimento.getValorAtual());
                int res = stm.executeUpdate();
                if(res == 0){
                    throw new RuntimeException("Erro ao incluir investimento.");
                }
                ResultSet rs = stm.getGeneratedKeys();
                if(rs.next()){
                    investimento.setId(rs.getInt("id"));
                }
            }
            else{
                throw new RuntimeException("Invalid user model object.");
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao cadastrar investimento - "+ex.getMessage());
        }
    }

    @Override
    public void update(Object o) {
        try{
            if(o instanceof Investimento){
                Investimento investimento = (Investimento)o;
                String SQL = "UPDATE tblInvestimentos SET valor_atual = ? WHERE id = ?";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                stm.setDouble(1, investimento.getValorAtual());
                stm.setInt(2, investimento.getId());
                int res = stm.executeUpdate();
                if(res == 0){
                    throw new RuntimeException("Erro ao atualizar investimento.");
                }
            }
            else{
                throw new RuntimeException("Invalid user model object.");
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar investimento - "+ex.getMessage());
        }
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> read(Object o) {
        try{
            Usuario usuario = (Usuario)o;
            List<Conta> contas = usuario.getContas();
            ArrayList<Object> listaRetorno = new ArrayList<Object>();
            
            for(Conta conta : contas)
            {
                Integer idConta = (Integer)conta.getId();
                String SQL = "SELECT * FROM tblInvestimentos WHERE idConta = ?";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                stm.setInt(1, idConta.intValue());
                ResultSet rs = stm.executeQuery();
                ArrayList<Investimento> list = new ArrayList<Investimento>();
                while(rs.next()){
                    Investimento invest = new Investimento();
                    invest.setNomeInvestimento(rs.getString("nome"));System.out.println(invest.getNomeInvestimento());
                    invest.setCategoria(rs.getString("categoria"));System.out.println(invest.getCategoria());
                    invest.setDataDoInvestimento(rs.getDate("data_investimento"));
                    invest.setDataDeVencimento(rs.getDate("data_vencimento"));
                    invest.setId(rs.getInt("id"));
                    invest.setValorInicial(rs.getDouble("valor_inicial"));
                    invest.setValorAtual(rs.getDouble("valor_atual"));
                    list.add(invest);
                }
                if(conta.getInvestimentos() == null){
                    conta.setInvestimentos(new ArrayList<Investimento>());
                }
                conta.setInvestimentos(list);
                
                listaRetorno.add(conta);
                rs.close();
                stm.close();
            }
            
            return listaRetorno;
        }
        catch(SQLException ex){
            System.out.println("Erro ao recuperar contas - "+ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Double> getValorTotalAplicado(Object o){
        try{
            Usuario usuario = (Usuario)o;
            List<Conta> contas = usuario.getContas();
           
            ArrayList<Double> list = new ArrayList<Double>();
            Double valorInvestidoTotal = 0.0;
            Double valorAtualTotal = 0.0;
            for(Conta conta : contas)
            {
                Integer idConta = (Integer)conta.getId();
                String SQL = "SELECT * FROM tblInvestimentos WHERE idConta = ?";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                stm.setInt(1, idConta.intValue());
                ResultSet rs = stm.executeQuery();
                
                while(rs.next()){
                    valorInvestidoTotal += rs.getDouble("valor_inicial");    
                    valorAtualTotal += rs.getDouble("valor_atual");
                }
                rs.close();
                stm.close();
            }
            list.add(valorInvestidoTotal);System.out.println(valorInvestidoTotal);
            list.add(valorAtualTotal);System.out.println(valorAtualTotal);
            return list;
        }
        catch(SQLException ex){
            System.out.println("Erro ao recuperar contas - "+ex.getMessage());
        }
        return null;
    }
    
}
