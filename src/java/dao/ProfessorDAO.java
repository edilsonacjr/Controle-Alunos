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
public class ProfessorDAO {

    private Connection conexao;

    public ProfessorDAO() throws ClassNotFoundException, SQLException {
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
        String sql = "update professor set nome = ?, cpf = ?, dataNascimento = ?"
                + "login = ?, senha = ?, email = ?, dataAdmissao = ? where "
                + "idProfessor = ?";
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
    
    public void exclui(Professor p) throws SQLException{
        String sql = "delete from professor where idProfessor = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, p.getId());
        stmt.execute();
        stmt.close();
    }
    
    public List<Professor> listar() throws SQLException{
        List<Professor> list = new ArrayList<>();
        Professor p;
        String sql = "select * from professor";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            p = new Professor();
            p.setId(rs.getInt("idProfessor"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            p.setDataNascimento(rs.getDate("dataNascimento"));
            p.setLogin(rs.getString("login"));
            p.setSenha(rs.getString("senha"));
            p.setEmail(rs.getString("email"));
            p.setDataAdmissao(rs.getDate("dataAdmissao"));
        }
        return list;
    }

}
