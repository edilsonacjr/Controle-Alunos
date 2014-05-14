/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entidades.Falta;
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
public class FaltaDAO {
    
    private Connection conexao;
    
    public FaltaDAO() throws ClassNotFoundException, SQLException {
        conexao = Conexao.getConexao();
    }
    
    public void insere(Falta f) throws SQLException {
        String sql = "insert into falta values (null, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, f.getAluno().getId());
        stmt.setInt(2, f.getMateria().getId());
        stmt.setDate(3, new Date(f.getData().getTime()));
        stmt.execute();
        stmt.close();
    }
    
    public void atualiza(Falta f) throws SQLException {
        String sql = "update falta set idAluno = ?, idMateria = ?, data ?"
                + "where idFalta = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, f.getAluno().getId());
        stmt.setInt(2, f.getMateria().getId());
        stmt.setDate(3, new Date(f.getData().getTime()));
        stmt.setInt(4, f.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void exclui(Falta f) throws SQLException {
        String sql = "delete from falta where idFalta = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, f.getId());
        stmt.execute();
        stmt.close();
    }
    
    public List<Falta> listar() throws SQLException {
        List<Falta> list = new ArrayList<>();
        Falta f;
        String sql = "select * from falta";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            f = new Falta();
            f.setId(rs.getInt("idFalta"));
            f.getAluno().setId(rs.getInt("idAluno"));
            f.getMateria().setId(rs.getInt("idMateria"));
            f.setData(rs.getDate("data"));
            list.add(f);
        }
        
        return list;
    }
    
}
