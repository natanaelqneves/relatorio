package br.com.natanaelqn.relatorio.gui.carro;

import br.com.natanaelqn.relatorio.dao.CarroDAO;
import br.com.natanaelqn.relatorio.entity.Carro;
import javax.swing.JOptionPane;

public class AdicionarVeiculo extends javax.swing.JFrame {

    public AdicionarVeiculo() {
        initComponents();
    }

    private void limpaDados() {
        tPlacaInserir.setText("");
        tMarcaInserir.setText("");
        tModeloInserir.setText("");
        tKmAtualInserir.setText("");
        cAvadiadoInserir.setSelectedIndex(0);
        tAvariaInserir.setText("");
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
        jpInserirVeiculo = new javax.swing.JPanel();
        jCarro = new javax.swing.JLabel();
        jMarca = new javax.swing.JLabel();
        tMarcaInserir = new javax.swing.JTextField();
        tModeloInserir = new javax.swing.JTextField();
        jModelo = new javax.swing.JLabel();
        jAvariado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSalvarInserir = new javax.swing.JButton();
        jCancelarInserir = new javax.swing.JButton();
        tKmAtualInserir = new javax.swing.JTextField();
        jKmAtual = new javax.swing.JLabel();
        tPlacaInserir = new javax.swing.JTextField();
        cAvadiadoInserir = new javax.swing.JComboBox<>();
        lAvaria = new javax.swing.JLabel();
        tAvariaInserir = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jCarro.setText("Placa");

        jMarca.setText("Marca");

        jModelo.setText("Modelo");

        jAvariado.setText("Avariado");

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

        jKmAtual.setText("Km Atual");

        cAvadiadoInserir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N??O", "SIM" }));

        lAvaria.setText("Avaria");

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
                        .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCarro)
                                    .addComponent(tPlacaInserir)
                                    .addComponent(tModeloInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jMarca))
                                    .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jAvariado)
                                            .addComponent(tMarcaInserir)
                                            .addComponent(cAvadiadoInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jModelo)
                            .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jKmAtual)
                                    .addComponent(tKmAtualInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lAvaria)
                                    .addComponent(tAvariaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(tMarcaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPlacaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModelo)
                    .addComponent(jAvariado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                        .addGroup(jpInserirVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tModeloInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cAvadiadoInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jKmAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tKmAtualInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpInserirVeiculoLayout.createSequentialGroup()
                        .addComponent(lAvaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tAvariaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
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
        /*try {
            atualizaRelatoriosEnviados();
            atualizaRelatoriosRecebidos();
        } catch (ParseException ex) {
            Logger.getLogger(DiretorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jSalvarInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarInserirActionPerformed
        try {
            String placa = tPlacaInserir.getText();
            String marca = tMarcaInserir.getText();
            String modelo = tModeloInserir.getText();
            int kmAtual = Integer.parseInt(tKmAtualInserir.getText());
            String avariado = cAvadiadoInserir.getSelectedItem().toString();
            String avaria = tAvariaInserir.getText();
            Carro carro = new Carro(placa, marca, modelo, kmAtual, avariado, avaria);
            CarroDAO.inserir(carro);
            limpaDados();
            JOptionPane.showMessageDialog(null, "Carro " + carro.getModelo() + " adicionado!");
        } catch (Exception e) {
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
            java.util.logging.Logger.getLogger(AdicionarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cAvadiadoInserir;
    private javax.swing.JLabel jAvariado;
    private javax.swing.JButton jCancelarInserir;
    private javax.swing.JLabel jCarro;
    private javax.swing.JLabel jKmAtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jMarca;
    private javax.swing.JLabel jModelo;
    private javax.swing.JButton jSalvarInserir;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpInserirVeiculo;
    private javax.swing.JLabel lAvaria;
    private javax.swing.JTextField tAvariaInserir;
    private javax.swing.JTextField tKmAtualInserir;
    private javax.swing.JTextField tMarcaInserir;
    private javax.swing.JTextField tModeloInserir;
    private javax.swing.JTextField tPlacaInserir;
    // End of variables declaration//GEN-END:variables
}
