/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dao.implementation.exceptions;

/**
 *
 * @author ADM
 */
public class RegisterNotFoundException extends RuntimeException {
    
    public RegisterNotFoundException(String message) {
        super(message);
    }
    
}
