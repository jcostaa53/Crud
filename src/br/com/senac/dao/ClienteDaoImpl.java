/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.bean.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author joao.costa3
 */
public class ClienteDaoImpl implements ClienteDao {

    private Connection conexao; //abre conexao com o BD
    private PreparedStatement preparaSql; //prepara e envia a instrução sql
    private ResultSet resultado; //pegar coisas do BD

    @Override
    public void salvar(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO cliente(nome, dtNasc, salario) VALUES(?, ?, ?)";

        try {

            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparaSql.setString(1, cliente.getNome());
            preparaSql.setDate(2, new Date(cliente.getDtNasc().getTime())); //convertendo java.util em .sql (o banco nao aceita java.util)
            preparaSql.setDouble(3, cliente.getSalario());
            preparaSql.executeUpdate();

            //pegando PK do BD
            resultado = preparaSql.getGeneratedKeys();
            resultado.next();
            cliente.setId(resultado.getInt(1));

        } catch (Exception e) {

            System.out.println("Erro ao salvar cliente " + e.getMessage());

        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
    }

    @Override
    public void alterar(Cliente cliente) throws SQLException {

        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement("UPDATE cliente SET nome = ?, dtNasc = ?, salario = ? WHERE id = ?"); // mesma coisa que no salvar, so que la ta como variavel
            preparaSql.setString(1, cliente.getNome());
            preparaSql.setDate(2, new Date(cliente.getDtNasc().getTime()));
            preparaSql.setDouble(3, cliente.getSalario());
            preparaSql.setInt(4, cliente.getId());
            preparaSql.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao alterar cliente " + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public void excluir(int id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement("DELETE FROM cliente WHERE id = ?");
            preparaSql.setInt(1, id);
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir cliente " + e.getMessage());
            
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public Cliente pesquisarPorId(int id) throws SQLException {
        Cliente cliente = null;

        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement("SELECT * FROM cliente WHERE id = ?");
            preparaSql.setInt(1, id);
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setDtNasc(resultado.getDate("dtNasc"));
                cliente.setSalario(resultado.getDouble("salario"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por ID " + e.getMessage());

        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return cliente;
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
