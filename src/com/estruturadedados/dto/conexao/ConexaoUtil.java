/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estruturadedados.dto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil { // Primeiramente precisa inserir no projeto o conector 

    private static ConexaoUtil conexaoUtil; //Cria-se um objeto do tipo conexão util.

    public static ConexaoUtil getInstance() { // Método para verificar se já existe uma conexão
        if (conexaoUtil == null) {
            conexaoUtil = new ConexaoUtil();
        }
        return conexaoUtil;
    }

    public Connection getConnection() throws ClassNotFoundException, // Método para receber a conexão
            SQLException {
        
        Class.forName("com.mysql.jdbc.Driver"); // Recebe-se o driver da conexão JAVA com MYSQL

        return DriverManager.getConnection(// Retorna a conexão - caminho - BD - user - password
                "jdbc:mysql://localhost/distribuidora", "root",
                "teste@2017AS");
    }

}
