/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.Usuario;
import entities.dao.IUsuarioDao;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADM
 */
public class UsuarioDao implements IUsuarioDao {
    
    @Override
    public void insert(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findById(String usuario) {
        
        Usuario obj = new Usuario();
        
        try {
            Connection conexao = new Database().getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Usuarios WHERE usuario = ?");
            query.setString(1, usuario);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj.setUsuario(retorno.getString("usuario"));
                obj.setSenha(retorno.getString("senha"));
            }
            
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return obj;
    }

    @Override
    public List<Usuario> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
