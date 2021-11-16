/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import entities.Motorista;
import entities.NotaFiscal;
import entities.dao.IMotoristaDao;
import entities.dao.INotaFiscalDao;
import entities.dao.implementation.NotaFiscalDao;
import entities.dao.implementation.exceptions.DatabaseException;
import gui.enums.EstadoOperacao;
import gui.utils.Utils;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yo
 */
public class FrmCadastrarRomaneio extends javax.swing.JFrame {

    private INotaFiscalDao dao;
    private EstadoOperacao estadoOperacao;
    
    /**
     * Creates new form FrmCadastrarMotorista
     */
    public FrmCadastrarRomaneio(NotaFiscalDao daoNF) {
	initComponents();
        this.setLocationRelativeTo(null);
        
        this.dao = daoNF;
        this.estadoOperacao = EstadoOperacao.OCIOSO;
        
        habilitarCampos(false);
        atualizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        cbxBusca = new javax.swing.JComboBox<>();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNF = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        lblPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        lblProcurarPor = new javax.swing.JLabel();
        btnCancelarPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstNF = new javax.swing.JList<>();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        lblVeiculo = new javax.swing.JLabel();
        lblMotorista = new javax.swing.JLabel();
        cbxVeiculo = new javax.swing.JComboBox<>();
        txtId1 = new javax.swing.JTextField();
        cbxMotorista = new javax.swing.JComboBox<>();
        btnDetalhes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.setEditable(false);

        cbxBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome" }));
        cbxBusca.setEnabled(false);

        btnGravar.setText("Gravar");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        tblNF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome do Cliente", "Data de Emissão", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblNF);

        lblId.setText("ID:");

        lblPesquisar.setText("Pesquisar");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblProcurarPor.setText("Procurar por:");
        lblProcurarPor.setToolTipText("");

        btnCancelarPesquisa.setText("Cancelar");
        btnCancelarPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPesquisaActionPerformed(evt);
            }
        });

        lstNF.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "NF - 120", "NF - 69", "NF - 420", "NF - 666", "NF - 42" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstNF);

        btnAdicionar.setText("Adicionar");

        btnRemover.setText("Remover");

        lblVeiculo.setText("Veiculo");

        lblMotorista.setText("Motorista");

        cbxVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corsa", "Ferrari", "Uno", "Relampago Marquinhos", " " }));
        cbxVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVeiculoActionPerformed(evt);
            }
        });

        txtId1.setEditable(false);

        cbxMotorista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estevão Rei Delas", "Matilda Barraqueira", "MC Carol", "MC Poze Passa o Rodo" }));
        cbxMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMotoristaActionPerformed(evt);
            }
        });

        btnDetalhes.setText("Exibir Detalhes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGravar)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVeiculo)
                                    .addComponent(lblMotorista))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxMotorista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnRemover))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblProcurarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDetalhes)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelarPesquisa)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVoltar)
                            .addComponent(btnAdicionar)
                            .addComponent(btnDetalhes))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPesquisar)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar)
                            .addComponent(lblProcurarPor)
                            .addComponent(cbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarPesquisa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVeiculo)
                            .addComponent(cbxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMotorista)
                            .addComponent(cbxMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGravar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**/
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new FrmListarRomaneio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        habilitarCampos(false);
        estadoOperacao = EstadoOperacao.OCIOSO;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblNF.getModel();
        Utils.limparTabela(model);
        
        int id;
        try {
            id = Integer.parseInt(txtPesquisar.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Insira um número de ID válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        NotaFiscal obj = dao.findById(id);
        
        if(obj.getId() == null)
            return;
        
        model.addRow(new String[] {
            String.valueOf(obj.getId()),
                "Cliente Fake",
                "01/01/2020",
                String.valueOf(99.90)
        });
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCancelarPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPesquisaActionPerformed
        atualizarTabela();
        txtPesquisar.setText("");
    }//GEN-LAST:event_btnCancelarPesquisaActionPerformed

    private void cbxVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxVeiculoActionPerformed

    private void cbxMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMotoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMotoristaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarPesquisa;
    private javax.swing.JButton btnDetalhes;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbxBusca;
    private javax.swing.JComboBox<String> cbxMotorista;
    private javax.swing.JComboBox<String> cbxVeiculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMotorista;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblProcurarPor;
    private javax.swing.JLabel lblVeiculo;
    private javax.swing.JList<String> lstNF;
    private javax.swing.JTable tblNF;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

    private void habilitarCampos(boolean b) {
        txtId.setEnabled(b);
    }

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tblNF.getModel();
        Utils.limparTabela(model);
        
        List<NotaFiscal> nfs = dao.findAll();
        
        for(NotaFiscal nf : nfs) {
            model.addRow(new String[] {
                String.valueOf(nf.getId()),
                "Cliente Fake",
                "01/01/2020",
                String.valueOf(99.90)
            });
        }
    }

    private void limparCampos() {
        txtId.setText("");
        cbxVeiculo.setSelectedIndex(0);
        cbxMotorista.setSelectedIndex(0);
    }
/*
    private void preencherCampos(Integer id) {
        Motorista obj = dao.findById(id);
        txtId.setText(String.valueOf(obj.getId()));
        txtNome.setText(obj.getNome());
        cbxTipoCarteira.setSelectedItem(obj.getCategoriaCnh());
    }

    private void inserirRegistro() {
        if(!validarCampos())
        {
            JOptionPane.showMessageDialog(this, "Os dados preenchidos estão inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Motorista obj = new Motorista();
        obj.setNome(txtNome.getText());
        obj.setCategoriaCnh(String.valueOf(cbxTipoCarteira.getSelectedItem()).charAt(0));
        
        try {
            dao.insert(obj);
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível inserir o registro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(this, "O registro foi inserido com sucesso!");
        atualizarTabela();
        limparCampos();
        estadoOperacao = EstadoOperacao.OCIOSO;
    }

    private void editarRegistro() {
        if(!validarCampos())
        {
            JOptionPane.showMessageDialog(this, "Os dados preenchidos estão inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Motorista obj = new Motorista();
        obj.setId(Integer.parseInt(txtId.getText()));
        obj.setNome(txtNome.getText());
        obj.setCategoriaCnh(String.valueOf(cbxTipoCarteira.getSelectedItem()).charAt(0));
        
        try {
            dao.update(obj);
        } catch (DatabaseException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível editar o registro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(this, "O registro foi editado com sucesso!");
        atualizarTabela();
        limparCampos();
        estadoOperacao = EstadoOperacao.OCIOSO;
    }

    private boolean validarCampos() {
        return !txtNome.getText().isEmpty();
    }
*/
}