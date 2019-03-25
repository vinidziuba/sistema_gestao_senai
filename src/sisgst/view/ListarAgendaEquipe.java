/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgst.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sisgst.dao.AgendaDao;
import sisgst.dao.ColaboradorDao;
import sisgst.modelo.Agenda;
import sisgst.modelo.Colaborador;
import sisgst.modelo.Equipe;
import sisgst.principal.Principal;

/**
 *
 * @author Aluno
 */
public class ListarAgendaEquipe extends javax.swing.JPanel {

    private boolean radioAux = true;
    private List<Equipe> listaEquipe;
    private int linha;
    private List<Colaborador> listaColaborador;

    /**
     * Creates new form ListarAgenda
     */
    
    private int codigoColaborador;
    
    public ListarAgendaEquipe(int codigoEquipe) throws SQLException {
        
        initComponents();
        
        this.codigoColaborador= codigoEquipe;
        popularTabelaColaborador();
    }

    private void popularTabelaColaborador() throws SQLException {
        AgendaDao Ag = new AgendaDao();
        List<Agenda> listaAgenda = Ag.listarAgendaEquipe(this.codigoColaborador);
        DefaultTableModel model = (DefaultTableModel) tabelaAgenda.getModel();
        List<Object> lista = new ArrayList<Object>();
        for (int i = 0; i < listaAgenda.size(); i++) {
            Agenda g = listaAgenda.get(i);
            lista.add(new Object[]{g.getCodigoEquipeAgenda(), g.getDataCompromissoAgenda(), g.getDataCriacaoAgenda(),g.getTituloAgenda(), g.getDescricaoAgenda() });
        }
        
        
        
        for (int idx = 0; idx < lista.size(); idx++) {
            model.addRow((Object[]) lista.get(idx));
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelListagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAgenda = new javax.swing.JTable();
        editarTarefa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dataAgenda = new javax.swing.JFormattedTextField();
        tituloAgenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricaoAgenda = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        botaoCadastrarTarefa = new javax.swing.JButton();
        comboEquipe = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboColaborador = new javax.swing.JComboBox<>();
        radioEquipe = new javax.swing.JRadioButton();
        radioColaborador = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabelaAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Equipe", "Data Criação", "Data Compromisso", "Titulo Tarefa", "Descrição Tarefa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAgenda);

        javax.swing.GroupLayout painelListagemLayout = new javax.swing.GroupLayout(painelListagem);
        painelListagem.setLayout(painelListagemLayout);
        painelListagemLayout.setHorizontalGroup(
            painelListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );
        painelListagemLayout.setVerticalGroup(
            painelListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        add(painelListagem, "card2");

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel1.setText("      AGENDA");

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel2.setText("Data do compromisso");

        try {
            dataAgenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel4.setText("Titulo Tarefa");

        descricaoAgenda.setColumns(20);
        descricaoAgenda.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        descricaoAgenda.setRows(5);
        jScrollPane2.setViewportView(descricaoAgenda);

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel3.setText("Descrição Tarefa");

        botaoCadastrarTarefa.setText("Cadastrar Tarefa");
        botaoCadastrarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarTarefaActionPerformed(evt);
            }
        });

        comboEquipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        comboEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEquipeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel5.setText("Selecione a Equipe");

        comboColaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        comboColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColaboradorActionPerformed(evt);
            }
        });

        radioEquipe.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioEquipeStateChanged(evt);
            }
        });
        radioEquipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioEquipeMouseClicked(evt);
            }
        });
        radioEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEquipeActionPerformed(evt);
            }
        });

        radioColaborador.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioColaboradorStateChanged(evt);
            }
        });
        radioColaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioColaboradorMouseClicked(evt);
            }
        });
        radioColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioColaboradorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jLabel6.setText("Selecione o Colaborador");

        javax.swing.GroupLayout editarTarefaLayout = new javax.swing.GroupLayout(editarTarefa);
        editarTarefa.setLayout(editarTarefaLayout);
        editarTarefaLayout.setHorizontalGroup(
            editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarTarefaLayout.createSequentialGroup()
                .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarTarefaLayout.createSequentialGroup()
                        .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(editarTarefaLayout.createSequentialGroup()
                                .addGap(323, 323, 323)
                                .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editarTarefaLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editarTarefaLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(editarTarefaLayout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botaoCadastrarTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)))))
                        .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioEquipe)
                            .addComponent(radioColaborador)))
                    .addGroup(editarTarefaLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(dataAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(editarTarefaLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(tituloAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editarTarefaLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        editarTarefaLayout.setVerticalGroup(
            editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarTarefaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarTarefaLayout.createSequentialGroup()
                        .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editarTarefaLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(comboEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editarTarefaLayout.createSequentialGroup()
                                .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarTarefaLayout.createSequentialGroup()
                        .addComponent(radioEquipe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tituloAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(radioColaborador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarTarefaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editarTarefaLayout.createSequentialGroup()
                        .addComponent(botaoCadastrarTarefa)
                        .addContainerGap())
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(editarTarefa, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendaMouseClicked
        if ((evt.getModifiers() & evt.BUTTON3_MASK) != 0) {
            this.linha = tabelaAgenda.getSelectedRow();
           // opcaoMenu.show(tabelaAgenda, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tabelaAgendaMouseClicked
    private void limparTabela() {
        ((DefaultTableModel) tabelaAgenda.getModel()).setNumRows(0);
        tabelaAgenda.updateUI();
    }
    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void botaoCadastrarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarTarefaActionPerformed
        Agenda A = new Agenda();
        A.setDataCompromissoAgenda(dataAgenda.getText());
        A.setTituloAgenda(tituloAgenda.getText());
        A.setDescricaoAgenda(descricaoAgenda.getText());

        if (this.radioColaborador.isSelected() == radioAux) {
            Equipe e = this.listaEquipe.get(comboEquipe.getSelectedIndex());
            A.setCodigoEquipeAgenda(0);
        } else {
            Equipe e = this.listaEquipe.get(comboEquipe.getSelectedIndex());
            A.setCodigoEquipeAgenda(e.getIdEquipe());
        }

        if (this.radioEquipe.isSelected() == radioAux) {
            Colaborador co = this.listaColaborador.get(comboColaborador.getSelectedIndex());
            A.setCodigoColaboradorAgenda(0);
        } else {
            Colaborador co = this.listaColaborador.get(comboColaborador.getSelectedIndex());
            A.setCodigoColaboradorAgenda(co.getIdColaborador());
        }

        AgendaDao Ag = new AgendaDao();
        try {
            Ag.inserir(A);
            JOptionPane.showMessageDialog(null, "Tarefa inserida com sucesso !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao inserir tarefa !");
            Logger.getLogger(CadastroColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoCadastrarTarefaActionPerformed

    private void comboEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEquipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEquipeActionPerformed

    private void comboColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColaboradorActionPerformed

    }//GEN-LAST:event_comboColaboradorActionPerformed

    private void radioEquipeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioEquipeStateChanged

        if (radioEquipe.isSelected() == radioAux) {
            this.comboColaborador.setEnabled(false);
            this.comboEquipe.setEnabled(true);
        }
    }//GEN-LAST:event_radioEquipeStateChanged

    private void radioEquipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioEquipeMouseClicked

    }//GEN-LAST:event_radioEquipeMouseClicked

    private void radioEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEquipeActionPerformed

    }//GEN-LAST:event_radioEquipeActionPerformed

    private void radioColaboradorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioColaboradorStateChanged

        if (radioColaborador.isSelected() == radioAux) {
            this.comboEquipe.setEnabled(false);
            this.comboColaborador.setEnabled(true);
        }
    }//GEN-LAST:event_radioColaboradorStateChanged

    private void radioColaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioColaboradorMouseClicked

    }//GEN-LAST:event_radioColaboradorMouseClicked

    private void radioColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioColaboradorActionPerformed

    }//GEN-LAST:event_radioColaboradorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrarTarefa;
    private javax.swing.JComboBox<String> comboColaborador;
    private javax.swing.JComboBox<String> comboEquipe;
    private javax.swing.JFormattedTextField dataAgenda;
    private javax.swing.JTextArea descricaoAgenda;
    private javax.swing.JPanel editarTarefa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelListagem;
    private javax.swing.JRadioButton radioColaborador;
    private javax.swing.JRadioButton radioEquipe;
    private javax.swing.JTable tabelaAgenda;
    private javax.swing.JTextField tituloAgenda;
    // End of variables declaration//GEN-END:variables
}