/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConsultaPaciente;
import static View.Autenticar.id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ariel
 */
public class ConsultaController {

    public void adicionar(ConsultaPaciente u) {
        PreparedStatement ps = null;
        String sql = "insert into consultas(data, id_paciente, id_usuario) values (?,?,?)";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            ps = conn.prepareStatement(sql); //preparar a clausula sql do banco
            ps.setString(1, u.getData());
            ps.setLong(2, u.getId_paciente());
            ps.setLong(3, u.getId_usuario());

            ps.execute();

        } catch (SQLException e) {
            System.out.println("Error ao inserir consulta no banco!");
            System.out.println(e.getMessage());
        }

    }

    public void remover(ConsultaPaciente u) {
        String sql = "delete from consultas where id_paciente = ?";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, u.getId_paciente());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error ao deletar uma consulta do banco");
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<ConsultaPaciente> listar() {
        ArrayList<ConsultaPaciente> consulta = new ArrayList<ConsultaPaciente>();
        String sql;
        if (id == 2) {
            sql = "select * from consultas";

        } else {
            sql = "select * from consultas where id_usuario =" + id;
        }
        PreparedStatement ps;
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ConsultaPaciente u = new ConsultaPaciente();
                u.setData(rs.getString("data"));
                u.setId_paciente(rs.getLong("id_paciente"));
                u.setId_usuario(rs.getLong("id_usuario"));

                consulta.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error ao listar consulta do banco!");
        }
        return consulta;
    }
}
