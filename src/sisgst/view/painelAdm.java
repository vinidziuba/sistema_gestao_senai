/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgst.view;

import sisgst.modelo.Colaborador;

/**
 *
 * @author Cristian
 */
public class painelAdm extends javax.swing.JPanel {
    private Colaborador co;
    /**
     * Creates new form painelAdm
     */
    public painelAdm(Colaborador co) {
        initComponents();
        this.co = co;
        labelAdm.setText("Bem-Vindo " +co.getNomeColaborador());
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAdm = new javax.swing.JLabel();

        labelAdm.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        labelAdm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAdm.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(labelAdm)
                .addContainerGap(141, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelAdm;
    // End of variables declaration//GEN-END:variables
}
