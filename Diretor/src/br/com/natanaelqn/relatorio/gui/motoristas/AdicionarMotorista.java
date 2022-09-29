package br.com.natanaelqn.relatorio.gui.motoristas;

import br.com.natanaelqn.relatorio.dao.MotoristaDAO;
import br.com.natanaelqn.relatorio.entity.Motorista;
import javax.swing.JOptionPane;

public class AdicionarMotorista extends javax.swing.JFrame {

    public AdicionarMotorista() {
        initComponents();
    }

    private void limpaDados() {
        tMatricula.setText("");
        tNome.setText("");
        tLogin.setText("");
        tSenha.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpInserirVeiculo = new javax.swing.JPanel();
        jCarro = new javax.swing.JLabel();
        jMarca = new javax.swing.JLabel();
        tNome = new javax.swing.JTextField();
        tLogin = new javax.swing.JTextField();
        jModelo = new javax.swing.JLabel();
        jAvariado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSalvarInserir = new javax.swing.JButton();
        jCancelarInserir = new javax.swing.JButton();
        tMatricula = new javax.swing.JTextField();
        tSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jCarro.setText("Matricula");

        jMarca.setText("Nome");

        jModelo.setText("Login");

        jAvariado.setText("Senha");

        jLabel1.setText("Novo Veiculo");

        jSalvarInserir.setText("Salvar");
        jSalvarInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarInserirActionPerformed(evt);
            }
        });

        jCancelarInserir.setText("Cancelar");
        jCancelarInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpInserirVeiculoLayout = new javax.swing.GroupLayout(jpInserirVeiculo);
        jpInserirVeiculo.setLayout(jpInserirVeiculoLayout);
        jpInserirVeiculoLayout.setHorizontalGroup(
            jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCarro)
                                    .addComponent(tMatricula)
                                    .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jMarca))
                                    .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jAvariado)
                                            .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jModelo)
                            .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jSalvarInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCancelarInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jpInserirVeiculoLayout.setVerticalGroup(
            jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCarro)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInserirVeiculoLayout.createSequentialGroup()
                        .addComponent(jMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModelo)
                    .addComponent(jAvariado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSalvarInserir)
                    .addComponent(jCancelarInserir))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inserir Veiculo", jpInserirVeiculo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCancelarInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarInserirActionPerformed
        dispose();
    }//GEN-LAST:event_jCancelarInserirActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        //Não implementado
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jSalvarInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarInserirActionPerformed
        try {
            String matricula = tMatricula.getText();
            String nome = tNome.getText();
            String usuario = tLogin.getText();
            String senha = tSenha.getText();
            Motorista motorista = new Motorista(matricula, nome, usuario, senha);
            MotoristaDAO.inserir(motorista);
            JOptionPane.showMessageDialog(null, "Motorista " + motorista.getNome() + " adicionado!");
            limpaDados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não adicionado!");
        }
    }//GEN-LAST:event_jSalvarInserirActionPerformed

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
            java.util.logging.Logger.getLogger(AdicionarMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarMotorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarMotorista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAvariado;
    private javax.swing.JButton jCancelarInserir;
    private javax.swing.JLabel jCarro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jMarca;
    private javax.swing.JLabel jModelo;
    private javax.swing.JButton jSalvarInserir;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpInserirVeiculo;
    private javax.swing.JTextField tLogin;
    private javax.swing.JTextField tMatricula;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tSenha;
    // End of variables declaration//GEN-END:variables
}
