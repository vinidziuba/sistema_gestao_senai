package sisgst.dao;

import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sisgst.modelo.Colaborador;
import sisgst.modelo.Equipe;

public class ColaboradorDao extends ConnectionFactory {

    private Connection con;


    public ColaboradorDao() {
        this.con = this.getConnection();
    }
          public boolean checkTypeLogin(Colaborador Co) throws SQLException  {
        String sql = "SELECT * from colaborador where tipoColaborador = ?";
        ResultSet rs = null;
        boolean check = false;
        Colaborador co = new Colaborador();
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
          st.setString(1, co.getTipoColaborador());
            rs = st.executeQuery();
          
            if(rs.next()){
                check=true;
            }
            
            st.execute();
            st.close();
        }
        this.con.close();
         
        return check;
    }
        
       public boolean checkLogin(String loginColaborador , String senhaColaborador) throws SQLException  {
        String sql = "SELECT * from colaborador where usuarioColaborador = ? and senhaColaborador = ?";
        ResultSet rs = null;
        boolean check = false;
        Colaborador co = new Colaborador();
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, loginColaborador);
            st.setString(2 , senhaColaborador);
            rs = st.executeQuery();
          
            if(rs.next()){
                check=true;
                
            }
            st.execute();
            st.close();
        }
        this.con.close();
         
        return check;
    }
     

       
       
    public void inserir(Colaborador co) throws SQLException {
        String sql = "insert into colaborador (nomeColaborador, idadeColaborador, tipoColaborador, cpfColaborador, emailColaborador, celularColaborador, usuarioColaborador, senhaColaborador, equipeColaborador, ruaColaborador, bairroColaborador, cidadeColaborador, complementoColaborador, cepColaborador )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, co.getNomeColaborador());
            st.setString(2, co.getIdadeColaborador());
            st.setString(3, co.getTipoColaborador());
            st.setString(4, co.getCpfColaborador());
            st.setString(5, co.getEmailColaborador());
            st.setString(6, co.getCelularColaborador());
            st.setString(7, co.getUsuarioColaborador());
            st.setString(8, co.getSenhaColaborador());
            st.setInt   (9, co.getEquipeColabarador());
            st.setString(10, co.getRuaColaborador());
            st.setString(11, co.getBairroColaborador());
            st.setString(12, co.getCidadeColaborador());
            st.setString(13, co.getComplementoColaborador());
            st.setString(14, co.getCepColaborador());
                
            st.execute();
            st.close();
        }
        this.con.close();

    }

    public void alterar(Colaborador co) throws SQLException {

        String sql = "update colaborador set nomeColaborador = ?, idadeColaborador = ?, tipoColaborador = ?, cpfColaborador = ?, emailColaborador = ?, celularColaborador = ?, usuarioColaborador = ?, senhaColaborador = ?, equipeColaborador = ?, ruaColaborador = ?, bairroColaborador = ?, cidadeColaborador = ?,  complementoColaborador = ?, cepColaborador = ? where idColaborador = ?";
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, co.getNomeColaborador());
            st.setString(2, co.getIdadeColaborador());
            st.setString(3, co.getTipoColaborador());
            st.setString(4, co.getCpfColaborador());
            st.setString(5, co.getEmailColaborador());
            st.setString(6, co.getCelularColaborador());
            st.setString(7, co.getUsuarioColaborador());
            st.setString(8, co.getSenhaColaborador());
            st.setInt(9, co.getEquipeColabarador());
            st.setString(10, co.getRuaColaborador());
            st.setString(11, co.getBairroColaborador());
            st.setString(12, co.getCidadeColaborador());
            st.setString(13, co.getComplementoColaborador());
            st.setString(14, co.getCepColaborador());
            st.setInt(15, co.getIdColaborador());
            st.executeUpdate();
            st.close();
        }

        this.con.close();

    }

    public void eliminar(Colaborador co) throws SQLException {
       
        
        String sql = "DELETE from colaborador where idColaborador = ?";
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            
            st.setInt(1, co.getIdColaborador());
            

            st.execute();
            st.close();
        }

        this.con.close();
    }

    public List<Colaborador> listarColaborador() throws SQLException {
        String sql = "select * from colaborador";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            List<Colaborador> Colaborador = new ArrayList<Colaborador>();

            while (rs.next()) {
                Colaborador e = new Colaborador();
                e.setIdColaborador(rs.getInt("idColaborador"));
                e.setNomeColaborador(rs.getString("nomeColaborador"));
                e.setIdadeColaborador(rs.getString("idadeColaborador"));
                e.setTipoColaborador(rs.getString("tipoColaborador"));
                e.setCpfColaborador(rs.getString("cpfColaborador"));
                e.setEmailColaborador(rs.getString("emailColaborador"));
                e.setCelularColaborador(rs.getString("celularColaborador"));
                e.setUsuarioColaborador(rs.getString("usuarioColaborador"));
                e.setSenhaColaborador(rs.getString("senhaColaborador"));
                e.setEquipeColabarador(rs.getInt("equipeColaborador"));
                e.setRuaColaborador(rs.getString("ruaColaborador"));
                e.setBairroColaborador(rs.getString("bairroColaborador"));
                e.setCidadeColaborador(rs.getString("cidadeColaborador"));
                e.setComplementoColaborador(rs.getString("complementoColaborador"));
                e.setCepColaborador(rs.getString("cepColaborador"));

                Colaborador.add(e);
            }
            rs.close();
            st.close();
            this.con.close();
            return Colaborador;
        }
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
                    funcionario.setBairroColaborador(rs.getString("bairroColaborador"));
                    funcionario.setCelularColaborador(rs.getString("celularColaborador"));
                    funcionario.setCpfColaborador(rs.getString("cpfColaborador"));
                    funcionario.setCidadeColaborador(rs.getString("cidadeColaborador"));
                    funcionario.setEquipeColabarador(rs.getInt("equipeColaborador"));
                    funcionario.setEmailColaborador(rs.getString("emailColaborador"));
                    funcionario.setComplementoColaborador(rs.getString("complementoColaborador"));
                    funcionario.setUsuarioColaborador(rs.getString("usuarioColaborador"));
                    funcionario.setSenhaColaborador(rs.getString("senhaColaborador"));
                    funcionario.setRuaColaborador(rs.getString("ruaColaborador"));
                    funcionario.setCepColaborador(rs.getString("cepColaborador"));
                    
                }
            }
            st.close();
        }

        this.con.close();
        return funcionario;
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
   public void UltimoAcesso(int codigo) throws SQLException {
        String sql = "update colaborador set dataEntrada = now() where idColaborador = ?";
        
        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codigo);
            st.executeUpdate();
            st.close();
        }

        this.con.close();
   }
}
