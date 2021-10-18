/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.Veiculo;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IVeiculoDao {
    
    void insert(Veiculo veiculo);
    Veiculo findById(String placa);
    List<Veiculo> findAll();
    void update(Veiculo veiculo);
    void delete(String placa);
    
}
