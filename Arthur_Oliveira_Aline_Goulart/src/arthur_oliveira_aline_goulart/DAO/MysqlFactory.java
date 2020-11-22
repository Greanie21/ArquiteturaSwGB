/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arthur_oliveira_aline_goulart.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author abol9
 */
public class MysqlFactory {

    private PreparedStatement stmt;

    private PreparedStatement prepare(StringBuilder sql) throws SQLException {
        PreparedStatement stmt = MysqlConnector.getConexao().prepareStatement((sql.toString()));

        return stmt;
    }

    public int Insert(String tableName, ArrayList colunas, ArrayList dados) throws SQLException {
        StringBuilder sql = new StringBuilder();

        //Remove o id
        //colunas.remove(0);
        sql.append("INSERT INTO ");
        sql.append(tableName);
        sql.append(" (");

        int tam = colunas.size();
        //começa no 1 pra pular o id
        for (int i = 1; i < tam; i++) {
            sql.append(colunas.get(i));
            sql.append(", ");
        }
        //tira o ultimo ", "
        sql.deleteCharAt(sql.length() - 2);

        sql.append(")");
        sql.append(" VALUES ('");

        Iterator it2 = dados.iterator();
        while (it2.hasNext()) {
            sql.append(it2.next());
            if (it2.hasNext()) {
                sql.append("', '");
            }
        }
        sql.append("')");
        
        System.out.println(sql);

        this.stmt = this.prepare((sql));
        return this.stmt.executeUpdate(sql.toString());
    }

    public ResultSet Read(ArrayList columns, String tableName) throws SQLException {
        StringBuilder sql = prepareToRead(columns, tableName);

        this.stmt = this.prepare((sql));
        return this.stmt.executeQuery(sql.toString());
    }

    public ResultSet Read(ArrayList columns, String tableName, int id) throws SQLException {
        StringBuilder sql = prepareToRead(columns, tableName);

        sql.append(" WHERE ");
        sql.append("id");
        sql.append(" = ");
        sql.append(id);

        this.stmt = this.prepare((sql));
        return this.stmt.executeQuery(sql.toString());
    }

    private StringBuilder prepareToRead(ArrayList columns, String tableName) {
        StringBuilder sql = new StringBuilder();

        Iterator it = columns.iterator();

        sql.append("SELECT ");

        while (it.hasNext()) {
            sql.append(it.next());
            sql.append(", ");
        }
        sql.setLength(sql.length() - 2);

        sql.append(" FROM ");
        sql.append(tableName);

        return sql;
    }

    public int Edit(String tablename, ArrayList colunas, ArrayList dados, int id) throws SQLException {
        StringBuilder sql = new StringBuilder();

        Object coluna_id = colunas.get(0);
        colunas.remove(0);

        sql.append("UPDATE ");
        sql.append(tablename);
        sql.append(" SET ");

        int tam = colunas.size();
        for (int i = 0; i < tam; i++) {
            int j = i;
            sql.append(colunas.get(i));
            sql.append("='");
            sql.append(dados.get(i));
            sql.append("'");

            if (++j < tam) {
                sql.append(",");
            }
        }

        sql.append(" WHERE ");
        sql.append(coluna_id);
        sql.append(" = ");
        sql.append(id);

        this.stmt = this.prepare(sql);
        return this.stmt.executeUpdate(sql.toString());
    }

    public int Delete(String tableName, ArrayList colunas, int id) throws SQLException {
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM ");
        sql.append(tableName);
        sql.append(" WHERE ");
        sql.append(colunas.get(0));
        sql.append("=");
        sql.append(id);

        this.stmt = this.prepare(sql);
        return this.stmt.executeUpdate(sql.toString());
    }
}
