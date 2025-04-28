package aplication;

import db.DB;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {

        Connection conn = DB.getConn();
        System.out.println("Conectou");
        DB.closeConnection();
        System.out.println("Fechou a conexão");
    }
}
