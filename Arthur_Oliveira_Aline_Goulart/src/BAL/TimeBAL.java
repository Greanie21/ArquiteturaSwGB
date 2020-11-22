/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAL;

import VO.TimeVO;
import arthur_oliveira_aline_goulart.DAO.TimeDAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author abol9
 */
public class TimeBAL {

    public int Insert(TimeVO time) throws SQLException {
        //TODO REGRAS DE NEGOCIO!!!!!!!!

        return new TimeDAO().Insert(time);
    }

    public ResultSet Read() throws SQLException {
        return new TimeDAO().Read();
    }

    public ResultSet Read(int id) throws SQLException {
        //TODO REGRAS DE NEGOCIO!!!!!!!!

        return new TimeDAO().Read(id);
    }

    public int Edit(TimeVO time, int id) throws SQLException {
        //TODO REGRAS DE NEGOCIO!!!!!!!!

        return new TimeDAO().Edit(time, id);
    }

    public int Delete(int id) throws SQLException {
        //TODO REGRAS DE NEGOCIO!!!!!!!!

        return new TimeDAO().Delete(id);
    }

    public Date VerificarData(String fundacao) throws Exception {

        LocalDate dt;

        if (fundacao.isEmpty()) {
            throw new Exception("Fundação é obrigatória");
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dt = LocalDate.parse(fundacao, dtf);

        } catch (Exception e) {
            throw new Exception("Fundação Inválida" + fundacao);
        }
        Date date = Date.valueOf(dt);

        if (date.after(Date.valueOf(LocalDate.now()))) {
            throw new Exception("Fundação não pode ser superior a data de hoje");
        }

        return date;

    }
}
