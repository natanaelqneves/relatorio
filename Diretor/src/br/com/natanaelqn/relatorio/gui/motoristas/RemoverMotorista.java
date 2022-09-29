package br.com.natanaelqn.relatorio.gui.motoristas;

import br.com.natanaelqn.relatorio.dao.MotoristaDAO;
import br.com.natanaelqn.relatorio.entity.Motorista;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RemoverMotorista extends javax.swing.JFrame {

    public RemoverMotorista() throws ParseException {
        initComponents();
        atualizaMotoristas();
    }

    private void atualizaMotoristas() throws ParseException {
        String[] camposMotorista = {"Id", "Matricula", "Nome,"};
        List<Motorista> motoristas = MotoristaDAO.selecionarTodos();
        String[][] dadosMotoristas;
        dadosMotoristas = new String[motoristas.size()][3];
        int posicao = 0;
        for (Motorista motorista : motoristas) {
            String[] umMotorista = new String[3];
            umMotorista[0] = String.valueOf(motorista.getId());
            umMotorista[1] = motorista.getMatricula();
            umMotorista[2] = motorista.getNome();
            dadosMotoristas[posicao++] = umMotorista;
        }
        DefaultTableModel modeloMotorista = new DefaultTableModel(
                dadosMotoristas, camposMotorista);
        tMotoristas.setModel(modeloMotorista);
    }

    private void selecionaMotorista() {
        int selecionado = tMotoristas.getSelectedRow();
        if (selecionado >= 0) {
            String idString = (String) tMotoristas.getValueAt(
                    selecionado, 0);
        }
    }

    public Motorista motoristaSelecionado() {
        Motorista motorista = null;
        int id = 0;
        int selecionado = tMotoristas.getSelectedRow();
        if (selecionado >= 0) {
            String idString = (String) tMotoristas.getValueAt(
                    selecionado, 0);
            id = Integer.parseInt(idString);
        }
        motorista = MotoristaDAO.selecionarMotoristaPorId(id);
        return motorista;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpRemoverVeiculo = new javax.swing.JPanel();
        jRemover = new javax.swing.JButton();
        jCancelarRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMotoristas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(415, 419));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jRemover.setText("Remover");
        jRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverActionPerformed(evt);
            }
        });

        jCancelarRemover.setText("Calcelar");
        jCancelarRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarRemoverActionPerformed(evt);
            }
        });

        tMotoristas.setModel(new javax.swing.table.DefaultTableModel(
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
        tMotoristas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMotoristasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tMotoristas);

        javax.swing.GroupLayout jpRemoverVeiculoLayout = new javax.swing.GroupLayout(jpRemoverVeiculo);
        jpRemoverVeiculo.setLayout(jpRemoverVeiculoLayout);
        jpRemoverVeiculoLayout.setHorizontalGroup(
            jpRemoverVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRemoverVeiculoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jpRemoverVeiculoLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCancelarRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpRemoverVeiculoLayout.setVerticalGroup(
            jpRemoverVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRemoverVeiculoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jpRemoverVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRemover)
                    .addComponent(jCancelarRemover))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Remover Motorista", jpRemoverVeiculo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCancelarRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarRemoverActionPerformed
        try {
            atualizaMotoristas();
            dispose();
        } catch (ParseException ex) {
            Logger.getLogger(RemoverMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCancelarRemoverActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        //Não implementado
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverActionPerformed
        try {
            Motorista motorista = motoristaSelecionado();
            MotoristaDAO.remover(motorista);
            atualizaMotoristas();
            JOptionPane.showMessageDialog(null, "Motorista " + motorista.getNome() + " removido!");
        } catch (ParseException ex) {
            Logger.getLogger(RemoverMotorista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRemoverActionPerformed

    private void tMotoristasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMotoristasMouseClicked
        selecionaMotorista();
    }//GEN-LAST:event_tMotoristasMouseClicked

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
            java.util.logging.Logger.getLogger(RemoverMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemoverMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemoverMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemoverMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RemoverMotorista().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(RemoverMotorista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCancelarRemover;
    private javax.swing.JButton jRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpRemoverVeiculo;
    private javax.swing.JTable tMotoristas;
    // End of variables declaration//GEN-END:variables
}
