/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.Romaneio;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IRomaneioDao {
    
    void insert(Romaneio romaneio);
    Romaneio findById(Integer id);
    List<Romaneio> findAll();
    void update(Romaneio romaneio);
    void delete(Integer id);
    
}
