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

public class ListagemColaborador extends javax.swing.JPanel {

    private CardLayout cl;
    private Colaborador colaborador;
    private int linha;

    private List<Equipe> listaEquipe;
    public ListagemColaborador() throws SQLException {
        initComponents();

        ComboTipoColaborador.addItem("Gestor");
        ComboTipoColaborador.addItem("Colaborador");

        this.add(painelListagem, "painelListagem");
        this.add(painelEdicao, "painelEdicao");

        this.cl = (CardLayout) this.getLayout();
        this.cl.show(this, "painelListagem");

        EquipeDao equipe = new EquipeDao();
       
       
         this.listaEquipe = equipe.listarEquipeCombo();
            

            for (int i = 0; i < listaEquipe.size(); i++) {
                Equipe e = listaEquipe.get(i);
                comboEquipe.addItem(e.getNomeEquipe());
            }
        this.popularTabela();
    }

    private void popularTabela() {
        ColaboradorDao cl = new ColaboradorDao();
        try {
            List<Colaborador> listaColaborador = cl.listarColaborador();
            DefaultTableModel model = (DefaultTableModel) tabelaColaborador.getModel();
            List<Object> lista = new ArrayList<Object>();

            for (int i = 0; i < listaColaborador.size(); i++) {
                Colaborador c = listaColaborador.get(i);
                lista.add(new Object[]{c.getIdColaborador(), c.getNomeColaborador(), c.getIdadeColaborador(), c.getTipoColaborador(), c.getCpfColaborador(), c.getEmailColaborador(), c.getCelularColaborador(), c.getUsuarioColaborador(), c.getSenhaColaborador(), c.getEquipeColabarador(), c.getRuaColaborador(), c.getBairroColaborador(), c.getCidadeColaborador(), c.getComplementoColaborador(), c.getCepColaborador()});
            }

            for (int idx = 0; idx < lista.size(); idx++) {
                model.addRow((Object[]) lista.get(idx));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar o banco de dados");
            Logger.getLogger(ListagemColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherCamposEdicao(int idColaborador) {
        ColaboradorDao co = new ColaboradorDao();
        try {
            this.colaborador = co.getColaborador(idColaborador);
            this.cpNome.setText(this.colaborador.getNomeColaborador());
            this.cpIdade.setText(this.colaborador.getIdadeColaborador());
            this.ComboTipoColaborador.setSelectedItem(this.colaborador.getTipoColaborador());
            this.cpCPF.setText(this.colaborador.getCpfColaborador());
            this.cpEmail.setText(this.colaborador.getEmailColaborador());
            this.cpRua.setText(this.colaborador.getRuaColaborador());
            this.cpBairro.setText(this.colaborador.getBairroColaborador());
            this.cpComplemento.setText(this.colaborador.getComplementoColaborador());
            this.cpCidade.setText(this.colaborador.getCidadeColaborador());
            this.cpSenha.setText(this.colaborador.getSenhaColaborador());
            this.cpUsuario.setText(this.colaborador.getUsuarioColaborador());
            this.cpCelular.setText(this.colaborador.getCelularColaborador());
            this.cpCEP.setText(this.colaborador.getCepColaborador());
            this.comboEquipe.setSelectedItem(this.colaborador.getEquipeColabarador());

        } catch (SQLException ex) {
            Logger.getLogger(ListagemColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcaoMenu = new javax.swing.JPopupMenu();
        excluir = new javax.swing.JMenuItem();
        editar = new javax.swing.JMenuItem();
        painelListagem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaColaborador = new javax.swing.JTable();
        painelEdicao = new javax.swing.JPanel();
        LabeltipoColaborador = new javax.swing.JLabel();
        LabelCadastroColaborador = new javax.swing.JLabel();
        ComboTipoColaborador = new javax.swing.JComboBox<>();
        LabelNome = new javax.swing.JLabel();
        cpNome = new javax.swing.JTextField();
        LabelIdade = new javax.swing.JLabel();
        cpIdade = new javax.swing.JTextField();
        LabelCPF = new javax.swing.JLabel();
        LabelEmail = new javax.swing.JLabel();
        cpEmail = new javax.swing.JTextField();
        LabelCelular = new javax.swing.JLabel();
        cpCelular = new javax.swing.JFormattedTextField();
        cpCPF = new javax.swing.JFormattedTextField();
        LabelUsuario = new javax.swing.JLabel();
        LabelSenha = new javax.swing.JLabel();
        cpUsuario = new javax.swing.JTextField();
        cpSenha = new javax.swing.JTextField();
        LabelDadosColaborador = new javax.swing.JLabel();
        LabelEnderecoColaborador = new javax.swing.JLabel();
        LabelRua = new javax.swing.JLabel();
        LabelBairro = new javax.swing.JLabel();
        LabelCidade = new javax.swing.JLabel();
        LabelComplemento = new javax.swing.JLabel();
        cpRua = new javax.swing.JTextField();
        cpComplemento = new javax.swing.JTextField();
        cpBairro = new javax.swing.JTextField();
        cpCidade = new javax.swing.JTextField();
        LabelCEP = new javax.swing.JLabel();
        cpCEP = new javax.swing.JFormattedTextField();
        LabelEquipe = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        botaoEditar = new javax.swing.JButton();
        comboEquipe = new javax.swing.JComboBox<>();

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        opcaoMenu.add(excluir);

        editar.setText("Editar");
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMouseClicked(evt);
            }
        });
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        opcaoMenu.add(editar);

        setLayout(new java.awt.CardLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabelaColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Idade", "Tipo", "Cpf", "Email", "Celular", "Usuario", "Senha", "Equipe", "Rua", "Bairro", "Cidade", "Complemento", "Cep"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaColaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaColaboradorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaColaborador);
        if (tabelaColaborador.getColumnModel().getColumnCount() > 0) {
            tabelaColaborador.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout painelListagemLayout = new javax.swing.GroupLayout(painelListagem);
        painelListagem.setLayout(painelListagemLayout);
        painelListagemLayout.setHorizontalGroup(
            painelListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );
        painelListagemLayout.setVerticalGroup(
            painelListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        add(painelListagem, "card2");

        painelEdicao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                painelEdicaoComponentShown(evt);
            }
        });

        LabeltipoColaborador.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabeltipoColaborador.setText("Tipo do Colaborador:");

        LabelCadastroColaborador.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        LabelCadastroColaborador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCadastroColaborador.setText("Editar Colaborador");

        ComboTipoColaborador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Selecione"}));
        ComboTipoColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTipoColaboradorActionPerformed(evt);
            }
        });

        LabelNome.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelNome.setText("Nome:");

        cpNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpNomeActionPerformed(evt);
            }
        });

        LabelIdade.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelIdade.setText("Idade:");

        cpIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpIdadeActionPerformed(evt);
            }
        });

        LabelCPF.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelCPF.setText("CPF:");

        LabelEmail.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelEmail.setText("E-mail:");

        cpEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpEmailActionPerformed(evt);
            }
        });

        LabelCelular.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelCelular.setText("Celular:");

        try {
            cpCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cpCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpCPFActionPerformed(evt);
            }
        });

        LabelUsuario.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelUsuario.setText("Usuário:");

        LabelSenha.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelSenha.setText("Senha:");

        LabelDadosColaborador.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        LabelDadosColaborador.setText("Dados Colaborador:");

        LabelEnderecoColaborador.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        LabelEnderecoColaborador.setText("Endereço Colaborador:");

        LabelRua.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelRua.setText("Rua:");

        LabelBairro.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelBairro.setText("Bairro:");

        LabelCidade.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelCidade.setText("Cidade");

        LabelComplemento.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelComplemento.setText("Complemento:");

        LabelCEP.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelCEP.setText("CEP:");

        try {
            cpCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        LabelEquipe.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        LabelEquipe.setText("Equipe:");

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        comboEquipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a equipe" }));

        javax.swing.GroupLayout painelEdicaoLayout = new javax.swing.GroupLayout(painelEdicao);
        painelEdicao.setLayout(painelEdicaoLayout);
        painelEdicaoLayout.setHorizontalGroup(
            painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEdicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelCadastroColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEdicaoLayout.createSequentialGroup()
                        .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                .addComponent(LabelRua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelBairro)
                                    .addComponent(LabelCidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cpCidade)
                                    .addComponent(cpRua)
                                    .addComponent(cpBairro))
                                .addGap(64, 64, 64)))
                        .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                .addComponent(LabelCEP)
                                .addGap(85, 85, 85)
                                .addComponent(cpCEP))
                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                .addComponent(LabelComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cpComplemento))
                            .addComponent(botaoEditar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(painelEdicaoLayout.createSequentialGroup()
                        .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                .addComponent(LabelNome)
                                .addGap(18, 18, 18)
                                .addComponent(cpNome))
                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                .addComponent(LabeltipoColaborador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboTipoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 54, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEdicaoLayout.createSequentialGroup()
                                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelEdicaoLayout.createSequentialGroup()
                                        .addComponent(LabelEmail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cpEmail))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelEdicaoLayout.createSequentialGroup()
                                        .addComponent(LabelIdade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cpIdade)))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelEdicaoLayout.createSequentialGroup()
                                .addComponent(LabelCPF)
                                .addGap(25, 25, 25)
                                .addComponent(cpCPF)))
                        .addGap(18, 18, 18)
                        .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                .addComponent(LabelCelular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                            .addGroup(painelEdicaoLayout.createSequentialGroup()
                                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(LabelSenha))
                                    .addComponent(LabelEquipe))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEquipe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cpSenha)
                                    .addComponent(cpUsuario)))))
                    .addComponent(LabelDadosColaborador)
                    .addComponent(LabelEnderecoColaborador))
                .addContainerGap())
            .addComponent(jSeparator3)
            .addComponent(jSeparator1)
        );
        painelEdicaoLayout.setVerticalGroup(
            painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelEdicaoLayout.createSequentialGroup()
                .addComponent(LabelCadastroColaborador)
                .addGap(5, 5, 5)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelDadosColaborador)
                .addGap(18, 18, 18)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNome)
                    .addComponent(cpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCelular)
                    .addComponent(cpCelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelIdade)
                    .addComponent(cpIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelUsuario)
                    .addComponent(cpUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabeltipoColaborador)
                    .addComponent(ComboTipoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelSenha)
                    .addComponent(cpSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCPF)
                    .addComponent(cpCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelEquipe)
                    .addComponent(comboEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEmail)
                    .addComponent(cpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(LabelEnderecoColaborador)
                .addGap(18, 18, 18)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelRua)
                    .addComponent(cpRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelComplemento)
                    .addComponent(cpComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBairro)
                    .addComponent(cpBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCEP)
                    .addComponent(cpCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCidade)
                    .addComponent(cpCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoEditar))
                .addContainerGap())
        );

        add(painelEdicao, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tabelaColaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaColaboradorMouseClicked
        if ((evt.getModifiers() & evt.BUTTON3_MASK) != 0) {
            this.linha = tabelaColaborador.getSelectedRow();
            opcaoMenu.show(tabelaColaborador, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tabelaColaboradorMouseClicked

    private void ComboTipoColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipoColaboradorActionPerformed

    }//GEN-LAST:event_ComboTipoColaboradorActionPerformed

    private void cpNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpNomeActionPerformed

    private void cpIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpIdadeActionPerformed

    private void cpEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpEmailActionPerformed

    private void cpCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpCPFActionPerformed

    private void painelEdicaoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_painelEdicaoComponentShown

    }//GEN-LAST:event_painelEdicaoComponentShown

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:

        if (this.linha != -1) {
            String codigo = tabelaColaborador.getValueAt(linha, 0).toString();
            int codigoColaborador = Integer.parseInt(codigo);
            this.preencherCamposEdicao(codigoColaborador);
            this.cl.show(this, "painelEdicao");
        }
    }//GEN-LAST:event_editarActionPerformed

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editarMouseClicked
    private void limparTabela() {
        ((DefaultTableModel) tabelaColaborador.getModel()).setNumRows(0);
        tabelaColaborador.updateUI();
    }
    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        
        Object[] options = {"Sim", "Não"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Deseja realmente eliminar este colaborador ?", "Atenção!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (opcaoSelecionada == 0) {
        Colaborador co = new Colaborador();
        
        co.setIdColaborador((int)tabelaColaborador.getValueAt(tabelaColaborador.getSelectedRow(), 0));
        
        ColaboradorDao CoDao = new ColaboradorDao();
        try {
            CoDao.eliminar(co);
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir!");
            Logger.getLogger(CadastroColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        Colaborador co = new Colaborador();
        co.setNomeColaborador(cpNome.getText());
        co.setIdadeColaborador(cpIdade.getText());
        co.setTipoColaborador(ComboTipoColaborador.getSelectedItem().toString());
        co.setEmailColaborador(cpEmail.getText());
        co.setCelularColaborador(cpCelular.getText());
        co.setUsuarioColaborador(cpUsuario.getText());
        co.setSenhaColaborador(cpSenha.getText());
        Equipe e = this.listaEquipe.get(comboEquipe.getSelectedIndex());
        co.setEquipeColabarador(e.getIdEquipe());
        co.setRuaColaborador(cpRua.getText());
        co.setBairroColaborador(cpBairro.getText());
        co.setCidadeColaborador(cpCidade.getText());
        co.setComplementoColaborador(cpComplemento.getText());
        co.setCpfColaborador(cpCPF.getText());
        String cep = cpCEP.getText();
        cep = cep.replaceAll("[^0-9]", "");
        co.setCepColaborador((cep));
        co.setIdColaborador((int)tabelaColaborador.getValueAt(tabelaColaborador.getSelectedRow(), 0));
        
        ColaboradorDao CoDao = new ColaboradorDao(); 
        try {
            CoDao.alterar(co);
            JOptionPane.showMessageDialog(null, "Colaborador atualizado com sucesso !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar colaborador !");
            Logger.getLogger(CadastroColaborador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botaoEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTipoColaborador;
    private javax.swing.JLabel LabelBairro;
    private javax.swing.JLabel LabelCEP;
    private javax.swing.JLabel LabelCPF;
    private javax.swing.JLabel LabelCadastroColaborador;
    private javax.swing.JLabel LabelCelular;
    private javax.swing.JLabel LabelCidade;
    private javax.swing.JLabel LabelComplemento;
    private javax.swing.JLabel LabelDadosColaborador;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelEnderecoColaborador;
    private javax.swing.JLabel LabelEquipe;
    private javax.swing.JLabel LabelIdade;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelRua;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JLabel LabeltipoColaborador;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JComboBox<String> comboEquipe;
    private javax.swing.JTextField cpBairro;
    private javax.swing.JFormattedTextField cpCEP;
    private javax.swing.JFormattedTextField cpCPF;
    private javax.swing.JFormattedTextField cpCelular;
    private javax.swing.JTextField cpCidade;
    private javax.swing.JTextField cpComplemento;
    private javax.swing.JTextField cpEmail;
    private javax.swing.JTextField cpIdade;
    private javax.swing.JTextField cpNome;
    private javax.swing.JTextField cpRua;
    private javax.swing.JTextField cpSenha;
    private javax.swing.JTextField cpUsuario;
    private javax.swing.JMenuItem editar;
    private javax.swing.JMenuItem excluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu opcaoMenu;
    private javax.swing.JPanel painelEdicao;
    private javax.swing.JPanel painelListagem;
    private javax.swing.JTable tabelaColaborador;
    // End of variables declaration//GEN-END:variables

}
