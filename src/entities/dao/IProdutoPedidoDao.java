/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.ProdutoPedido;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IProdutoPedidoDao {
    
    void insert(ProdutoPedido produtopedido);
    ProdutoPedido findById(Integer id);
    List<ProdutoPedido> findAll();
    void update(ProdutoPedido produtopedido);
    void delete(Integer id);
    
}
