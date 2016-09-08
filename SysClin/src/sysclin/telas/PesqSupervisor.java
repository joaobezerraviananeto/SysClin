/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysclin.telas;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.AbstractTableModel;
import org.hibernate.metamodel.domain.Superclass;
import sysclin.supervisor.Supervisor;
import sysclin.supervisor.SupervisorDAO;
import sysclin.supervisor.SupervisorTableModel;
import sysclin.util.FormataTamanhoColunasJTable;

/**
 *
 * @author Joao_Viana
 */
public class PesqSupervisor extends javax.swing.JDialog {

    private static Object o;
    Supervisor supervisor = new Supervisor();
    SupervisorDAO dao = new SupervisorDAO();

    public static Object exibeTela(AbstractTableModel atm, String supervisor) {
        PesqSupervisor tp = new PesqSupervisor(atm, supervisor);
        tp.setVisible(true);

        return o;

    }

    private PesqSupervisor(AbstractTableModel atm, String supervisor) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/sysclin/imagens/logobrancop.jpg")).getImage());
        tbPesquisar.setAutoCreateRowSorter(true);
        tbPesquisar.setModel(atm);
        setLocationRelativeTo(null);
        tbPesquisar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        FormataTamanhoColunasJTable.packColumns(tbPesquisar, 1);
        tfPesquisar.grabFocus();
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        setModal(true);
    }

    public PesqSupervisor() {
        initComponents();
    }
    


    private void procuraTable(String nome) {
        for (int linha = 0; linha < tbPesquisar.getRowCount(); linha++) {
            String nomeTabela = String.valueOf(tbPesquisar.getValueAt(linha, 1));
            if (nomeTabela.toLowerCase().startsWith(nome.toLowerCase())) {
                tbPesquisar.setRowSelectionInterval(linha, linha);
                JViewport viewport = (JViewport) tbPesquisar.getParent();
                Rectangle rect = tbPesquisar.getCellRect(linha, 1, true);
                Point pt = viewport.getViewPosition();
                rect.setLocation(rect.x - pt.x, rect.y - pt.y);
                viewport.scrollRectToVisible(rect);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    
    public void atualizarTabela(){
        List<Supervisor> lista;
        lista = dao.listar();
        SupervisorTableModel itm = new SupervisorTableModel(lista);
        tbPesquisar.setModel(itm);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPesquisar = new javax.swing.JTable();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Pesquisar");

        tbPesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbPesquisarFocusGained(evt);
            }
        });
        tbPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPesquisarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPesquisar);

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExcluir)
                        .addGap(94, 94, 94)
                        .addComponent(btEditar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btExcluir)
                    .addComponent(btVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        int row = tbPesquisar.getSelectedRow();
        if (row > -1) {
            o = tbPesquisar.getValueAt(row, 0);
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione o Ítem!",
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    
    
    
    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linha = tbPesquisar.getSelectedRow();
        Object idValorSelecionado = tbPesquisar.getValueAt(linha, 0);
        if (linha == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione alguma linha!");
        } else if (JOptionPane.showConfirmDialog(rootPane, "Seja realmente excluir este supervisor?",
                "Excluir?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            supervisor = dao.carregarObjetoDoBanco("id", idValorSelecionado);
            dao.remover(supervisor);
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Supervisor não excluído.");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tbPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbPesquisarFocusGained
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_tbPesquisarFocusGained

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
       o = null;
       dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tbPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPesquisarMouseClicked
       if (evt.getClickCount() == 2) {
            btEditarActionPerformed(null);
        }
    }//GEN-LAST:event_tbPesquisarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesqSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesqSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesqSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesqSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PesqSupervisor dialog = new PesqSupervisor();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPesquisar;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables
}
