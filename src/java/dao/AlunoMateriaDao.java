/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entidades.AlunoMateria;
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
public class AlunoMateriaDao {
    
    private Connection conexao;
    
    public AlunoMateriaDao() throws ClassNotFoundException, SQLException{
        conexao = Conexao.getConexao();
    }
    
    public void insere(AlunoMateria am) throws SQLException{
        String sql = "insert into alunomateria values (null, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, am.getAluno().getId());
        stmt.setInt(2, am.getMateria().getId());
        stmt.execute();
        stmt.close();
    }
    
    public void altera(AlunoMateria am) throws SQLException {
        String sql = "update alunomateria set idaluno = ?, idmateria = ? "
                + "where idalunomateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, am.getAluno().getId());
        stmt.setInt(2, am.getMateria().getId());
        stmt.setInt(3,am.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void exclui(AlunoMateria am) throws SQLException {
        String sql = "delete from alunomateria where idalunomateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, am.getId());
        stmt.execute();
        stmt.close();
    }
    
    public List<AlunoMateria> listar() throws SQLException{
        List<AlunoMateria> list = new ArrayList<>();
        AlunoMateria am;
        String sql = "select * from alunomateria am\n"
                + "   inner join aluno a on (am.idaluno = a.idaluno)\n"
                + "   inner join materia m on (am.idmateria = m.idmateria)\n"
                + "   inner join periodo p on (m.idperiodo = p.idperiodo)\n"
                + "   inner join professor pf on (m.idprofessor = pf.idprofessor)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            am = new AlunoMateria();
            am.setId(rs.getInt("idalunomateria"));
            am.getAluno().setId(rs.getInt("idaluno"));
            am.getAluno().setDataAdmissao(rs.getDate("a.dataadmissao"));
            am.getAluno().setNome(rs.getString("a.nome"));
            am.getAluno().setCpf(rs.getString("a.cpf"));
            am.getAluno().setDataNascimento(rs.getDate("a.datanascimento"));
            am.getAluno().setLogin(rs.getString("a.login"));
            am.getAluno().setSenha(rs.getString("a.senha"));
            am.getAluno().setEmail(rs.getString("a.email"));
            am.getMateria().setId(rs.getInt("idmateria"));
            am.getMateria().getPeriodo().setId(rs.getInt("p.idperiodo"));
            am.getMateria().getPeriodo().getCurso().setId(rs.getInt("p.idcurso"));
            am.getMateria().getPeriodo().setNome(rs.getString("p.nome"));
            am.getMateria().getPeriodo().setAno(rs.getInt("p.ano"));
            am.getMateria().getPeriodo().setSemestre(rs.getInt("p.semestre"));
            am.getMateria().setNome(rs.getString("m.nome"));
            am.getMateria().getProfessor().setId(rs.getInt("pf.idprofessor"));
            am.getMateria().getProfessor().setId(rs.getInt("pf.idprofessor"));
            am.getMateria().getProfessor().setNome(rs.getString("pf.nome"));
            am.getMateria().getProfessor().setCpf(rs.getString("pf.cpf"));
            am.getMateria().getProfessor().setDataNascimento(rs.getDate("pf.datanascimento"));
            am.getMateria().getProfessor().setLogin(rs.getString("pf.login"));
            am.getMateria().getProfessor().setSenha(rs.getString("pf.senha"));
            am.getMateria().getProfessor().setEmail(rs.getString("pf.email"));
            am.getMateria().getProfessor().setDataAdmissao(rs.getDate("pf.dataadmissao"));
            list.add(am);
        }
        stmt.close();
        rs.close();
        return list;
    }
    
    public AlunoMateria getAlunoMateria(AlunoMateria alunomateria) throws SQLException {
        String sql = "select * from alunomateria where idalunomateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, alunomateria.getId());
        AlunoMateria am = null;
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            am = new AlunoMateria();
            am.setId(rs.getInt("idalunomateria"));
            am.getAluno().setId(rs.getInt("idaluno"));
            am.getMateria().setId(rs.getInt("idmateria"));
        }
        stmt.close();
        rs.close();
        return am;
    }
    
}
