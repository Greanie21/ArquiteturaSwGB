/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arthur_oliveira_aline_goulart.DAO;

import VO.TimeVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abol9
 */
public class TimeDAO {

    private ArrayList columns = new ArrayList();
    MysqlFactory factory = new MysqlFactory();

    public TimeDAO() {
        columns.add("id");
        columns.add("escudo");
        columns.add("fundacao");
        columns.add("nome");
        columns.add("patrimonio");
    }

    public int Insert(TimeVO time) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(time.getEscudo());
        dados.add(time.getFundacao());
        dados.add(time.getNome());
        dados.add(time.getPatrimonio());

        return factory.Insert("time", columns, dados);
    }

    public ResultSet Read() throws SQLException {
        return factory.Read(columns, "time");
    }

    public ResultSet Read(int id) throws SQLException {
        return factory.Read(columns, "time", id);
    }

    public int Edit(TimeVO time,int id) throws SQLException {
        ArrayList dados = new ArrayList();
        dados.add(time.getEscudo());
        dados.add(time.getFundacao());
        dados.add(time.getNome());
        dados.add(time.getPatrimonio());

        return factory.Edit("time", columns, dados, id);
    }
    
    public int Delete(int id) throws SQLException
    {
        return factory.Delete("time", columns, id);
    }
}
