/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgst.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyValue;
import javafx.animation.KeyValue.Type;
import static javafx.animation.KeyValue.Type.INTEGER;
import sisgst.modelo.Agenda;
import sisgst.modelo.Colaborador;
import sisgst.modelo.Equipe;
import sisgst.view.telaAgenda;

/**
 *
 * @author Cristian
 */
public class AgendaDao extends ConnectionFactory {

    private Connection con;

    public AgendaDao() {
        this.con = this.getConnection();
    }

    public void inserir(Agenda Ag) throws SQLException {
        String sql = "insert into agenda (dataCriacaoAgenda, dataCompromissoAgenda, tituloAgenda, descricaoAgenda, codigoColaboradorAgenda, codigoEquipeAgenda)values(now(), ?, ?, ?, ?, ?)";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, Ag.getDataCompromissoAgenda());
            st.setString(2, Ag.getTituloAgenda());
            st.setString(3, Ag.getDescricaoAgenda());

            int codigoAgendaColaborador = Ag.getCodigoColaboradorAgenda();
            if (codigoAgendaColaborador == 0) {
                st.setNull(4, java.sql.Types.INTEGER);
            }else{
            st.setInt(4, Ag.getCodigoColaboradorAgenda());
            }
            
            int codigoAgendaEquipe = Ag.getCodigoEquipeAgenda();
            if (codigoAgendaEquipe == 0) {
                st.setNull(5, java.sql.Types.INTEGER);
            }else{
            st.setInt(5, Ag.getCodigoEquipeAgenda());
            }

            st.execute();
            st.close();
        }
        this.con.close();

    }

    public List<Equipe> listarEquipeCombo() throws SQLException {
        String sql = "select * from equipe";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            List<Equipe> Equipe = new ArrayList<Equipe>();

            while (rs.next()) {
                Equipe e = new Equipe();
                e.setIdEquipe(rs.getInt("idEquipe"));
                e.setNomeEquipe(rs.getString("nomeEquipe"));

                Equipe.add(e);
            }
            rs.close();
            st.close();
            this.con.close();
            return Equipe;
        }
    }

    public List<Colaborador> listarColaboradorCombo() throws SQLException {
        String sql = "select * from colaborador";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            List<Colaborador> Colaborador = new ArrayList<Colaborador>();

            while (rs.next()) {
                Colaborador co = new Colaborador();
                co.setIdColaborador(rs.getInt("idColaborador"));
                co.setNomeColaborador(rs.getString("nomeColaborador"));

                Colaborador.add(co);
            }
            rs.close();
            st.close();
            this.con.close();
            return Colaborador;
        }
    }

}
