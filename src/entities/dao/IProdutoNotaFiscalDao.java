/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.ProdutoNotaFiscal;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IProdutoNotaFiscalDao {
    
    void insert(ProdutoNotaFiscal produtopedido);
    ProdutoNotaFiscal findById(Integer idNotaFiscal, Integer idProduto);
    List<ProdutoNotaFiscal> findAll(Integer idNotaFiscal);
    void update(ProdutoNotaFiscal produtopedido);
    void delete(Integer idNotaFiscal, Integer idProduto);
    
}
