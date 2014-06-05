/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claudemir
 */
public class MateriaDao {

    private Connection conexao;

    public MateriaDao() throws ClassNotFoundException, SQLException {
        conexao = Conexao.getConexao();
    }

    public void insere(Materia m) throws SQLException {
        String sql = "insert into materia values (null, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, m.getPeriodo().getId());
        stmt.setString(2, m.getNome());
        stmt.setInt(3, m.getProfessor().getId());
        stmt.execute();
        stmt.close();
    }

    public void atualiza(Materia m) throws SQLException {
        String sql = "update materia set idperiodo = ?, nome = ?, idprofessor = ? "
                + "where idmateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, m.getPeriodo().getId());
        stmt.setString(2, m.getNome());
        stmt.setInt(3, m.getProfessor().getId());
        stmt.setInt(4, m.getId());
        stmt.execute();
        stmt.close();
    }

    public void exclui(Materia m) throws SQLException {
        String sql = "delete from materia where idmateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, m.getId());
        stmt.execute();
        stmt.close();
    }

    public List<Materia> listar() throws SQLException {
        List<Materia> list = new ArrayList<>();
        Materia m;
        String sql = "select * from materia m\n"
                + "       inner join periodo p on (m.idperiodo = p.idperiodo)\n"
                + "       inner join professor pf on (m.idprofessor = pf.idprofessor)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            m = new Materia();
            m.setId(rs.getInt("m.idmateria"));
            m.getPeriodo().setId(rs.getInt("p.idperiodo"));
            m.getPeriodo().getCurso().setId(rs.getInt("p.idcurso"));
            m.getPeriodo().setNome(rs.getString("p.nome"));
            m.getPeriodo().setAno(rs.getInt("p.ano"));
            m.getPeriodo().setSemestre(rs.getInt("p.semestre"));
            m.setNome(rs.getString("m.nome"));
            m.getProfessor().setId(rs.getInt("pf.idprofessor"));
            m.getProfessor().setId(rs.getInt("pf.idprofessor"));
            m.getProfessor().setNome(rs.getString("pf.nome"));
            m.getProfessor().setCpf(rs.getString("pf.cpf"));
            m.getProfessor().setDataNascimento(rs.getDate("pf.datanascimento"));
            m.getProfessor().setLogin(rs.getString("pf.login"));
            m.getProfessor().setSenha(rs.getString("pf.senha"));
            m.getProfessor().setEmail(rs.getString("pf.email"));
            m.getProfessor().setDataAdmissao(rs.getDate("pf.dataadmissao"));
            list.add(m);
        }
        stmt.close();
        rs.close();
        return list;
    }

    public Materia getMateria(Materia materia) throws SQLException {
        String sql = "select * from materia where idmateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, materia.getId());
        Materia m = null;
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            m = new Materia();
            m.setId(rs.getInt("idmateria"));
            m.getPeriodo().setId(rs.getInt("idperiodo"));
            m.setNome(rs.getString("nome"));
            m.getProfessor().setId(rs.getInt("idprofessor"));
        }
        stmt.close();
        rs.close();
        return m;
    }
    
    public List<Materia> getConsulta(Materia materia) throws SQLException {
        String sql = "select * from materia m \n "
                + " inner join periodo pe on (m.idperiodo = pe.idperiodo) \n"
                + "inner join professor pr on (m.idprofessor = pr.idprofessor)"
                + "where m.nome like ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, materia.getNome());
        Materia m = null;
        List<Materia> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            m = new Materia();
            m.setId(rs.getInt("m.idmateria"));
            m.getPeriodo().setId(rs.getInt("pe.idperiodo"));
            m.getPeriodo().getCurso().setId(rs.getInt("pe.idcurso"));
            m.getPeriodo().setNome(rs.getString("pe.nome"));
            m.getPeriodo().setAno(rs.getInt("pe.ano"));
            m.setNome(rs.getString("m.nome"));
            m.getProfessor().setId(rs.getInt("pr.idprofessor"));
            m.getProfessor().setNome(rs.getString("pr.nome"));
            m.getProfessor().setCpf(rs.getString("pr.cpf"));
            m.getProfessor().setDataNascimento(rs.getDate("pr.datanascimento"));
            m.getProfessor().setLogin(rs.getString("pr.login"));
            m.getProfessor().setSenha(rs.getString("pr.senha"));
            m.getProfessor().setEmail(rs.getString("pr.email"));
            m.getProfessor().setDataAdmissao(rs.getDate("pr.dataadmissao"));
            list.add(m);
        }
        stmt.close();
        rs.close();
        return list;
    }
}
