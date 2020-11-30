/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author abol9
 */
public class TimeVO {

    int id;
    String escudo;
    Date fundacao;
    String nome;
    BigDecimal patrimonio;

    public TimeVO() {
    }

    public TimeVO(String escudo, Date fundacao, String nome, BigDecimal patrimonio) {
        this.escudo = escudo;
        this.fundacao = fundacao;
        this.nome = nome;
        this.patrimonio = patrimonio;
    }

    public TimeVO(int id, String escudo, Date fundacao, String nome, BigDecimal patrimonio) {
        this.id = id;
        this.escudo = escudo;
        this.fundacao = fundacao;
        this.nome = nome;
        this.patrimonio = patrimonio;
    }

    public int getId() {
        return id;
    }

    public String getEscudo() {
        return escudo;
    }

    public Date getFundacao() {
        return fundacao;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPatrimonio() {
        return patrimonio;
    }
}
