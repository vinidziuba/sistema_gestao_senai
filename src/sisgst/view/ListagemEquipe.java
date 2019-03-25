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
    private int tbeq;

    public ListagemEquipe() {
        initComponents();

        this.add(painelListagemEquipe, "painelListagemEquipe");
        this.add(painelEditarEquipe, "painelEditarEquipe");

        this.cl = (CardLayout) this.getLayout();
        this.cl.show(this, "painelListagemEquipe");

        this.popularTabela();

    }

    private void popularTabela() {
        EquipeDao equidao = new EquipeDao();
        List<Equipe> ListaEquipe;

        try {

            ListaEquipe = equidao.listarEquipe();

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

    private void preencherCamposEdicao(int codigoEquipe) {
        EquipeDao eq = new EquipeDao();
        try {
            this.equipe = eq.getEquipe(codigoEquipe);
            this.cpNomeEdicao.setText(this.equipe.getNomeEquipe());
            this.cpDescricaoEdicao.setText(this.equipe.getDescricaoEquipe());

        } catch (SQLException ex) {
            Logger.getLogger(ListagemEquipe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparTabela() {
        ((DefaultTableModel) tabelaEquipe.getModel()).setNumRows(0);
        tabelaEquipe.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menPopUpEquipe = new javax.swing.JPopupMenu();
        menEditar = new javax.swing.JMenuItem();
        menExcluir = new javax.swing.JMenuItem();
        painelListagemEquipe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEquipe = new javax.swing.JTable();
        painelEditarEquipe = new javax.swing.JPanel();
        labelCadastroEquipes = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        cpNomeEdicao = new javax.swing.JTextField();
        cpDescricaoEdicao = new javax.swing.JTextField();
        btnCadastrarEditar = new javax.swing.JButton();

        menPopUpEquipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menPopUpEquipeMouseClicked(evt);
            }
        });

        menEditar.setText("Editar");
        menEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menEditarActionPerformed(evt);
            }
        });
        menPopUpEquipe.add(menEditar);

        menExcluir.setText("Excluir");
        menExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menExcluirActionPerformed(evt);
            }
        });
        menPopUpEquipe.add(menExcluir);

        setLayout(new java.awt.CardLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

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
        tabelaEquipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEquipeMouseClicked(evt);
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

        labelCadastroEquipes.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        labelCadastroEquipes.setText("Editar Equipes");

        labelNome.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        labelNome.setText("NOME:");

        labelDescricao.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        labelDescricao.setText("DESCRIÇÃO:");

        cpNomeEdicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cpNomeEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpNomeEdicaoActionPerformed(evt);
            }
        });

        cpDescricaoEdicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cpDescricaoEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpDescricaoEdicaoActionPerformed(evt);
            }
        });

        btnCadastrarEditar.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        btnCadastrarEditar.setText("Editar");
        btnCadastrarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelEditarEquipeLayout = new javax.swing.GroupLayout(painelEditarEquipe);
        painelEditarEquipe.setLayout(painelEditarEquipeLayout);
        painelEditarEquipeLayout.setHorizontalGroup(
            painelEditarEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEditarEquipeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelCadastroEquipes)
                .addGap(62, 62, 62))
            .addGroup(painelEditarEquipeLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(painelEditarEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadastrarEditar)
                    .addGroup(painelEditarEquipeLayout.createSequentialGroup()
                        .addComponent(labelDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpDescricaoEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelEditarEquipeLayout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addGap(18, 18, 18)
                        .addComponent(cpNomeEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelEditarEquipeLayout.setVerticalGroup(
            painelEditarEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEditarEquipeLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelCadastroEquipes)
                .addGap(51, 51, 51)
                .addGroup(painelEditarEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(cpNomeEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelEditarEquipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescricao)
                    .addComponent(cpDescricaoEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnCadastrarEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(painelEditarEquipe, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void cpNomeEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpNomeEdicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpNomeEdicaoActionPerformed

    private void cpDescricaoEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpDescricaoEdicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpDescricaoEdicaoActionPerformed

    private void btnCadastrarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEditarActionPerformed

        this.equipe.setNomeEquipe(cpNomeEdicao.getText());
        this.equipe.setDescricaoEquipe(cpDescricaoEdicao.getText());

        //Inseri o Equipe no banco de dados
        EquipeDao EquiDao = new EquipeDao();
        try {
            EquiDao.alterar(this.equipe);
            System.out.println(this.equipe);
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar cadastro!");
            Logger.getLogger(CadastroEquipe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastrarEditarActionPerformed

    private void menEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menEditarActionPerformed
        // TODO add your handling code here:
        int linha = tabelaEquipe.getSelectedRow();

        if (linha != -1) {
            String codigo = tabelaEquipe.getValueAt(linha, 0).toString();
            int codigoEquipe = Integer.parseInt(codigo);
            this.preencherCamposEdicao(codigoEquipe);
            this.cl.show(this, "painelEditarEquipe");
        }
    }//GEN-LAST:event_menEditarActionPerformed

    private void menExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menExcluirActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Sim", "Não"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Deseja realmente eliminar esta Equipe ?", "Atenção!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (opcaoSelecionada == 0) {
            Equipe Equi = new Equipe();
            Equi.setIdEquipe((int)tabelaEquipe.getValueAt(tabelaEquipe.getSelectedRow(), 0));
            
            EquipeDao eq = new EquipeDao();
            try {
                eq.eliminar(Equi.getIdEquipe());
                this.cl.show(this, "painelListagemEquipe");
            } catch (SQLException ex) {
                Logger.getLogger(ListagemEquipe.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_menExcluirActionPerformed

    private void menPopUpEquipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menPopUpEquipeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menPopUpEquipeMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tabelaEquipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEquipeMouseClicked
        // TODO add your handling code here:
        if ((evt.getModifiers() & evt.BUTTON3_MASK) != 0) {
            this.tbeq = tabelaEquipe.getSelectedRow();
            menPopUpEquipe.show(tabelaEquipe, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tabelaEquipeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarEditar;
    private javax.swing.JTextField cpDescricaoEdicao;
    private javax.swing.JTextField cpNomeEdicao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCadastroEquipes;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelNome;
    private javax.swing.JMenuItem menEditar;
    private javax.swing.JMenuItem menExcluir;
    private javax.swing.JPopupMenu menPopUpEquipe;
    private javax.swing.JPanel painelEditarEquipe;
    private javax.swing.JPanel painelListagemEquipe;
    private javax.swing.JTable tabelaEquipe;
    // End of variables declaration//GEN-END:variables
}
