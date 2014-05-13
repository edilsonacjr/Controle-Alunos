/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entidades.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class AlunoDAO {
    
    private Connection conexao;
    
    public AlunoDAO() throws ClassNotFoundException, SQLException{
        conexao = Conexao.getConexao();
    }
    
    public void insere(Aluno a) throws SQLException{
        String sql = "insert into aluno values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        stmt.setInt(2, a.getCurso().getId());
        stmt.setInt(3, a.getMateria().getId());
        
    }
    
}
