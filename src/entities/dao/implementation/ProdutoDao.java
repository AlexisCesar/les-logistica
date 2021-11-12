/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.Produto;
import entities.dao.IProdutoDao;
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
public class ProdutoDao implements IProdutoDao {

    @Override
    public void insert(Produto Produto) {
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               INSERT INTO Produtos(descricao, valor)
                                                               VALUES (?, ?);
                                                               """);
            query.setString(1, Produto.getDescricao());
            query.setDouble(2, Produto.getValor());
            
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
    public Produto findById(Integer id) {
        Produto obj = new Produto();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Produtos WHERE id_Produto = ?;");
            query.setInt(1, id);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj = new Produto();
                obj.setId(retorno.getInt("id_Produto"));
                obj.setDescricao(retorno.getString("descricao"));
                obj.setValor(retorno.getDouble("valor"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return obj;
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> lista = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Produtos;");
            
            ResultSet retorno = query.executeQuery();
            
            Produto obj;
            
            while(retorno.next()){
                obj = new Produto();
                obj.setId(retorno.getInt("id_Produto"));
                obj.setDescricao(retorno.getString("descricao"));
                obj.setValor(retorno.getDouble("valor"));
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
    public void update(Produto Produto) {
        validarExistencia(Produto.getId());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE Produtos SET descricao = ?, valor = ? 
                                                               WHERE id_Produto = ?;
                                                               """);
            query.setString(1, Produto.getDescricao());
            query.setDouble(2, Produto.getValor());
            query.setInt(3, Produto.getId());
            
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
            
            PreparedStatement query = conexao.prepareStatement("DELETE FROM Produtos WHERE id_Produto = ?;");
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
        Produto obj = findById(id);
        
        if(obj.getId() == null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
    }
    
}
