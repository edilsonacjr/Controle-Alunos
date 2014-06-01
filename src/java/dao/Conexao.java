/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author claudemir
 */
public class Conexao {
    
    private static Connection con;
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        //Caso a conexão não exista deve se instanciar uma conexão com o banco
        if (con == null) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sisaluno", "root", "123");
        }
        //retorna a conexao
        return con;
    }
    //Encerra conexão com o banco.
    public static void close() throws SQLException{
        con.close();
    }
    
}
