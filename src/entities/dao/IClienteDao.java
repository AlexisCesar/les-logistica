/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.Cliente;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IClienteDao {
    
    void insert(Cliente cliente);
    Cliente findById(Integer id);
    List<Cliente> findAll();
    void update(Cliente cliente);
    void delete(Integer id);
    
}
