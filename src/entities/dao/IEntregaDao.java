/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.Entrega;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IEntregaDao {
    
    void insert(Entrega entrega);
    Entrega findById(Integer idNotaFiscal);
    List<Entrega> findAll();
    void update(Entrega entrega);
    void delete(Integer idNotaFiscal);
    
}
