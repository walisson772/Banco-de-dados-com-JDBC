package aplication;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarDados {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConn();

            st = conn.prepareStatement(
                    "UPDATE seller "
                            +"SET BaseSalary = BaseSalary + ?" +
                            " WHERE " +
                            "DepartmentId = ?");
            st.setDouble(1, 2000.0);
            st.setInt(2, 2);

            int linhasAfetadas = st.executeUpdate();
            System.out.println(linhasAfetadas);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
