/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Professor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudemir
 */
public class ProfessorDao {

    private Connection conexao;

    public ProfessorDao() throws ClassNotFoundException, SQLException {
        conexao = Conexao.getConexao();
    }

    public void inserir(Professor p) throws SQLException {
        String sql = "insert into professor values (null, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getCpf());
        stmt.setDate(3, new Date(p.getDataNascimento().getTime()));
        stmt.setString(4, p.getLogin());
        stmt.setString(5, p.getSenha());
        stmt.setString(6, p.getEmail());
        stmt.setDate(7, new Date(p.getDataAdmissao().getTime()));
        stmt.execute();
        stmt.close();
    }

    public void atualizar(Professor p) throws SQLException {
        String sql = "update professor set nome = ?, cpf = ?, "
                + "datanascimento = ?, login = ?, senha = ?, email = ?, "
                + "dataadmissao = ? where idprofessor = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getCpf());
        stmt.setDate(3, new Date(p.getDataNascimento().getTime()));
        stmt.setString(4, p.getLogin());
        stmt.setString(5, p.getSenha());
        stmt.setString(6, p.getEmail());
        stmt.setDate(7, new Date(p.getDataAdmissao().getTime()));
        stmt.setInt(8, p.getId());
        stmt.execute();
        stmt.close();
    }

    public void exclui(Professor p) throws SQLException {
        String sql = "delete from professor where idprofessor = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, p.getId());
        stmt.execute();
        stmt.close();
    }

    public List<Professor> listar() throws SQLException {
        List<Professor> list = new ArrayList<>();
        Professor p = null;
        String sql = "select * from professor";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            p = new Professor();
            p.setId(rs.getInt("idprofessor"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            p.setDataNascimento(rs.getDate("datanascimento"));
            p.setLogin(rs.getString("login"));
            p.setSenha(rs.getString("senha"));
            p.setEmail(rs.getString("email"));
            p.setDataAdmissao(rs.getDate("dataadmissao"));
            list.add(p);
        }
        stmt.close();
        rs.close();
        return list;
    }

    public Professor getProfessor(Professor professor) throws SQLException {
        String sql = "select * from professor where idprofessor = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, professor.getId());
        Professor p = null;
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            p = new Professor();
            p.setId(rs.getInt("idprofessor"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            p.setDataNascimento(rs.getDate("datanascimento"));
            p.setLogin(rs.getString("login"));
            p.setSenha(rs.getString("senha"));
            p.setEmail(rs.getString("email"));
            p.setDataAdmissao(rs.getDate("dataadmissao"));
        }
        stmt.close();
        rs.close();
        return p;
    }

    public Professor validaProfessor(Professor professor) throws SQLException {
        String sql = "select * from professor where login = ? and senha = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, professor.getLogin());
        stmt.setString(2, professor.getSenha());
        Professor p = null;
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            p = new Professor();
            p.setId(rs.getInt("idprofessor"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            p.setDataNascimento(rs.getDate("datanascimento"));
            p.setLogin(rs.getString("login"));
            p.setSenha(rs.getString("senha"));
            p.setEmail(rs.getString("email"));
            p.setDataAdmissao(rs.getDate("dataadmissao"));
        }
        return p;
    }
    
    public List<Professor> getConstula (Professor p) throws SQLException {
        String sql = "select * from professor where nome like ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        //Professor p;
        
        return null;
    }
}
