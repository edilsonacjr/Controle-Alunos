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
        String sql = "update alunomateria set idaluno = ?, idmateria = ?"
                + "where idalunomateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, am.getAluno().getId());
        stmt.setInt(2, am.getMateria().getId());
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
        String sql = "select * from alunomateria";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            am = new AlunoMateria();
            am.setId(rs.getInt("idalunomateria"));
            am.getAluno().setId(rs.getInt("idaluno"));
            am.getMateria().setId(rs.getInt("idmateria"));
            list.add(am);
        }
        stmt.close();
        rs.close();
        return list;
    }
    
    public AlunoMateria getAlunoMateria(AlunoMateria am) throws SQLException {
        String sql = "select * from alunomateria where idalunomateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, am.getId());
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
