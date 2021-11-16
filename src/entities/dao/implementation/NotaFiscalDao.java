/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.NotaFiscal;
import entities.dao.INotaFiscalDao;
import entities.dao.implementation.exceptions.DatabaseException;
import entities.dao.implementation.exceptions.RegisterNotFoundException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class NotaFiscalDao implements INotaFiscalDao {

    @Override
    public void insert(NotaFiscal notaFiscal ){
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               INSERT INTO NotasFiscais(dataEmissao, id_romaneio, id_cliente)
                                                               VALUES(?, ?, ?);
                                                               """);
            query.setString(1, notaFiscal.getDataEmissao().toString());
            query.setString(2, notaFiscal.getRomaneio().getId().toString());
            query.setString(3, notaFiscal.getCliente().getId().toString());
            
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
    public NotaFiscal findById(Integer id) {
        NotaFiscal obj = new NotaFiscal();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM NotasFiscais WHERE id_NotaFiscal = ?;");
            query.setInt(1, id);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj = new NotaFiscal();
                obj.setId(retorno.getInt("id_NotaFiscal"));
                obj.setDataEmissao(new SimpleDateFormat("dd/MM/yyyy").parse(retorno.getString("dataemissao")).toInstant());
                //obj.setRomaneio...
                obj.setCliente(new ClienteDao().findById(retorno.getInt(("id_cliente"))));
//                if(retorno.getInt(("id_romaneio")) != 0) {
//                    
//                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(NotaFiscalDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return obj;
    }

    @Override
    public List<NotaFiscal> findAll() {
        List<NotaFiscal> lista = new ArrayList<>();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM NotasFiscais;");
            
            ResultSet retorno = query.executeQuery();
            
            NotaFiscal obj;
            
            while(retorno.next()){
                obj = new NotaFiscal();
                obj.setId(retorno.getInt("id_NotaFiscal"));
                obj.setDataEmissao(new SimpleDateFormat("dd/MM/yyyy").parse(retorno.getString("dataemissao")).toInstant());
                //obj.setRomaneio...
                obj.setCliente(new ClienteDao().findById(retorno.getInt(("id_cliente"))));
                lista.add(obj);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(NotaFiscalDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return lista;
    }

    @Override
    public void update(NotaFiscal notaFiscal) {
        validarExistencia(notaFiscal.getId());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE NotasFiscais SET dataemissao = ?, id_romaneio = ?, id_cliente = ? 
                                                               WHERE id_NotaFiscal = ?;
                                                               """);
            query.setString(1,  new SimpleDateFormat("dd/MM/yyyy").format(Date.from(notaFiscal.getDataEmissao())));
            query.setInt(2, notaFiscal.getRomaneio().getId());
            query.setInt(3, notaFiscal.getCliente().getId());
            
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
            
            PreparedStatement query = conexao.prepareStatement("DELETE FROM NotasFiscais WHERE id_NotaFiscal = ?;");
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
        NotaFiscal obj = findById(id);
        
        if(obj.getId() == null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
    }
    
}
