package aplication;

import db.DB;
import db.DbIntegritException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConn();

            st = conn.prepareStatement(
              "DELETE FROM department "
                    + "WHERE "
                    + "(Id = ?)"
            );
            st.setInt(1, 4);

            int linhasAfetadas = st.executeUpdate();
            System.out.println(linhasAfetadas);
        }
        catch (SQLException e){
            throw new DbIntegritException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
