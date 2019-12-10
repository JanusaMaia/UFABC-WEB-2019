/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.dao;

import br.com.janusamaia.meusinvestimentos.model.Conta;
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
public class ContaDAO implements GernericDAO{

    private DataSource dataSource;
    
    public ContaDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
           
    
    @Override
    public void create(Object o) {
        try{
            if(o instanceof Conta){
                Conta conta = (Conta)o;
                String SQL = "INSERT INTO tblConta VALUES(null,?,?,?,?,?)";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, conta.getBanco());
                stm.setString(2, conta.getApelidoConta());
                stm.setString(3, conta.getAgencia());
                stm.setString(4, conta.getNumero());
                stm.setObject(5, conta.getUsuario().getId());
                int res = stm.executeUpdate();
                if(res == 0){
                    throw new RuntimeException("Erro ao incluir conta.");
                }
                ResultSet rs = stm.getGeneratedKeys();
                if(rs.next()){     
                    conta.setId(rs.getInt(1));
                }
            }
            else{
                throw new RuntimeException("Invalid user model object.");
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao cadastrar conta - "+ex.getMessage());
        }
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> read(Object o) {
        try{
            String SQL = "SELECT * FROM tblConta WHERE idUsuario = ?";
            Integer idUser = (Integer)o;
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setInt(1, idUser.intValue());
            ResultSet rs = stm.executeQuery();
            ArrayList<Object> list = new ArrayList<Object>();
            while(rs.next()){
                Conta conta = new Conta();
                conta.setBanco(rs.getString("banco"));
                conta.setApelidoConta(rs.getString("apelido"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setNumero(rs.getString("numero"));
                conta.setId(rs.getInt("id"));
                list.add(conta);
            }
            rs.close();
            stm.close();
            return list;
        }
        catch(SQLException ex){
            System.out.println("Erro ao recuperar contas - "+ex.getMessage());
        }
        return null;
    }
    
    public Object readByIdConta(Integer contaId){
        try{
            String SQL = "SELECT * FROM tblConta WHERE id = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setInt(1, contaId.intValue());
            ResultSet rs = stm.executeQuery();
            Conta conta = new Conta();
            if(rs.next()){
                conta.setBanco(rs.getString("banco"));
                conta.setApelidoConta(rs.getString("apelido"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setNumero(rs.getString("numero"));
                conta.setId(rs.getInt("id"));
            }
            rs.close();
            stm.close();
            return conta;
        }
        catch(SQLException ex){
            System.out.println("Erro ao recuperar conta - "+ex.getMessage());
        }
        return null;
    }
    
}
