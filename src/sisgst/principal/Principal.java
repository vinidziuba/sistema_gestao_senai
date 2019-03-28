/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgst.principal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import sisgst.dao.ColaboradorDao;
import sisgst.modelo.Colaborador;
import sisgst.view.CadastroColaborador;
import sisgst.view.CadastroEquipe;
import sisgst.view.ListagemColaborador;
import sisgst.view.ListagemEquipe;
import sisgst.view.ListarAgenda;
import sisgst.view.ListarAgendaEquipe;

import sisgst.view.PainelAmarelo;
import sisgst.view.painelAdm;
import sisgst.view.painelColaborador;
import sisgst.view.telaAgenda;

/**
 *
 * @author Dziuba
 */
public class Principal extends javax.swing.JFrame {
    
    private Colaborador co;
    
    
    public Principal() throws SQLException {
        initComponents();

        PainelAmarelo Amarelo = new PainelAmarelo();
        ListagemColaborador listaCo = new ListagemColaborador();
        ListagemEquipe listaEqui = new ListagemEquipe();
        CadastroColaborador cadastroCo = new CadastroColaborador();
        CadastroEquipe cadastroEqui = new CadastroEquipe();
        painelColaborador pCol = new painelColaborador();
   
       
        
        

        PainelPrincipal.add(Amarelo, "amarelo");
        PainelPrincipal.add(listaCo, "listaCo");
        
        PainelPrincipal.add(cadastroCo, "cadastroCo");
        PainelPrincipal.add(cadastroEqui, "cadastroEqui");
        PainelPrincipal.add(viewLogin, "Login");
        PainelPrincipal.add(pCol, "TelaCol");

        PainelPrincipal.add(listaCo, "edicaoCo");
      
  
        

        this.DesabilitarMenus();
    }

    private void DesabilitarMenus() {

        menColaborador.setEnabled(false);
        menEquipe.setEnabled(false);
        menAgenda.setEnabled(false);


    }

