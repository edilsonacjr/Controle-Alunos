/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entidades.AlunoMateria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author claudemir
 */
public class AlunoMateriaDAO {
    
    private Connection conexao;
    
    public AlunoMateriaDAO() throws ClassNotFoundException, SQLException{
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
        String sql = "update alunomateria set idAluno = ?, idMateria = ?"
                + "where idAlunoMateria = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, am.getAluno().getId());
        stmt.setInt(2, am.getMateria().getId());
        stmt.execute();
        stmt.close();
    }
    
}