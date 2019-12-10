/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.janusamaia.meusinvestimentos.dao;

import br.com.janusamaia.meusinvestimentos.model.Usuario;
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
public class UsuarioDAO implements GernericDAO{
    
    private DataSource dataSource;
    
    public UsuarioDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        try{
            if(o instanceof Usuario){
                Usuario usuario = (Usuario)o; System.out.println(usuario.getEstado());
                String SQL = "INSERT INTO tblUsuario VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getUsername());
                stm.setString(3, usuario.getEmail());
                stm.setString(4, usuario.getSenha());
                stm.setString(5, usuario.getCep());
                stm.setString(6, usuario.getRua());
                stm.setString(7, usuario.getBairro());
                stm.setString(8, usuario.getCidade());
                stm.setString(9, usuario.getEstado());
                stm.setString(10, usuario.getTipo());
                stm.setString(11, usuario.getNumero());
                stm.setString(12, usuario.getComplemento());
                
                int res = stm.executeUpdate();
                if(res != 0){
                    ResultSet rs = stm.getGeneratedKeys();
                    if(rs.next()){
                        usuario.setId(rs.getInt(1));
                    }
                    rs.close();
                    stm.close();
                }
            }
            else{
                throw new RuntimeException("Invalid user model object.");
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao inserir usuário - "+ex.getMessage());
        }
    }

    @Override
    public void update(Object o) {
        try{
            if(o instanceof Usuario){
                Usuario usuario = (Usuario)o;
                String SQL = "UPDATE tblUsuario "
                        + "SET nome = ?, "
                        + "username = ?, "
                        + "cep = ?, "
                        + "rua = ?, "
                        + "numero = ?, "
                        + "complemento = ?, "
                        + "bairro = ?, "
                        + "cidade = ?, "
                        + "estado = ?, "
                        + "tipo = ? "
                        + "WHERE id = ? ";
                
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getUsername());
                stm.setString(3, usuario.getCep());
                stm.setString(4, usuario.getRua());
                stm.setString(5, usuario.getNumero());
                stm.setString(6, usuario.getComplemento());
                stm.setString(7, usuario.getBairro());
                stm.setString(8, usuario.getCidade());
                stm.setString(9, usuario.getEstado());
                stm.setString(10, usuario.getTipo());
                stm.setInt(11, usuario.getId());
                
                int res = stm.executeUpdate();
                stm.close();
            }
            else{
                throw new RuntimeException("Invalid user model object.");
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar usuário - "+ex.getMessage());
        }
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> read(Object o) {
        try{
            if(o instanceof Usuario){
                Usuario user = (Usuario)o;
                String SQL = "SELECT * FROM tblUsuario WHERE email = ? AND senha = ?";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                stm.setString(1, user.getEmail());
                stm.setString(2, user.getSenha());
                ResultSet rs = stm.executeQuery();
                ArrayList<Object> result = new ArrayList<Object>();
                if(rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setUsername(rs.getString("username"));
                    usuario.setEmail(rs.getString("email"));
                    result.add(usuario);
                }
                stm.close();
                rs.close();
                return result;
            }
            else{
                throw new RuntimeException("Objeto inválido.");
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao recuperar usuário - "+ex.getMessage());
        }
        return null;
    }
    
}
