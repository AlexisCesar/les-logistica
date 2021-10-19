/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.utils;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADM
 */
public class Utils {
    
    public static void limparTabela(DefaultTableModel model) {
        while(model.getRowCount() > 0)
            model.removeRow(0);
    }
    
}
