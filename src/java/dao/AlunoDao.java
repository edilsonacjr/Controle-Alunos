/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Aluno;
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
 * @author User
 */
public class AlunoDao {

    private Connection conexao;

    public AlunoDao() throws ClassNotFoundException, SQLException {
        conexao = Conexao.getConexao();
    }

    public void insere(Aluno a) throws SQLException {
        String sql = "insert into aluno values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, a.getCurso().getId());
        stmt.setDate(2, new Date(a.getDataAdmissao().getTime()));
        stmt.setString(3, a.getNome());
        stmt.setString(4, a.getCpf());
        stmt.setDate(5, new Date(a.getDataNascimento().getTime()));
        stmt.setString(6, a.getLogin());
        stmt.setString(7, a.getSenha());
        stmt.setString(8, a.getEmail());
        stmt.execute();
        stmt.close();
    }

    public void atualiza(Aluno a) throws SQLException {
        String sql = "update aluno set idcurso = ?, dataadminssao = ?"
                + ", nome = ?, cpf = ?, datanascimento = ?, login = ?, senha = ?, email = ?"
                + "where idaluno = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        stmt.setInt(2, a.getCurso().getId());
        stmt.setDate(3, new Date(a.getDataAdmissao().getTime()));
        stmt.setString(4, a.getNome());
        stmt.setString(5, a.getCpf());
        stmt.setDate(6, new Date(a.getDataNascimento().getTime()));
        stmt.setString(7, a.getLogin());
        stmt.setString(8, a.getSenha());
        stmt.setString(9, a.getEmail());
        stmt.setInt(10, a.getId());
        stmt.execute();
        stmt.close();
    }

    public void exclui(Aluno a) throws SQLException {
        String sql = "delete from aluno where idaluno = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        stmt.execute();
        stmt.close();
    }

    public List<Aluno> listar() throws SQLException {
        List<Aluno> list = new ArrayList<>();
        Aluno a;
        String sql = "select * from "
                + "aluno a "
                + "inner join curso c on (a.idcurso = c.idcurso)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            a = new Aluno();
            a.setId(rs.getInt("a.idaluno"));
            a.getCurso().setId(rs.getInt("c.idcurso"));
            //a.setDataAdmissao(rs.getDate("a.dataadmissao"));
            a.setNome(rs.getString("a.nome"));
            a.setCpf(rs.getString("a.cpf"));
            //a.setDataNascimento(rs.getDate("a.datanascimento"));
            a.setLogin(rs.getString("a.login"));
            a.setSenha(rs.getString("a.senha"));
            a.setEmail(rs.getString("a.email"));
            list.add(a);
        }
        return list;
    }

    public Aluno getAluno(Aluno a) throws SQLException {
        String sql = "select * from aluno a where idaluno = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            a.setId(rs.getInt("a.idaluno"));
            a.getCurso().setId(rs.getInt("a.idcurso"));
            //a.setDataAdmissao(rs.getDate("a.dataadmissao"));
            a.setNome(rs.getString("a.nome"));
            a.setCpf(rs.getString("a.cpf"));
            //a.setDataNascimento(rs.getDate("a.datanascimento"));
            a.setLogin(rs.getString("a.login"));
            a.setSenha(rs.getString("a.senha"));
            a.setEmail(rs.getString("a.email"));
        }
        return a;
    }

    public Aluno validaAluno(Aluno aluno) throws SQLException {
        String sql = "select * from aluno a"
                + "left join curso c on (a.idcurso = c.idcurso) "
                + "where login = ? and senha = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, aluno.getLogin());
        stmt.setString(2, aluno.getSenha());
        Aluno a = null;
        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt("a.idaluno"));
                a.getCurso().setId(rs.getInt("a.idcurso"));
                //a.setDataAdmissao(rs.getDate("a.dataadmissao"));
                a.setNome(rs.getString("a.nome"));
                a.setCpf(rs.getString("a.cpf"));
                //a.setDataNascimento(rs.getDate("a.datanascimento"));
                a.setLogin(rs.getString("a.login"));
                a.setSenha(rs.getString("a.senha"));
                a.setEmail(rs.getString("a.email"));
            }
        } catch (NoResultException e) {
            a = null;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return a;
    }

}
