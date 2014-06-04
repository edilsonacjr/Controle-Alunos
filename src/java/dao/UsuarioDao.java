/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author claudemir
 */
public class UsuarioDao {

    private Connection conexao;

    public UsuarioDao() throws ClassNotFoundException, SQLException {
        conexao = Conexao.getConexao();
    }

    public void insere(Usuario u) throws SQLException {
        String sql = "insert into usuario values (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCpf());
        stmt.setDate(3, new Date(u.getDataNascimento().getTime()));
        stmt.setString(4, u.getLogin());
        stmt.setString(5, u.getSenha());
        stmt.setString(6, u.getEmail());
        stmt.execute();
        stmt.close();
    }

    public void atualiza(Usuario u) throws SQLException {
        String sql = "update usuario set nome = ?, cpf = ?, datanascimento = ? login = ?, senha = ?, email = ?"
                + "where idusuario = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getCpf());
        stmt.setDate(3, new Date(u.getDataNascimento().getTime()));
        stmt.setString(4, u.getLogin());
        stmt.setString(5, u.getSenha());
        stmt.setString(6, u.getEmail());
        stmt.setInt(7, u.getId());
        stmt.execute();
        stmt.close();
    }

    public void exclui(Usuario u) throws SQLException {
        String sql = "delete from usuario where idusuario = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, u.getId());
        stmt.execute();
        stmt.close();
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> list = new ArrayList<>();
        Usuario u;
        String sql = "select * from usuario";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            u = new Usuario();
            u.setId(rs.getInt("idusuario"));
            u.setNome(rs.getString("nome"));
            u.setDataNascimento(rs.getDate("datanascimento"));
            u.setCpf(rs.getString("cpf"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            u.setEmail(rs.getString("email"));
            list.add(u);
        }
        return list;
    }

    public Usuario getUsuario(Usuario u) throws SQLException {
        String sql = "select * from usuario where idusuario = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, u.getId());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            u = new Usuario();
            u.setId(rs.getInt("idusuario"));
            u.setNome(rs.getString("nome"));
            u.setDataNascimento(rs.getDate("datanascimento"));
            u.setCpf(rs.getString("cpf"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            u.setEmail(rs.getString("email"));
        }
        stmt.close();
        rs.close();
        return u;
    }

    public Usuario validaUsuario(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where login = ? "
                + "and senha = ?";
        Usuario u = null;
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, usuario.getSenha());
        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("idusuario"));
                u.setNome(rs.getString("nome"));
                u.setDataNascimento(rs.getDate("datanascimento"));
                u.setCpf(rs.getString("cpf"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setEmail(rs.getString("email"));
            }
        } catch (NoResultException e) {
            u = null;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return u;
    }
}
