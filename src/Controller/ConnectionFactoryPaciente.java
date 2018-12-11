/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariel
 */
public class ConnectionFactoryPaciente {

    public Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/bdconsultorio";
        try {
            conn = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println("Error na conexão com o banco!");
            e.printStackTrace();
        }

        return conn;
    }

    public static void conexao() {

        Connection conn = new ConnectionFactoryPaciente().getConnection();
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
