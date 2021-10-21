/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.Produto;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IProdutoDao {
    
    void insert(Produto produto);
    Produto findById(Integer id);
    List<Produto> findAll();
    void update(Produto produto);
    void delete(Integer id);
    
}
