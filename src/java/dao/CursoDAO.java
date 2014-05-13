/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entidades.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CursoDAO {
    
    private Connection conexao;
    
    public CursoDAO() throws ClassNotFoundException, SQLException{
        conexao = Conexao.getConexao();
    }
    
    public void insere(Curso c) throws SQLException{
        String sql = "insert into curso values (null, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setInt(2, c.getPeriodo().getId());
        stmt.setString(3, c.getCategoria());
        stmt.setInt(4, c.getCordenador().getId());
        stmt.execute();
        stmt.close();
    }
    
    public void atualiza(Curso c) throws SQLException {
        String sql = "update curso set nome = ?, idPeriodo = ?, categoria = ?"
                + "idProfessor = ? where idCurso = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setInt(2, c.getPeriodo().getId());
        stmt.setString(3, c.getCategoria());
        stmt.setInt(4, c.getCordenador().getId());
        stmt.setInt(5, c.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void exclui(Curso c) throws SQLException {
        String sql = "delete from curso where idCurso = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, c.getId());
        stmt.execute();
        stmt.close();
    }
    
    public List<Curso> listar() throws SQLException{
        List<Curso> list = new ArrayList<>();
        Curso c;
        String sql = "select * from curso";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            c = new Curso();
            c.setId(rs.getInt("idCurso"));
            c.getPeriodo().setId(rs.getInt("idPeriodo"));
            c.setCategoria(rs.getString("categoria"));
            c.getCordenador().setId(rs.getInt("idProfessor"));
            list.add(c);
        }
        return list;
    }
}
