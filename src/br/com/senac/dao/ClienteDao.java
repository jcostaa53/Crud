/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.bean.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author joao.costa3
 */
public interface ClienteDao {

    //por defaut todos os metodos dentro de uma interface são public abstratc
    void salvar(Cliente cliente) throws SQLException;

    void alterar(Cliente cliente) throws SQLException;

    void excluir(int id) throws SQLException;

    Cliente pesquisarPorId(int id) throws SQLException;

    List<Cliente> pesquisarPorNome(String nome) throws SQLException;
    
}
