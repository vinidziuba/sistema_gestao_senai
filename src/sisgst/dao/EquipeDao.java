package sisgst.dao;

import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sisgst.modelo.Equipe;

public class EquipeDao extends ConnectionFactory {

    private Connection con;

    public EquipeDao() {
        this.con = this.getConnection();
    }
    /**
     * Metodo inserir equipe
     * @param eq
     * @throws SQLException 
     */
    public void inserir(Equipe eq) throws SQLException {
        String sql = "insert into equipe (idEquipe, nomeEquipe, descricaoEquipe)values(?, ?, ?)";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, eq.getIdEquipe());
            st.setString(2, eq.getNomeEquipe());
            st.setString(3, eq.getDescricaoEquipe());

            st.execute();
            st.close();
        }
        this.con.close();

    }
    /**
     * Metodo alterar equipe
     * @param eq
     * @throws SQLException 
     */
    public void alterar(Equipe eq) throws SQLException {

        String sql = "update equipe set nomeEquipe = ?, descricaoEquipe = ? where idEquipe = ?";
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, eq.getNomeEquipe());
            st.setString(2, eq.getDescricaoEquipe());
            st.setInt(3, eq.getIdEquipe());

            st.execute();
            st.close();
        }

        this.con.close();

    }
    /**
     * Metodo eliminar equipe
     * @param codigo
     * @throws SQLException 
     */
    public void eliminar(int codigo) throws SQLException {
        String sql = "delete from equipe where idEquipe = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codigo);
            st.execute();
            st.close();
        }
        this.con.close();
    }
/**
 * Metodo Listar equipe
 * @return
 * @throws SQLException 
 */
    public List<Equipe> listarEquipe() throws SQLException {
        String sql = "select * from equipe";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            List<Equipe> Equipe = new ArrayList<Equipe>();

            while (rs.next()) {
                Equipe e = new Equipe();
                e.setIdEquipe(rs.getInt("idEquipe"));
                e.setNomeEquipe(rs.getString("nomeEquipe"));
                e.setDescricaoEquipe(rs.getString("descricaoEquipe"));

                Equipe.add(e);
            }
            rs.close();
            st.close();
            this.con.close();
            return Equipe;
        }
    }
/**
 * Metodo para buscar equipe
 * @param idEquipe
 * @return Retorna a variavel equipe
 * @throws SQLException 
 */
    public Equipe getEquipe(int idEquipe) throws SQLException {
        String sql = "select * from equipe where idEquipe = ?";
        Equipe equipe = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, idEquipe);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    equipe = new Equipe();
                    equipe.setIdEquipe(rs.getInt("idEquipe"));
                    equipe.setNomeEquipe(rs.getString("nomeEquipe"));
                    equipe.setDescricaoEquipe(rs.getString("descricaoEquipe"));

                }
            }
            st.close();
        }

        this.con.close();
        return equipe;
    }
    /**
     * Lista equipes na combo box
     * @return retorna a uma variavel equipe
     * @throws SQLException 
     */
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

}
