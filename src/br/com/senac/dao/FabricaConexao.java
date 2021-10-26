/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author joao.costa3
 */
public class FabricaConexao {
    
    public static Connection abrirConexao() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/associacao?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull", "root", "Senac2021");
    }
}
