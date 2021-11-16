/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation;

import db.Database;
import entities.Entrega;
import entities.NotaFiscal;
import entities.dao.IEntregaDao;
import entities.dao.INotaFiscalDao;
import entities.dao.implementation.exceptions.DatabaseException;
import entities.dao.implementation.exceptions.RegisterNotFoundException;
import entities.enums.EstadoEntrega;
import entities.utils.Geolocalizacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class EntregaDao implements IEntregaDao {

    private INotaFiscalDao notaFiscalDao;
    
    public EntregaDao(INotaFiscalDao nfDao) {
        this.notaFiscalDao = nfDao;
    }
    
    @Override
    public void insert(Entrega entrega) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entrega findById(Integer idNotaFiscal) {
        Entrega obj = new Entrega();
        
        Connection conexao = null;
        
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("SELECT * FROM Entregas WHERE id_notafiscal = ?;");
            query.setInt(1, idNotaFiscal);
            
            ResultSet retorno = query.executeQuery();
            
            if(retorno.next()){
                obj = new Entrega();
                obj.setNotaFiscal(notaFiscalDao.findById(idNotaFiscal));
                obj.setEstadoEntrega(EstadoEntrega.values()[retorno.getInt("estado")]);
                obj.setLocalizacaoDestino(new Geolocalizacao(Double.valueOf(retorno.getString("latitude")), Double.valueOf(retorno.getString("longitude"))));
                obj.setObservacao(retorno.getString("observacao"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Database.closeConnection(conexao);
        }
        
        return obj;
    }

    @Override
    public List<Entrega> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Entrega entrega) {
        validarExistencia(entrega.getNotaFiscal().getId());
        
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
            
            PreparedStatement query = conexao.prepareStatement("""
                                                               UPDATE Entregas SET latitude = ?, longitude = ?, estado = ?, observacao = ?
                                                               WHERE id_NotaFiscal = ?;
                                                               """);
            query.setString(1, String.valueOf(entrega.getLocalizacaoDestino().getLatitude()));
            query.setString(2, String.valueOf(entrega.getLocalizacaoDestino().getLongitude()));
            query.setInt(3, entrega.getEstadoEntrega().ordinal());
            query.setString(4, entrega.getObservacao());
            
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
    public void delete(Integer idNotaFiscal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void validarExistencia(Integer idNotaFiscal) {
        Entrega obj = findById(idNotaFiscal);
        
        if(obj.getNotaFiscal() == null)
            throw new RegisterNotFoundException("Não foi possível encontrar o registro no banco de dados.");
    }
    
}
