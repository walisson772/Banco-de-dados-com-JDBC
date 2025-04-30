package aplication;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Transacao {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConn();
            st = conn.createStatement();
            conn.setAutoCommit(false);

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            //int x = 1;
            //if (x < 2){
            //    throw new SQLException("Fake error");
            // }
            System.out.println(rows1);
            System.out.println(rows2);
            conn.commit();
        }
        catch (SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transação cancelada");
            }
            catch (SQLException e1){
                throw new DbException("Erro enquanto tentava voltar a transação");
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
