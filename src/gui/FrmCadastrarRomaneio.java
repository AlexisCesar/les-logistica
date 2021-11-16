/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import entities.Motorista;
import entities.NotaFiscal;
import entities.ProdutoNotaFiscal;
import entities.Veiculo;
import entities.dao.IMotoristaDao;
import entities.dao.INotaFiscalDao;
import entities.dao.IProdutoNotaFiscalDao;
import entities.dao.IVeiculoDao;
import entities.dao.implementation.MotoristaDao;
import entities.dao.implementation.RomaneioDao;
import entities.dao.implementation.VeiculoDao;
import gui.enums.EstadoOperacao;
import gui.utils.Utils;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yo
 */
public class FrmCadastrarRomaneio extends javax.swing.JFrame {
    
    private INotaFiscalDao notaFiscalDao;
    private IProdutoNotaFiscalDao produtoNotaFiscalDao;
    private IVeiculoDao veiculoDao;
    private IMotoristaDao motoristaDao;
    private EstadoOperacao estadoOperacao;
    
    /**
     * Creates new form FrmCadastrarMotorista
     */
    public FrmCadastrarRomaneio(INotaFiscalDao notaFiscalDao, IProdutoNotaFiscalDao produtoNotaFiscalDao,
                                IVeiculoDao veiculoDao, IMotoristaDao motoristaDao) {
	initComponents();
        this.setLocationRelativeTo(null);
        
        this.notaFiscalDao = notaFiscalDao;
        this.produtoNotaFiscalDao = produtoNotaFiscalDao;
        this.veiculoDao = veiculoDao;
        this.motoristaDao = motoristaDao;
        
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
        btnDetalhes = new javax.swing.JButton();
        txtPlacaVeiculo = new javax.swing.JTextField();
        txtIdMotorista = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtId.setEditable(false);

        cbxBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome" }));
        cbxBusca.setEnabled(false);

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome do Cliente", "Data de Emissão", "Valor Total", "Embalagens", "Entregue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jScrollPane1.setViewportView(lstNF);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        lblVeiculo.setText("Veiculo");

        lblMotorista.setText("Motorista");

        btnDetalhes.setText("Exibir Detalhes");
        btnDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMotorista)
                                            .addComponent(lblVeiculo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPlacaVeiculo)
                                            .addComponent(txtIdMotorista, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnRemover)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDetalhes)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelarPesquisa)))))
                .addContainerGap())
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
                            .addComponent(txtPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMotorista)
                            .addComponent(txtIdMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGravar))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**/
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        new FrmListarRomaneio(new RomaneioDao(new VeiculoDao(), new MotoristaDao())).setVisible(true);
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
        
        NotaFiscal nf = notaFiscalDao.findById(id);
        
        if(nf.getId() == null)
            return;
        
        double valorTotal = 0f;
        int quantidadeEmbalagens = 0;

        List<ProdutoNotaFiscal> itens = produtoNotaFiscalDao.findAll(nf.getId());

        for(ProdutoNotaFiscal item : itens) {
            valorTotal += item.getQuantidade() * item.getProduto().getValor();
            quantidadeEmbalagens += item.getQuantidade();
        }
        
        model.addRow(new String[] {
            String.valueOf(nf.getId()),
            nf.getCliente().getNome(),
            new SimpleDateFormat("dd/MM/yyyy").format(Date.from(nf.getDataEmissao())),
            String.valueOf(new DecimalFormat("#,##0.00").format(valorTotal)),
            String.valueOf(quantidadeEmbalagens),
            "Não"
        });
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCancelarPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPesquisaActionPerformed
        atualizarTabela();
        txtPesquisar.setText("");
    }//GEN-LAST:event_btnCancelarPesquisaActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if(!validarCampos()) {
            JOptionPane.showMessageDialog(this, "Um ou mais campos inválidos\nVerifique se informou:"
                    + "\nA placa correta do veículo"
                    + "\nO ID correto do motorista"
                    + "\nUma ou mais notas fiscais para o romaneio");
            return;
        }
        
        //Validar o veículo
        Veiculo veiculo = veiculoDao.findById(txtPlacaVeiculo.getText().toUpperCase());
        
        if(veiculo.getPlaca() == null) {
            JOptionPane.showMessageDialog(this, "Nenhum veículo encontrado com essa placa.");
            return;
        }
        
        //Validar o motorista
        Motorista motorista = motoristaDao.findById(Integer.valueOf(txtIdMotorista.getText()));
        
        if(motorista.getId() == null) {
           JOptionPane.showMessageDialog(this, "Nenhum motorista encontrado com esse ID.");
           return; 
        }
        
        //Validar as notas fiscais (pegar o peso total)
        List<NotaFiscal> notasFiscais = new ArrayList<>();
        int quantidadeEmbalagens = 0;
        NotaFiscal nf;
        
        for(int i = 0; i < lstNF.getModel().getSize(); i++) {
            int id = Integer.valueOf(lstNF.getModel().getElementAt(i));
            nf = notaFiscalDao.findById(id);
            
            List<ProdutoNotaFiscal> itens = produtoNotaFiscalDao.findAll(nf.getId());
            
            for(ProdutoNotaFiscal item : itens) {
                quantidadeEmbalagens += item.getQuantidade();
                nf.adicionarItem(item);
            }
            
            notasFiscais.add(nf);
        }
        
        //Validar se o veículo suporta
        if(veiculo.getCapacidade() < quantidadeEmbalagens) {
            JOptionPane.showMessageDialog(this, """
                                                Este ve\u00edculo n\u00e3o suporta essa quantidade de embalagens!
                                                Diminua a quantidade de notas fiscais ou selecione um ve\u00edculo com maior capacidade.""");
            return;
        }
        
        //Inserir (precisa inserir nova entrega aqui? = Não, ela já deve estar mockada com as NFS)
        //Precisa do RomaneioDao
        
        //Atualizar o campo romaneio das notas fiscais
        
        //Após inserir
        JOptionPane.showMessageDialog(this, "Registro inserido com sucesso!");
        new FrmListarRomaneio(new RomaneioDao(new VeiculoDao(), new MotoristaDao())).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblNF.getModel();
        
        if(tblNF.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Primeiro, selecione um registro na tabela.");
            return;
        }
        
        Integer id = Integer.parseInt(String.valueOf(model.getValueAt(tblNF.getSelectedRow(), 0)));
        
        for(int i = 0; i < lstNF.getModel().getSize(); i++) {
            if(lstNF.getModel().getElementAt(i).equals(String.valueOf(id))) {
                return;
            }
        }
        
        DefaultListModel<String> lstModel = new DefaultListModel<>();
        
        for(int i = 0; i < lstNF.getModel().getSize(); i++) {
            lstModel.addElement(lstNF.getModel().getElementAt(i));
        }
        
        lstModel.addElement(String.valueOf(id));
        lstNF.setModel(lstModel);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
        if(lstNF.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Primeiro, selecione um registro na tabela.");
            return;
        }
        
        Integer id = Integer.parseInt(lstNF.getModel().getElementAt(lstNF.getSelectedIndex()));
        
        DefaultListModel<String> lstModel = new DefaultListModel<>();
        
        for(int i = 0; i < lstNF.getModel().getSize(); i++) {
            if(!lstNF.getModel().getElementAt(i).equals(String.valueOf(id))) {
                lstModel.addElement(lstNF.getModel().getElementAt(i));
            }
        }
        lstNF.setModel(lstModel);
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesActionPerformed
        JOptionPane.showMessageDialog(this, "Ainda não implementado");
    }//GEN-LAST:event_btnDetalhesActionPerformed


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
    private javax.swing.JTextField txtIdMotorista;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPlacaVeiculo;
    // End of variables declaration//GEN-END:variables

    private void habilitarCampos(boolean b) {
        txtId.setEnabled(b);
    }

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tblNF.getModel();
        Utils.limparTabela(model);
        
        List<NotaFiscal> nfs = notaFiscalDao.findAll();
        
        for(NotaFiscal nf : nfs) {
            
            double valorTotal = 0f;
            int quantidadeEmbalagens = 0;
            
            List<ProdutoNotaFiscal> itens = produtoNotaFiscalDao.findAll(nf.getId());
            
            for(ProdutoNotaFiscal item : itens) {
                valorTotal += item.getQuantidade() * item.getProduto().getValor();
                quantidadeEmbalagens += item.getQuantidade();
            }
            
            model.addRow(new String[] {
                String.valueOf(nf.getId()),
                nf.getCliente().getNome(),
                new SimpleDateFormat("dd/MM/yyyy").format(Date.from(nf.getDataEmissao())),
                String.valueOf(new DecimalFormat("#,##0.00").format(valorTotal)),
                String.valueOf(quantidadeEmbalagens),
                "Não"
            });
            
            
            
        }
    }

    private void limparCampos() {
        DefaultListModel<String> lstModel = new DefaultListModel<>();
        lstNF.setModel(lstModel);
        
        txtPlacaVeiculo.setText("");
        txtIdMotorista.setText("");
    }

    private boolean validarCampos() {
        String placa = txtPlacaVeiculo.getText();
        placa = placa.replace(" ", "").replace("-", "");
        if(placa.isEmpty()) {
            return false;
        }
        
        try {
            Integer idMotorista = Integer.parseInt(txtIdMotorista.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        
        if(lstNF.getModel().getSize() == 0) {
            return false;
        }
        
        return true;
    }
}
