/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.Cliente;
import entities.dao.IClienteDao;
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
public class ClienteDao implements IClienteDao {

    @Override
    public void insert(Cliente cliente ){
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               INSERT INTO Clientes(nome)
                                                               VALUES (?);
                                                               """);
            query.setString(1, cliente.getNome());
            
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
    public Cliente findById(Integer id) {
        Cliente obj = new Cliente();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Clientes WHERE id_Cliente = ?;");
            query.setInt(1, id);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj = new Cliente();
                obj.setId(retorno.getInt("id_Cliente"));
                obj.setNome(retorno.getString("nome"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return obj;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> lista = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Clientes;");
            
            ResultSet retorno = query.executeQuery();
            
            Cliente obj;
            
            while(retorno.next()){
                obj = new Cliente();
                obj.setId(retorno.getInt("id_Cliente"));
                obj.setNome(retorno.getString("nome"));
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
    public void update(Cliente cliente) {
        validarExistencia(cliente.getId());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE Clientes SET nome = ? 
                                                               WHERE id_Cliente = ?;
                                                               """);
            query.setString(1, cliente.getNome());
            query.setDouble(2, cliente.getId());
            
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
            
            PreparedStatement query = conexao.prepareStatement("DELETE FROM Clientes WHERE id_Cliente = ?;");
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
        Cliente obj = findById(id);
        
        if(obj.getId() == null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
    }
    
}
