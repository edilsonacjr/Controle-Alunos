/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entidades.Periodo;
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
public class PeriodoDAO {
    
    private Connection conexao;
    
    public PeriodoDAO() throws ClassNotFoundException, SQLException{
        conexao = Conexao.getConexao();
    }
    
    public void insere(Periodo p) throws SQLException {
        String sql = "insert into periodo values (null, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, p.getCurso().getId());
        stmt.setString(2, p.getNome());
        stmt.setInt(3, p.getAno());
        stmt.setInt(4, p.getSemestre());
        stmt.execute();
        stmt.close();
    }
    
    public void atualiza(Periodo p) throws SQLException {
        String sql = "update periodo set idCurso = ?, nome = ?, ano = ?, semestre = ?"
                + "where idPeriodo = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, p.getCurso().getId());
        stmt.setString(2, p.getNome());
        stmt.setInt(3, p.getAno());
        stmt.setInt(4, p.getSemestre());
        stmt.setInt(5, p.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void exclui(Periodo p) throws SQLException {
        String sql = "delete from periodo where idPeriodo = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, p.getId());
        stmt.execute();
        stmt.close();
    }
    
    public List<Periodo> listar() throws SQLException {
        List<Periodo> list = new ArrayList<>();
        Periodo p;
        String sql = "select * from periodo";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            p = new Periodo();
            p.setId(rs.getInt("idPeriodo"));
            p.getCurso().setId(rs.getInt("idCurso"));
            p.setNome(rs.getString("nome"));
            p.setAno(rs.getInt("ano"));
            p.setSemestre(rs.getInt("semestre"));
            list.add(p);
        }
        return list;
    }
}
