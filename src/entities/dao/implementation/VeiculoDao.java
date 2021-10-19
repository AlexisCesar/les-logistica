/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.Veiculo;
import entities.dao.IVeiculoDao;
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
public class VeiculoDao implements IVeiculoDao {

    @Override
    public void insert(Veiculo veiculo) {
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               INSERT INTO Veiculos(placa, marca, modelo, ano, capacidade)
                                                               VALUES (?, ?, ?, ?, ?);
                                                               """);
            query.setString(1, veiculo.getPlaca());
            query.setString(2, veiculo.getMarca());
            query.setString(3, veiculo.getModelo());
            query.setInt(4, veiculo.getAno());
            query.setDouble(5, veiculo.getCapacidade());
            
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
    public Veiculo findById(String placa) {
        Veiculo obj = new Veiculo();
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Veiculos WHERE placa = ?;");
            query.setString(1, placa);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj.setPlaca(retorno.getString("placa"));
                obj.setMarca(retorno.getString("marca"));
                obj.setModelo(retorno.getString("modelo"));
                obj.setAno(retorno.getInt("ano"));
                obj.setCapacidade(retorno.getDouble("capacidade"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return obj;
        
    }

    @Override
    public List<Veiculo> findAll() {
        List<Veiculo> lista = new ArrayList<>();
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Veiculos;");
            
            ResultSet retorno = query.executeQuery();
            
            Veiculo obj;
            
            while(retorno.next()){
                obj = new Veiculo();
                obj.setPlaca(retorno.getString("placa"));
                obj.setMarca(retorno.getString("marca"));
                obj.setModelo(retorno.getString("modelo"));
                obj.setAno(retorno.getInt("ano"));
                obj.setCapacidade(retorno.getDouble("capacidade"));
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
    public void update(Veiculo veiculo) {
        
        validarExistencia(veiculo.getPlaca());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE Veiculos SET marca = ?, modelo = ?, 
                                                               ano = ?, capacidade = ? WHERE placa = ?;
                                                               """);
            query.setString(1, veiculo.getMarca());
            query.setString(2, veiculo.getModelo());
            query.setInt(3, veiculo.getAno());
            query.setDouble(4, veiculo.getCapacidade());
            query.setString(5, veiculo.getPlaca());
            
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
    public void delete(String placa) {
        
        validarExistencia(placa);
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("DELETE FROM Veiculos WHERE placa = ?;");
            query.setString(1, placa);
            
            int affectedRows = query.executeUpdate();
            
            if(affectedRows == 0)
                throw new DatabaseException("Não foi possível remover o registro do banco de dados.");
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
    }
    
    private void validarExistencia(String placa) {
        
        Veiculo obj = findById(placa);
        
        if(obj.getPlaca() == null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
        
    }
    
}
