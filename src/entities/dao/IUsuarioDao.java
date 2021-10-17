/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao;

import entities.Usuario;
import java.util.List;

/**
 *
 * @author ADM
 */
public interface IUsuarioDao {
    
    void insert(Usuario usuario);
    Usuario findById(String usuario);
    List<Usuario> findAll();
    void delete();
    
}
