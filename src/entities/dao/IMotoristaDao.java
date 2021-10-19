/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.Motorista;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IMotoristaDao {
    
    void insert(Motorista motorista);
    Motorista findById(Integer id);
    List<Motorista> findAll();
    void update(Motorista motorista);
    void delete(Integer id);
    
}
