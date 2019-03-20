/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgst.view;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sisgst.dao.ColaboradorDao;
import sisgst.dao.EquipeDao;
import sisgst.modelo.Colaborador;
import sisgst.modelo.Equipe;

/**
 *
 * @author Cristian
 */
public class ListagemEquipe extends javax.swing.JPanel {
 
    private CardLayout cl;
    private Equipe equipe;
     
    public ListagemEquipe() {
        initComponents();
        
        this.add(painelListagemEquipe, "painelListagemEquipe");
        this.cl = (CardLayout) this.getLayout();
        this.cl.show(this, "painelListagemEquipe");
       
        this.popularTabela();
        
        
    }private void popularTabela() {
            EquipeDao equidao = new EquipeDao();
        try {
            List<Equipe> ListaEquipe = equidao.listarEquipe();
            DefaultTableModel model = (DefaultTableModel) tabelaEquipe.getModel();
            List<Object> lista = new ArrayList<Object>();

            for (int i = 0; i < ListaEquipe.size(); i++) {
                Equipe e = ListaEquipe.get(i);
                lista.add(new Object[]{e.getIdEquipe(), e.getNomeEquipe(), e.getDescricaoEquipe()});
            }

            for (int idx = 0; idx < lista.size(); idx++) {
                model.addRow((Object[]) lista.get(idx));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar o banco de dados");
            Logger.getLogger(ListagemColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelListagemEquipe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEquipe = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        tabelaEquipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "DESCRIÇÃO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaEquipe);
        if (tabelaEquipe.getColumnModel().getColumnCount() > 0) {
            tabelaEquipe.getColumnModel().getColumn(0).setResizable(false);
            tabelaEquipe.getColumnModel().getColumn(1).setResizable(false);
            tabelaEquipe.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout painelListagemEquipeLayout = new javax.swing.GroupLayout(painelListagemEquipe);
        painelListagemEquipe.setLayout(painelListagemEquipeLayout);
        painelListagemEquipeLayout.setHorizontalGroup(
            painelListagemEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        painelListagemEquipeLayout.setVerticalGroup(
            painelListagemEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        add(painelListagemEquipe, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelListagemEquipe;
    private javax.swing.JTable tabelaEquipe;
    // End of variables declaration//GEN-END:variables
}
