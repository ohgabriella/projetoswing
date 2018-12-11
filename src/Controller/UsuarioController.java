/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ariel
 */
public class UsuarioController {

    public void adicionar(Usuario u) {
        PreparedStatement ps = null;
        String sql = "insert into usuario(username, senha) values (?,?)";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            ps = conn.prepareStatement(sql); //preparar a clausula sql do banco
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getSenha());
            ps.execute();

        } catch (SQLException e) {
            System.out.println("Error ao inserir o usuario no banco!");
            System.out.println(e.getMessage());
        }

    }

    public void remover(Usuario u) {
        String sql = "delete from usuario where id = ?";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, u.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error ao deletar um usuario do banco");
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        String sql = "select * from usuario";
        PreparedStatement ps;
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setSenha(rs.getString("senha"));
                usuario.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error ao listar paciente do banco!");
        }
        return usuario;
    }

    public void alterar(Usuario u) {
        String sql = "update usuario set username = ?, senha = ? where id = ?";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getSenha());
            ps.setInt(3, u.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error ao atualizar paciente no banco");
            System.out.println(e.getMessage());
        }

    }
    
    public Usuario consultarPorNome(String nome) {
        Usuario usuario = null;

        String sql = "select * from usuario where username= ?";
        try (Connection conn = new ConnectionFactoryPaciente().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = (rs.getInt("id"));
                String username = (rs.getString("username"));
                String senha = (rs.getString("senha"));
           
                usuario = new Usuario(id, username, senha);
                System.out.println(usuario.toString());

            }
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error ao consultar usuario por nome");
            System.out.println(e.getMessage());
        }
        return usuario;
    }

}
