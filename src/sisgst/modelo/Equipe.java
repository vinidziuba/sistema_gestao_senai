/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgst.modelo;

import sisgst.dao.EquipeDao;

/**
 *
 * @author renan
 */
public class Equipe extends EquipeDao {
    
    private int idEquipe;
    private String nomeEquipe;
    private String descricaoEquipe;

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getDescricaoEquipe() {
        return descricaoEquipe;
    }

    public void setDescricaoEquipe(String descricaoEquipe) {
        this.descricaoEquipe = descricaoEquipe;
    }
   
    
    
}
