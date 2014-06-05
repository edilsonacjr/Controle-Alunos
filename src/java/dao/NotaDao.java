/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Nota;
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
public class NotaDao {

    Connection conexao;

    public NotaDao() throws ClassNotFoundException, SQLException {
        conexao = Conexao.getConexao();
    }

    public void insere(Nota n) throws SQLException {
        String sql = "insert into nota values (null, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setDouble(1, n.getN1());
        stmt.setDouble(2, n.getN2());
        stmt.setDouble(3, n.getN3());
        stmt.setInt(4, n.getAlunoMateria().getId());
        stmt.execute();
        stmt.close();
    }

    public void atualiza(Nota n) throws SQLException {
        String sql = "update nota set n1 = ?, n2 = ?, n3 = ?, "
                + "idalunomateria = ? where idnota = ? ";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setDouble(1, n.getN1());
        stmt.setDouble(2, n.getN2());
        stmt.setDouble(3, n.getN3());
        stmt.setInt(4, n.getAlunoMateria().getId());
        stmt.setInt(5, n.getId());
        stmt.execute();
        stmt.close();
    }

    public void exclui(Nota n) throws SQLException {
        String sql = "delete from nota where idnota = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, n.getId());
        stmt.execute();
        stmt.close();
    }

    public List<Nota> listar() throws SQLException {
        List<Nota> list = new ArrayList<>();
        Nota n = null;
        String sql = "select * from nota";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            n = new Nota();
            n.setId(rs.getInt("idnota"));
            n.getAlunoMateria().setId(rs.getInt("idalunomateria"));
            n.setN1(rs.getDouble("n1"));
            n.setN2(rs.getDouble("n2"));
            n.setN3(rs.getDouble("n3"));
            list.add(n);
        }
        stmt.close();
        rs.close();
        return list;
    }
    
    public Nota getNota(Nota nota) throws SQLException {
        String sql = "select * from nota where idnota = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, nota.getId());
        Nota n = null;
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            n = new Nota();
            n.setId(rs.getInt("idnota"));
            n.setN1(rs.getDouble("n1"));
            n.setN2(rs.getDouble("n2"));
            n.setN3(rs.getDouble("n3"));
            n.getAlunoMateria().setId(rs.getInt("idalunomateria"));
        }
        stmt.close();
        rs.close();
        return n;
    }

}
