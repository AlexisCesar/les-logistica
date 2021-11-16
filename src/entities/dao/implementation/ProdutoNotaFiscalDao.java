/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.NotaFiscal;
import entities.Produto;
import entities.ProdutoNotaFiscal;
import entities.dao.INotaFiscalDao;
import entities.dao.IProdutoDao;
import entities.dao.IProdutoNotaFiscalDao;
import entities.dao.implementation.exceptions.DatabaseException;
import entities.dao.implementation.exceptions.RegisterNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class ProdutoNotaFiscalDao implements IProdutoNotaFiscalDao {
    
    private IProdutoDao produtoDao;
    private INotaFiscalDao notaFiscalDao;
    
    public ProdutoNotaFiscalDao(IProdutoDao produtoDao, INotaFiscalDao notaFiscalDao) {
        this.produtoDao = produtoDao;
        this.notaFiscalDao = notaFiscalDao;
    }

    @Override
    public void insert(ProdutoNotaFiscal produtopedido) {
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               INSERT INTO ProdutoNotaFiscal(id_notafiscal, id_produto, quantidade)
                                                               VALUES (?, ?, ?);
                                                               """);
            
            query.setInt(1, produtopedido.getNotaFiscal().getId());
            query.setInt(2, produtopedido.getProduto().getId());
            query.setInt(3, produtopedido.getQuantidade());
            
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
    public ProdutoNotaFiscal findById(Integer idNotaFiscal, Integer idProduto) {
        ProdutoNotaFiscal obj = null;
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM ProdutoNotaFiscal WHERE id_notafiscal = ? AND id_produto = ?;");
            query.setInt(1, idNotaFiscal);
            query.setInt(2, idProduto);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                int quantidade = retorno.getInt("quantidade");
                Produto produto = produtoDao.findById(idProduto);
                NotaFiscal notaFiscal = notaFiscalDao.findById(idNotaFiscal);
                obj = new ProdutoNotaFiscal(notaFiscal, produto, quantidade);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return obj;
    }

    @Override
    public List<ProdutoNotaFiscal> findAll(Integer idNotaFiscal) {
        List<ProdutoNotaFiscal> objList = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM ProdutoNotaFiscal WHERE id_notafiscal = ?;");
            
            query.setInt(1, idNotaFiscal);
            
            ResultSet retorno = query.executeQuery();
            
            ProdutoNotaFiscal obj = null;
            Produto produto = null;
            NotaFiscal notaFiscal = null;
            
            while(retorno.next()){
                int quantidade = retorno.getInt("quantidade");
                produto = produtoDao.findById(retorno.getInt("id_produto"));
                notaFiscal = notaFiscalDao.findById(retorno.getInt("id_notafiscal"));
                obj = new ProdutoNotaFiscal(notaFiscal, produto, quantidade);
                objList.add(obj);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return objList;
    }

    @Override
    public void update(ProdutoNotaFiscal produtopedido) {
        validarExistencia(produtopedido.getNotaFiscal().getId(), produtopedido.getProduto().getId());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE ProdutoNotaFiscal 
                                                               SET quantidade = ?
                                                               WHERE id_notafiscal = ? AND id_produto = ?;
                                                               """);
            query.setInt(1, produtopedido.getQuantidade());
            query.setInt(2, produtopedido.getNotaFiscal().getId());
            query.setInt(3, produtopedido.getProduto().getId());
            
            int affectedRows = query.executeUpdate();
            
            if(affectedRows == 0)
                throw new DatabaseException("Não foi possível remover o registro do banco de dados.");
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
    }

    @Override
    public void delete(Integer idNotaFiscal, Integer idProduto) {
        validarExistencia(idNotaFiscal, idProduto);
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("DELETE FROM ProdutoNotaFiscal WHERE id_notafiscal = ? AND id_produto = ?;");
            query.setInt(1, idNotaFiscal);
            query.setInt(2, idProduto);
            
            int affectedRows = query.executeUpdate();
            
            if(affectedRows == 0)
                throw new DatabaseException("Não foi possível remover o registro do banco de dados.");
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
    }
    
    private void validarExistencia(Integer idNotaFiscal, Integer idProduto) {
        ProdutoNotaFiscal obj = findById(idNotaFiscal, idProduto);
        
        if(obj.getNotaFiscal().getId() == null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
    }
    
}
