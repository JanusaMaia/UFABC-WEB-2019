/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.dao;

import br.com.janusamaia.meusinvestimentos.model.Evolucao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author janus
 */
public class EvolucaoDAO implements GernericDAO{
    
    private DataSource dataSource;
    
    public EvolucaoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public void create(Object o) {
        try{
            if(o instanceof Evolucao){
                Evolucao evolucao = (Evolucao)o;
                String SQL = "INSERT INTO tblEvolucao VALUES(null,?,?,?)";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setDouble(1, evolucao.getValorAtualizado());
                stm.setTimestamp(2, (Timestamp)evolucao.getData());
                stm.setInt(3,evolucao.getInvestimento().getId());
                
                int res = stm.executeUpdate();
                if(res == 0){
                    throw new RuntimeException("Erro ao incluir investimento.");
                }
                ResultSet rs = stm.getGeneratedKeys();
                if(rs.next()){
                    evolucao.setId(rs.getInt("id"));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> read(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
