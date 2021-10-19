/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.Motorista;
import entities.dao.IMotoristaDao;
import entities.dao.implementation.exceptions.DatabaseException;
import entities.dao.implementation.exceptions.RegisterNotFoundException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class MotoristaDao implements IMotoristaDao {

    @Override
    public void insert(Motorista motorista) {
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               INSERT INTO Motoristas(nome, cat_cnh)
                                                               VALUES (?, ?);
                                                               """);
            query.setString(1, motorista.getNome());
            query.setString(2, String.valueOf(motorista.getCategoriaCnh()));
            
            int affectedRows = query.executeUpdate();
            
            if(affectedRows == 0)
                throw new DatabaseException("Não foi possível salvar o registro no banco de dados.");
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
    }

    @Override
    public Motorista findById(Integer id) {
        Motorista obj = new Motorista();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Motoristas WHERE id_motorista = ?;");
            query.setInt(1, id);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj = new Motorista();
                obj.setId(retorno.getInt("id_motorista"));
                obj.setNome(retorno.getString("nome"));
                obj.setCategoriaCnh(retorno.getString("cat_cnh").charAt(0));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return obj;
    }

    @Override
    public List<Motorista> findAll() {
        List<Motorista> lista = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Motoristas;");
            
            ResultSet retorno = query.executeQuery();
            
            Motorista obj;
            
            while(retorno.next()){
                obj = new Motorista();
                obj.setId(retorno.getInt("id_motorista"));
                obj.setNome(retorno.getString("nome"));
                obj.setCategoriaCnh(retorno.getString("cat_cnh").charAt(0));
                lista.add(obj);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return lista;
    }

    @Override
    public void update(Motorista motorista) {
        validarExistencia(motorista.getId());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE Motoristas SET nome = ?, cat_cnh = ? 
                                                               WHERE id_motorista = ?;
                                                               """);
            query.setString(1, motorista.getNome());
            query.setString(2, String.valueOf(motorista.getCategoriaCnh()));
            query.setInt(3, motorista.getId());
            
            int affectedRows = query.executeUpdate();
            
            if(affectedRows == 0)
                throw new DatabaseException("Não foi possível atualizar o registro no banco de dados.");
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
    }

    @Override
    public void delete(Integer id) {
        validarExistencia(id);
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("DELETE FROM Motoristas WHERE id_motorista = ?;");
            query.setInt(1, id);
            
            int affectedRows = query.executeUpdate();
            
            if(affectedRows == 0)
                throw new DatabaseException("Não foi possível remover o registro do banco de dados.");
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
    }

    private void validarExistencia(Integer id) {
        Motorista obj = findById(id);
        
        if(obj.getId() == null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
    }
    
}
