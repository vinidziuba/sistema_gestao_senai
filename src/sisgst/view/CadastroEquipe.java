/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgst.view;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sisgst.dao.ColaboradorDao;
import sisgst.modelo.Colaborador;
import sisgst.dao.EquipeDao;
import sisgst.modelo.Equipe;

/**
 *
 * @author Cristian
 */
public class CadastroEquipe extends javax.swing.JPanel {

    /**
     * Creates new form CadastroEquipe
     */
    public CadastroEquipe() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCadastroEquipes = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        cpNome = new javax.swing.JTextField();
        cpDescricao = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();

        labelCadastroEquipes.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        labelCadastroEquipes.setText("CADASTRO DE EQUIPES");

        labelNome.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        labelNome.setText("NOME:");

        labelDescricao.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        labelDescricao.setText("DESCRIÇÃO:");

        cpNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cpNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpNomeActionPerformed(evt);
            }
        });

        cpDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cpDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpDescricaoActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelCadastroEquipes)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadastrar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addGap(18, 18, 18)
                        .addComponent(cpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelCadastroEquipes)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(cpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescricao)
                    .addComponent(cpDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnCadastrar)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cpNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpNomeActionPerformed
        
    }//GEN-LAST:event_cpNomeActionPerformed

    private void cpDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpDescricaoActionPerformed
        
    }//GEN-LAST:event_cpDescricaoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(ValidarDados()){
        Equipe eq = new Equipe();
        eq.setNomeEquipe(cpNome.getText());
        eq.setDescricaoEquipe(cpDescricao.getText());
        
        EquipeDao equiDao = new EquipeDao();
        
        try {
            equiDao.inserir(eq);
            
            
            JOptionPane.showMessageDialog(null, "Equipe inserida com sucesso !");
            
            this.cpDescricao.setText("");
            this.cpNome.setText("");
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao inserir equipe !");
            Logger.getLogger(CadastroColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }   }
    }//GEN-LAST:event_btnCadastrarActionPerformed
private boolean ValidarDados() {
       

       try {

           String Nome = cpNome.getText();
           String Idade = cpDescricao.getText();
           

           if (Nome.isEmpty() || Nome.trim().equals("")) {
               JOptionPane.showMessageDialog(null, "DIGITE UM NOME VÁLIDO!");
               return false;
           } else if (Idade.isEmpty() || Idade.trim().equals("")) {
               JOptionPane.showMessageDialog(null, "DEFINA UMA DESCRIÇÃO");
               return false;
           } 
       } catch (InvalidStateException e) { 

           return false;
       }
       return true;
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JTextField cpDescricao;
    private javax.swing.JTextField cpNome;
    private javax.swing.JLabel labelCadastroEquipes;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelNome;
    // End of variables declaration//GEN-END:variables
}