    private void HabilitarMenus() {
        menColaborador.setEnabled(true);
        menEquipe.setEnabled(true);
        menAgenda.setEnabled(true);
    }
    
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PainelPrincipal = new javax.swing.JPanel();
        TelaInicial = new javax.swing.JPanel();
        viewLogin = new javax.swing.JPanel();
        loginCo = new sisgst.principal.JTextFieldHint(new JTextField(), "user-icon", "Nome de Uusário");
        ;
        senhaCo = new JPassWordFieldHint(new JPasswordField(), "padlock", "Senha");
        ;
        botaoLogar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menColaborador = new javax.swing.JMenu();
        ListarColaborador = new javax.swing.JMenuItem();
        CadastrarColaborador = new javax.swing.JMenuItem();
        menEquipe = new javax.swing.JMenu();
        CadastrarEquipe = new javax.swing.JMenuItem();
        ListarEquipe = new javax.swing.JMenuItem();
        menAgenda = new javax.swing.JMenu();
        menuColaborador = new javax.swing.JMenu();
        AgendaColaborador = new javax.swing.JMenuItem();
        AgendaEquipe = new javax.swing.JMenuItem();
        menuEquipe = new javax.swing.JMenu();
        listaTarefaEquipe = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(430, 500));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 410));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        PainelPrincipal.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                PainelPrincipalComponentAdded(evt);
            }
        });
        PainelPrincipal.setLayout(new java.awt.CardLayout());

        TelaInicial.setLayout(new java.awt.CardLayout());
        PainelPrincipal.add(TelaInicial, "card3");

        viewLogin.setBackground(new java.awt.Color(255, 255, 255));
        viewLogin.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                viewLoginComponentAdded(evt);
            }
        });

        loginCo.setToolTipText("");
        loginCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginCoActionPerformed(evt);
            }
        });

        senhaCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaCoActionPerformed(evt);
            }
        });
        senhaCo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaCoKeyPressed(evt);
            }
        });

        botaoLogar.setBackground(new java.awt.Color(58, 65, 84));
        botaoLogar.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        botaoLogar.setForeground(new java.awt.Color(255, 255, 255));
        botaoLogar.setText("LOGAR");
        botaoLogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoLogarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoLogarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoLogarMouseExited(evt);
            }
        });
        botaoLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLogarActionPerformed(evt);
            }
        });
        botaoLogar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoLogarKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(27, 187, 125));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login de acesso");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(87, 87, 87))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("  Entre com suas credênciais");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        botaoSair.setBackground(new java.awt.Color(217, 81, 51));
        botaoSair.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        botaoSair.setText("SAIR");
        botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoSairMouseExited(evt);
            }
        });
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewLoginLayout = new javax.swing.GroupLayout(viewLogin);
        viewLogin.setLayout(viewLoginLayout);
        viewLoginLayout.setHorizontalGroup(
            viewLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(viewLoginLayout.createSequentialGroup()
                .addGroup(viewLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewLoginLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(viewLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(senhaCo)
                            .addComponent(botaoLogar, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addComponent(loginCo)
                            .addComponent(botaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(viewLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        viewLoginLayout.setVerticalGroup(
            viewLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLoginLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(loginCo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(senhaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(botaoLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        PainelPrincipal.add(viewLogin, "card2");

        menColaborador.setText("Colaborador");
        menColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menColaboradorActionPerformed(evt);
            }
        });

        ListarColaborador.setText("Listar");
        ListarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarColaboradorActionPerformed(evt);
            }
        });
        menColaborador.add(ListarColaborador);

        CadastrarColaborador.setText("Cadastrar");
        CadastrarColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarColaboradorActionPerformed(evt);
            }
        });
        menColaborador.add(CadastrarColaborador);

        jMenuBar1.add(menColaborador);

        menEquipe.setText("Equipe");

        CadastrarEquipe.setText("Cadastrar");
        CadastrarEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarEquipeActionPerformed(evt);
            }
        });
        menEquipe.add(CadastrarEquipe);

        ListarEquipe.setText("Listar");
        ListarEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarEquipeActionPerformed(evt);
            }
        });
        menEquipe.add(ListarEquipe);

        jMenuBar1.add(menEquipe);

        menAgenda.setText("Tarefas");

        menuColaborador.setText("Colaborador");

        AgendaColaborador.setText("Listar Tarefas");
        AgendaColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaColaboradorActionPerformed(evt);
            }
        });
        menuColaborador.add(AgendaColaborador);

        AgendaEquipe.setText("Cadastrar Tarefa");
        AgendaEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaEquipeActionPerformed(evt);
            }
        });
        menuColaborador.add(AgendaEquipe);

        menAgenda.add(menuColaborador);

        menuEquipe.setText("Equipe");

        listaTarefaEquipe.setText("Listar Tarefas");
        listaTarefaEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaTarefaEquipeActionPerformed(evt);
            }
        });
        menuEquipe.add(listaTarefaEquipe);

        menAgenda.add(menuEquipe);

        jMenuBar1.add(menAgenda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(445, 409));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void PainelPrincipalComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_PainelPrincipalComponentAdded
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
        cl.show(PainelPrincipal, "Login");
    }//GEN-LAST:event_PainelPrincipalComponentAdded

    int tentativaLogin = 4;

    private void botaoLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLogarActionPerformed

        ColaboradorDao CoDao = new ColaboradorDao();

        try {
            if (tentativaLogin > 0 && CoDao.checkLogin(loginCo.getText(), senhaCo.getText())) {
                ColaboradorDao CoDao2 = new ColaboradorDao();
                Colaborador valida = CoDao2.getColaborador(loginCo.getText(), senhaCo.getText());
                String tipoColaborador = valida.getTipoColaborador();
                ColaboradorDao CoDao3 = new ColaboradorDao();
                CoDao3.UltimoAcesso(co.getIdColaborador());
                this.HabilitarMenus();

                if (tentativaLogin > 0 && tipoColaborador.equals("Colaborador")) {
                    CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
                    cl.show(PainelPrincipal, "TelaCol");
                    menColaborador.setEnabled(false);
                    menEquipe.setEnabled(false);

                } else {
                    CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
                    cl.show(PainelPrincipal, "TelaAdm");

                }

                /// System.out.println(valida);
            } else {
                tentativaLogin--;
                JOptionPane.showMessageDialog(null, " Login ou Senha Incorretos");
                JOptionPane.showMessageDialog(null, "Tentativas restantes: " + tentativaLogin);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoLogarActionPerformed

    private void menColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menColaboradorActionPerformed
        // TODO add your handling code here:
        //ListagemColaborador co = new ListagemColaborador();
        //PainelPrincipal.add(co, "listaCo");
        //CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
        //cl.show(PainelPrincipal, "listaCo");

    }//GEN-LAST:event_menColaboradorActionPerformed

    private void ListarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarColaboradorActionPerformed
        // TODO add your handling code here:
        ListagemColaborador co = null;
        try {
            co = new ListagemColaborador();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelPrincipal.add(co, "listaCo");
        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
        cl.show(PainelPrincipal, "listaCo");
    }//GEN-LAST:event_ListarColaboradorActionPerformed

    private void CadastrarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarColaboradorActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
        cl.show(PainelPrincipal, "cadastroCo");
    }//GEN-LAST:event_CadastrarColaboradorActionPerformed

    private void viewLoginComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_viewLoginComponentAdded
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
        cl.show(PainelPrincipal, "Login");
    }//GEN-LAST:event_viewLoginComponentAdded

    private void CadastrarEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarEquipeActionPerformed
        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
        cl.show(PainelPrincipal, "cadastroEqui");
    }//GEN-LAST:event_CadastrarEquipeActionPerformed

    private void ListarEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarEquipeActionPerformed
        ListagemEquipe listaEqui = new ListagemEquipe();
        PainelPrincipal.add(listaEqui, "listaEquipe");
        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
        cl.show(PainelPrincipal, "listaEquipe");
    }//GEN-LAST:event_ListarEquipeActionPerformed

    private void AgendaColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaColaboradorActionPerformed
                ListarAgenda lAgenda;
        try {
            lAgenda = new ListarAgenda(this.co);
              PainelPrincipal.add(lAgenda, "lAgenda");
            CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
            cl.show(PainelPrincipal, "lAgenda");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_AgendaColaboradorActionPerformed
    public void pegarIdColaborador() {
        ColaboradorDao CoDao = new ColaboradorDao();

        try {
            if (CoDao.checkLogin(loginCo.getText(), senhaCo.getText())) {
                ColaboradorDao CoDao2 = new ColaboradorDao();
                Colaborador valida = CoDao2.getColaborador(loginCo.getText(), senhaCo.getText());
                String tipoColaborador = valida.getTipoColaborador();
                Colaborador co = new Colaborador();
                CoDao.getColaborador(co.getIdColaborador());
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void botaoLogarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoLogarKeyPressed


    }//GEN-LAST:event_botaoLogarKeyPressed

    private void loginCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginCoActionPerformed


    }//GEN-LAST:event_loginCoActionPerformed

    private void senhaCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaCoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaCoActionPerformed

    private void senhaCoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaCoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ColaboradorDao CoDao = new ColaboradorDao();

            try {
                if (tentativaLogin > 0 && CoDao.checkLogin(loginCo.getText(), senhaCo.getText())) {
                    ColaboradorDao CoDao2 = new ColaboradorDao();
                    Colaborador valida= this.co = CoDao2.getColaborador(loginCo.getText(), senhaCo.getText());
                    String tipoColaborador = valida.getTipoColaborador();
                     ColaboradorDao CoDao3 = new ColaboradorDao();
                     CoDao3.UltimoAcesso(co.getIdColaborador());
                    this.HabilitarMenus();

                    if (tentativaLogin > 0 && tipoColaborador.equals("Colaborador")) {
                        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
                        this.setExtendedState(MAXIMIZED_BOTH);
                        cl.show(PainelPrincipal, "TelaCol");
                        menColaborador.setEnabled(false);
                        menEquipe.setEnabled(false);

                    } else {
                        this.setExtendedState(MAXIMIZED_BOTH);
                        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
                        cl.show(PainelPrincipal, "TelaAdm");

                    }

                    /// System.out.println(valida);
                } else {
                    tentativaLogin--;
                    JOptionPane.showMessageDialog(null, " Login ou Senha Incorretos");
                    JOptionPane.showMessageDialog(null, "Tentativas restantes: " + tentativaLogin);
                }
                if (tentativaLogin == 0) {
                    JOptionPane.showMessageDialog(null, "Você errou muitas vezes a senha");
                    this.DesabilitarMenus();
                    loginCo.setEnabled(false);
                    senhaCo.setEnabled(false);
                    botaoLogar.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_senhaCoKeyPressed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoLogarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLogarMouseEntered
        botaoLogar.setBackground(new Color(235, 235, 235));
        botaoLogar.setForeground(new Color(58, 65, 84));
    }//GEN-LAST:event_botaoLogarMouseEntered

    private void botaoSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSairMouseEntered
        botaoSair.setBackground(new Color(235, 235, 235));
        botaoSair.setForeground(new Color(217, 81, 51));
    }//GEN-LAST:event_botaoSairMouseEntered

    private void botaoLogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLogarMouseClicked

    }//GEN-LAST:event_botaoLogarMouseClicked

    private void botaoLogarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLogarMouseExited
        botaoLogar.setBackground(new Color(58, 65, 84));
        botaoLogar.setForeground(Color.WHITE);
    }//GEN-LAST:event_botaoLogarMouseExited

    private void botaoSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSairMouseExited
        botaoSair.setBackground(new Color(217, 81, 51));
        botaoSair.setForeground(Color.WHITE);
    }//GEN-LAST:event_botaoSairMouseExited

    private void AgendaEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaEquipeActionPerformed
        telaAgenda tAgenda;
       
        try {
            tAgenda = new telaAgenda(this.co);
             PainelPrincipal.add(tAgenda, "tAgenda");
        CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
        cl.show(PainelPrincipal, "tAgenda");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_AgendaEquipeActionPerformed

    private void listaTarefaEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaTarefaEquipeActionPerformed
        ListarAgendaEquipe lAgendaEquipe;
        try {
            lAgendaEquipe = new ListarAgendaEquipe(co.getEquipeColabarador());
            PainelPrincipal.add(lAgendaEquipe, "lAgendaEquipe");
            CardLayout cl = (CardLayout) PainelPrincipal.getLayout();
            cl.show(PainelPrincipal, "lAgendaEquipe");
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
    }//GEN-LAST:event_listaTarefaEquipeActionPerformed

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
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaColaborador;
    private javax.swing.JMenuItem AgendaEquipe;
    private javax.swing.JMenuItem CadastrarColaborador;
    private javax.swing.JMenuItem CadastrarEquipe;
    private javax.swing.JMenuItem ListarColaborador;
    private javax.swing.JMenuItem ListarEquipe;
    private javax.swing.JPanel PainelPrincipal;
    private javax.swing.JPanel TelaInicial;
    private javax.swing.JButton botaoLogar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem listaTarefaEquipe;
    private javax.swing.JTextField loginCo;
    private javax.swing.JMenu menAgenda;
    private javax.swing.JMenu menColaborador;
    private javax.swing.JMenu menEquipe;
    private javax.swing.JMenu menuColaborador;
    private javax.swing.JMenu menuEquipe;
    private javax.swing.JTextField senhaCo;
    private javax.swing.JPanel viewLogin;
    // End of variables declaration//GEN-END:variables
}
