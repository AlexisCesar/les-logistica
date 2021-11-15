/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.ProdutoPedido;
import entities.dao.IProdutoPedidoDao;
import entities.dao.IProdutoPedidoPedidoDao;
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
public class ProdutoPedidoDao implements IProdutoPedidoDao {

    @Override
    public void insert(ProdutoPedido produto ){
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               INSERT INTO ProdutoPedido(id_notafiscal, id_produto, quantidade)
                                                               VALUES (?, ?, ?);
                                                               """);
            query.setString(1, produto.getDescricao());
            query.setDouble(2, produto.getValor());
            
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
    public ProdutoPedido findById(Integer idNotaFiscal, Integer idProduto) {
        ProdutoPedido obj = new ProdutoPedido();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM ProdutoPedidoNotaFiscal WHERE id_notafiscal = ? AND id_produto = ?;");
            query.setInt(1, id);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj = new ProdutoPedido();
                obj.setId(retorno.getInt("id_ProdutoPedido"));
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
    public List<ProdutoPedido> findAll() {
        List<ProdutoPedido> lista = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM ProdutoPedidoNotaFiscal;");
            
            ResultSet retorno = query.executeQuery();
            
            ProdutoPedido obj;
            
            while(retorno.next()){
                obj = new ProdutoPedido();
                obj.setId(retorno.getInt("id_ProdutoPedido"));
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
    public void update(ProdutoPedido produto) {
        validarExistencia(produto.getId());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE ProdutoPedidoNotaFiscal SET descricao = ?, valor = ? 
                                                               WHERE id_notafiscal = ? AND id_produto = ?;
                                                               """);
            query.setString(1, produto.getDescricao());
            query.setDouble(2, produto.getValor());
            query.setInt(3, produto.getId());
            
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
    public void delete(Integer idNotaFiscal, Integer idProduto) {
        validarExistencia(id);
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("DELETE FROM ProdutoPedidoNotaFiscal WHERE id_notafiscal = ? AND id_produto = ?;");
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
        ProdutoPedido obj = findById(id);
        
        if(obj.getId() == null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
    }
    
}
