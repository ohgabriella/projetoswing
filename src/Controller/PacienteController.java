/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Paciente;
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
public class PacienteController {

    public void adicionar(Paciente p) {
        PreparedStatement ps = null;
        String sql = "insert into pacientes(nome, idade, dataNasc, sexo, nomePai, nomeMae, escolaridade, id_usuario) values (?,?,?,?,?,?,?,?)";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            ps = conn.prepareStatement(sql); //preparar a clausula sql do banco
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getIdade());
            ps.setString(3, p.getDataNasc());
            ps.setString(4, p.getSexo());
            ps.setString(5, p.getNomePai());
            ps.setString(6, p.getNomeMae());
            ps.setString(7, p.getEscolaridade());
            ps.setLong(8, p.getId_usuario());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Error ao inserir o paciente no banco!");
            System.out.println(e.getMessage());
        }

    }

    public void remover(Paciente p) {
        String sql = "delete from pacientes where id = ?";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, p.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error ao deletar um paciente do banco");
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Paciente> listar() {
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        String sql;
        if(id == 2){
             sql = "select * from pacientes";
        }
        else{
             sql = "select * from pacientes where id_usuario ="+id;
        }
        PreparedStatement ps;
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setDataNasc(rs.getString("dataNasc"));
                p.setSexo(rs.getString("sexo"));
                p.setNomePai(rs.getString("nomePai"));
                p.setNomeMae(rs.getString("nomeMae"));
                p.setEscolaridade(rs.getString("escolaridade"));
                pacientes.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error ao listar paciente do banco!");
        }
        return pacientes;
    }

    public void alterar(Paciente p) {
        String sql = "update pacientes set idade = ?, dataNasc = ?,"
                + "sexo = ?, nomePai = ?, nomeMae = ?, escolaridade = ? where id = ?";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getIdade());
            ps.setString(2, p.getDataNasc());
            ps.setString(3, p.getSexo());
            ps.setString(4, p.getNomePai());
            ps.setString(5, p.getNomeMae());
            ps.setString(6, p.getEscolaridade());

            ps.setLong(7, p.getId());
           
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error ao atualizar paciente no banco");
            System.out.println(e.getMessage());
        }
    }

    public Paciente consultarPorNome(String nome) {
        Paciente paciente = null;

        String sql = "select * from pacientes where nome= ?";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = (rs.getInt("id"));
                String nomep = (rs.getString("nome"));
                

//                paciente = new Paciente(id, nome, cpf, rg, idade);
//                System.out.println(paciente.toString());

            }
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error ao consultar paciente por rg");
            System.out.println(e.getMessage());
        }
        return paciente;
    }

    public Paciente consultarPorLetra(String letra) {
        Paciente p = null;

        String sql = "select * from pacientes where nome like ?";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + letra + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Long id = (rs.getLong("id"));
                String nome = (rs.getString("nome"));
                String cpf = (rs.getString("cpf"));
                String rg = (rs.getString("rg"));
                int idade = (rs.getInt("idade"));

            }
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error ao consultar paciente!");
            System.out.println(e.getMessage());
        }
        return p;
    }

}
