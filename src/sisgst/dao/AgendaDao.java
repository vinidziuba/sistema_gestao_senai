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
            } else {
                st.setInt(4, Ag.getCodigoColaboradorAgenda());
            }

            int codigoAgendaEquipe = Ag.getCodigoEquipeAgenda();
            if (codigoAgendaEquipe == 0) {
                st.setNull(5, java.sql.Types.INTEGER);
            } else {
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

    public List<Agenda> listarAgendaColaborador(int codigo) throws SQLException {
        String sql = "select * from agenda where codigoColaboradorAgenda = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codigo);
            ResultSet rs = st.executeQuery();
            List<Agenda> Agenda = new ArrayList<Agenda>();

            while (rs.next()) {
                Agenda a = new Agenda();
                a.setCodigoAgenda(rs.getInt("codigoTarefa"));
                a.setCodigoColaboradorAgenda(rs.getInt("codigoColaboradorAgenda"));
                a.setDataCompromissoAgenda(rs.getString("dataCompromissoAgenda"));
                a.setDataCriacaoAgenda(rs.getDate("dataCriacaoAgenda"));
                a.setTituloAgenda(rs.getString("tituloAgenda"));
                a.setDescricaoAgenda(rs.getString("descricaoAgenda"));

                Agenda.add(a);
            }
            rs.close();
            st.close();
            this.con.close();
            return Agenda;
        }
    }

    public List<Agenda> listarAgendaEquipe(int codigo) throws SQLException {
        String sql = "select * from agenda where codigoEquipeAgenda = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codigo);
            ResultSet rs = st.executeQuery();

            List<Agenda> Agenda = new ArrayList<Agenda>();

            while (rs.next()) {
                Agenda a = new Agenda();
                a.setCodigoAgenda(rs.getInt("codigoTarefa"));
                a.setCodigoEquipeAgenda(rs.getInt("codigoEquipeAgenda"));
                a.setDataCompromissoAgenda(rs.getString("dataCompromissoAgenda"));
                a.setDataCriacaoAgenda(rs.getDate("dataCriacaoAgenda"));
                a.setTituloAgenda(rs.getString("tituloAgenda"));
                a.setDescricaoAgenda(rs.getString("descricaoAgenda"));

                Agenda.add(a);
            }
            rs.close();
            st.close();
            this.con.close();
            return Agenda;
        }
    }

    public Colaborador getColaborador(String usuario, String senha) throws SQLException {
        String sql = "select * from colaborador where usuarioColaborador = ? and senhaColaborador = ?";
        Colaborador funcionario = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, usuario);
            st.setString(2, senha);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Colaborador();
                    funcionario.setIdColaborador(rs.getInt("idColaborador"));
                    funcionario.setNomeColaborador(rs.getString("nomeColaborador"));
                    funcionario.setTipoColaborador(rs.getString("tipoColaborador"));

                }
            }
            st.close();
        }

        this.con.close();
        return funcionario;
    }

    public Colaborador getColaborador(int idColaborador) throws SQLException {
        String sql = "select * from colaborador where idColaborador = ?";
        Colaborador equipe = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, idColaborador);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    equipe = new Colaborador();
                    equipe.setIdColaborador(rs.getInt("idColaborador"));
                    equipe.setNomeColaborador(rs.getString("nomeColaborador"));
                    equipe.setIdColaborador(rs.getInt("idColaborador"));
                    equipe.setNomeColaborador(rs.getString("nomeColaborador"));
                    equipe.setIdadeColaborador(rs.getString("idadeColaborador"));
                    equipe.setTipoColaborador(rs.getString("tipoColaborador"));
                    equipe.setCpfColaborador(rs.getString("cpfColaborador"));
                    equipe.setEmailColaborador(rs.getString("emailColaborador"));
                    equipe.setCelularColaborador(rs.getString("celularColaborador"));
                    equipe.setUsuarioColaborador(rs.getString("usuarioColaborador"));
                    equipe.setSenhaColaborador(rs.getString("senhaColaborador"));
                    equipe.setEquipeColabarador(rs.getInt("equipeColaborador"));
                    equipe.setRuaColaborador(rs.getString("ruaColaborador"));
                    equipe.setBairroColaborador(rs.getString("bairroColaborador"));
                    equipe.setCidadeColaborador(rs.getString("cidadeColaborador"));
                    equipe.setComplementoColaborador(rs.getString("complementoColaborador"));
                    equipe.setCepColaborador(rs.getString("cepColaborador"));

                }
            }
            st.close();
        }

        this.con.close();
        return equipe;
    }

    public Agenda getAgenda(int idAgenda) throws SQLException {
        String sql = "select * from agenda where codigoTarefa = ?";
        Agenda agenda = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, idAgenda);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    agenda = new Agenda();
                    agenda.setCodigoAgenda(rs.getInt("codigoTarefa"));
                    agenda.setTituloAgenda(rs.getString("tituloAgenda"));
                    agenda.setDescricaoAgenda(rs.getString("descricaoAgenda"));
                    agenda.setDataCriacaoAgenda(rs.getDate("dataCriacaoAgenda"));
                    agenda.setDataCompromissoAgenda(rs.getString("dataCompromissoAgenda"));
                    agenda.setCodigoEquipeAgenda(rs.getInt("codigoEquipeAgenda"));
                    agenda.setCodigoColaboradorAgenda(rs.getInt("codigoColaboradorAgenda"));

                }
            }
            st.close();
        }

        this.con.close();
        return agenda;
    }

    public void alterar(Agenda ag) throws SQLException {
     
        String sql = "update agenda set  dataCriacaoAgenda = now(), dataCompromissAgenda = ?, codigoColaboradorAgenda = ?, codigoEquipeAgenda = ?, tituloAgenda = ?, descricaoAgenda = ? where codigoTarefa = ?";
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(2, ag.getDataCompromissoAgenda());
            int codigoAgendaColaborador = ag.getCodigoColaboradorAgenda();
            if (codigoAgendaColaborador == 0) {
                st.setNull(3, java.sql.Types.INTEGER);
            } else {
                st.setInt(3, ag.getCodigoColaboradorAgenda());
            }
            int codigoAgendaEquipe = ag.getCodigoEquipeAgenda();
            if (codigoAgendaEquipe == 0) {
                st.setNull(4, java.sql.Types.INTEGER);
            } else {
                st.setInt(4, ag.getCodigoEquipeAgenda());
            }

            st.setString(5, ag.getTituloAgenda());
            st.setString(6, ag.getDescricaoAgenda());
             st.setInt(7, ag.getCodigoAgenda());
            st.executeUpdate();
            st.close();
        }

        this.con.close();

    }
}
