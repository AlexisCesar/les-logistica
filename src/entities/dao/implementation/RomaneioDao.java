/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.Romaneio;
import entities.dao.IMotoristaDao;
import entities.dao.IRomaneioDao;
import entities.dao.IVeiculoDao;
import entities.dao.implementation.exceptions.DatabaseException;
import entities.dao.implementation.exceptions.RegisterNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class RomaneioDao implements IRomaneioDao {

    private IVeiculoDao veiculoDao;
    private IMotoristaDao motoristaDao;
    
    public RomaneioDao(IVeiculoDao veiculoDao, IMotoristaDao motoristaDao) {
        this.veiculoDao = veiculoDao;
        this.motoristaDao = motoristaDao;
    }
    
    @Override
    public Integer insert(Romaneio romaneio) {
        Integer generatedID = null;
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               INSERT INTO Romaneios(placa_veiculo, id_motorista)
                                                               VALUES (?, ?);
                                                               """, PreparedStatement.RETURN_GENERATED_KEYS);
            query.setString(1, romaneio.getVeiculo().getPlaca());
            query.setInt(2, romaneio.getMotorista().getId());
            
            int affectedRows = query.executeUpdate();
            
            if(affectedRows == 0)
                throw new DatabaseException("Não foi possível salvar o registro no banco de dados.");
            
            try(ResultSet generatedKeys = query.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    generatedID = generatedKeys.getInt(1);
                } else {
                    throw new DatabaseException("Não foi possível salvar o registro no banco de dados. ID não retornado.");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return generatedID;
    }

    @Override
    public Romaneio findById(Integer id) {
        Romaneio obj = new Romaneio();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Romaneios WHERE id_romaneio = ?;");
            query.setInt(1, id);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj = new Romaneio();
                obj.setId(retorno.getInt("id_romaneio"));
                obj.setMotorista(motoristaDao.findById(retorno.getInt("id_motorista")));
                obj.setVeiculo(veiculoDao.findById(retorno.getString("placa_veiculo")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return obj;
    }

    @Override
    public List<Romaneio> findAll() {
        List<Romaneio> lstRomaneio = new ArrayList<>();
        
        Romaneio obj = null;
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Romaneios;");
            
            ResultSet retorno = query.executeQuery();
            
            while(retorno.next()){
                obj = new Romaneio();
                obj.setId(retorno.getInt("id_romaneio"));
                obj.setMotorista(motoristaDao.findById(retorno.getInt("id_motorista")));
                obj.setVeiculo(veiculoDao.findById(retorno.getString("placa_veiculo")));
                lstRomaneio.add(obj);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return lstRomaneio;
    }

    @Override
    public void update(Romaneio romaneio) {
        validarExistencia(romaneio.getId());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE Romaneios SET placa_veiculo = ?, id_motorista = ? 
                                                               WHERE id_romaneio = ?;
                                                               """);
            query.setString(1, romaneio.getVeiculo().getPlaca());
            query.setString(2, String.valueOf(romaneio.getMotorista().getId()));
            query.setInt(3, romaneio.getId());
            
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
            
            PreparedStatement query = conexao.prepareStatement("DELETE FROM Romaneios WHERE id_romaneio = ?;");
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
        
        Romaneio obj = findById(id);
        
        if(obj.getId()== null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
        
    }
    
    
}
