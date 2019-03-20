/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisgst.modelo;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Cristian
 */
public class Agenda {
    private Date dataCriacaoAgenda;
    private String dataCompromissoAgenda;
    private int codigoColaboradorAgenda;
    private int codigoEquipeAgenda;
    private String tituloAgenda;
    private String descricaoAgenda;

    public Date getDataCriacaoAgenda() {
        return dataCriacaoAgenda;
    }

    public void setDataCriacaoAgenda(Date dataCriacaoAgenda) {
        this.dataCriacaoAgenda = dataCriacaoAgenda;
    }

    public String getDataCompromissoAgenda() {
        return dataCompromissoAgenda;
    }

    public void setDataCompromissoAgenda(String dataCompromissoAgenda) {
        this.dataCompromissoAgenda = dataCompromissoAgenda;
    }

    public int getCodigoColaboradorAgenda() {
        return codigoColaboradorAgenda;
    }

    public void setCodigoColaboradorAgenda(int codigoColaboradorAgenda) {
        this.codigoColaboradorAgenda = codigoColaboradorAgenda;
    }

    public int getCodigoEquipeAgenda() {
        return codigoEquipeAgenda;
    }

    public void setCodigoEquipeAgenda(int codigoEquipeAgenda) {
        this.codigoEquipeAgenda = codigoEquipeAgenda;
    }

    public String getTituloAgenda() {
        return tituloAgenda;
    }

    public void setTituloAgenda(String tituloAgenda) {
        this.tituloAgenda = tituloAgenda;
    }

    public String getDescricaoAgenda() {
        return descricaoAgenda;
    }

    public void setDescricaoAgenda(String descricaoAgenda) {
        this.descricaoAgenda = descricaoAgenda;
    }


          
    
}
