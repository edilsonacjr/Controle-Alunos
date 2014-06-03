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
public class CursoDao {
    
    private Connection conexao;
    
    public CursoDao() throws ClassNotFoundException, SQLException{
        conexao = Conexao.getConexao();
    }
    
    public void insere(Curso c) throws SQLException{
        String sql = "insert into curso values (null, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getCategoria());
        stmt.setInt(3, c.getCordenador().getId());
        stmt.execute();
        stmt.close();
    }
    
    public void atualiza(Curso c) throws SQLException {
        String sql = "update curso set nome = ?, categoria = ?"
                + "idprofessor = ? where idcurso = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getCategoria());
        stmt.setInt(3, c.getCordenador().getId());
        stmt.setInt(4, c.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void exclui(Curso c) throws SQLException {
        String sql = "delete from curso where idcurso = ?";
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
            c.setId(rs.getInt("idcurso"));
            c.setCategoria(rs.getString("categoria"));
            c.getCordenador().setId(rs.getInt("idprofessor"));
            list.add(c);
        }
        return list;
    }
}
