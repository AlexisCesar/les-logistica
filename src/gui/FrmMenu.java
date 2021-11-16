/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.dao.implementation.MotoristaDao;
import entities.dao.implementation.VeiculoDao;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author ADM
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        URL url = this.getClass().getResource("images/logistica.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnCadastroVeiculo = new javax.swing.JButton();
        btnCadastroMotorista = new javax.swing.JButton();
        btnConsultarNotasFiscais = new javax.swing.JButton();
        btnCadastroRomaneio = new javax.swing.JButton();
        btnRastreamentoEntrega = new javax.swing.JButton();
        btnHistoricoEntrega = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Menu Principal");

        btnCadastroVeiculo.setText("Cadastro de Veículos");
        btnCadastroVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroVeiculoActionPerformed(evt);
            }
        });

        btnCadastroMotorista.setText("Cadastro de Motoristas");
        btnCadastroMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroMotoristaActionPerformed(evt);
            }
        });

        btnConsultarNotasFiscais.setText("Consulta de Notas Fiscais");
        btnConsultarNotasFiscais.setEnabled(false);

        btnCadastroRomaneio.setText("Cadastro de Romaneio");
        btnCadastroRomaneio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroRomaneioActionPerformed(evt);
            }
        });

        btnRastreamentoEntrega.setText("Rastreamento de Entrega");

        btnHistoricoEntrega.setText("Histórico de Entrega");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastroVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastroMotorista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultarNotasFiscais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(btnCadastroRomaneio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRastreamentoEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistoricoEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(btnCadastroVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroMotorista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarNotasFiscais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroRomaneio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRastreamentoEntrega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistoricoEntrega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        new FrmLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastroVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroVeiculoActionPerformed
        new FrmCadastrarVeiculo(new VeiculoDao()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastroVeiculoActionPerformed

    private void btnCadastroMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroMotoristaActionPerformed
        new FrmCadastrarMotorista(new MotoristaDao()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastroMotoristaActionPerformed

    private void btnCadastroRomaneioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroRomaneioActionPerformed
        new FrmListarRomaneio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastroRomaneioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroMotorista;
    private javax.swing.JButton btnCadastroRomaneio;
    private javax.swing.JButton btnCadastroVeiculo;
    private javax.swing.JButton btnConsultarNotasFiscais;
    private javax.swing.JButton btnHistoricoEntrega;
    private javax.swing.JButton btnRastreamentoEntrega;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
