/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.NotaFiscal;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface INotaFiscalDao {
    
    void insert(NotaFiscal notaFiscal);
    NotaFiscal findById(Integer id);
    List<NotaFiscal> findAll();
    void update(NotaFiscal notaFiscal);
    void delete(Integer id);
    
}
