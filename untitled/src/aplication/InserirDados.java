package aplication;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InserirDados {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConn();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?) ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Walisson");
            st.setString(2, "wwww.gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("01/02/2000").getTime()));
            st.setDouble(4, 5500.0);
            st.setInt(5, 4);

            int linhasAlteradas =  st.executeUpdate();
            if (linhasAlteradas > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("ID = " + id);
                }
            }
            else {
                System.out.println("Nenhuma linha foi alterada");
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        catch (ParseException e){
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
