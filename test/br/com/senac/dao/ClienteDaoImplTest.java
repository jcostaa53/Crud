/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.bean.Cliente;
import br.com.senac.util.GeradorUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joao.costa3
 */
public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClienteDao clienteDao;

    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
    }

    //@Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        cliente = new Cliente(GeradorUtil.gerarNome(), new Date(), GeradorUtil.gerarSalario());
        clienteDao.salvar(cliente);
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        buscarClienteBd();
        cliente.setNome(GeradorUtil.gerarNome() + " alt");
        clienteDao.alterar(cliente);
        
        Cliente clienteAlt = clienteDao.pesquisarPorId(cliente.getId());
        assertEquals(cliente.getNome(), clienteAlt.getNome());
    }

    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        buscarClienteBd();
        clienteDao.excluir(cliente.getId());
        Cliente clienteExcluido = clienteDao.pesquisarPorId(cliente.getId());
        assertNull(clienteExcluido);
    }

//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        buscarClienteBd();
        Cliente clienteBd = clienteDao.pesquisarPorId(cliente.getId());
        assertNotNull(clienteBd);
    }

    //@Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("pesquisarPorNome");
    }

    public Cliente buscarClienteBd() throws Exception {
        Connection con = FabricaConexao.abrirConexao();
        PreparedStatement psmt = con.prepareStatement("SELECT * FROM cliente");
        ResultSet res = psmt.executeQuery();
        if (res.next()) {
            cliente = new Cliente();
            cliente.setId(res.getInt("id"));
            cliente.setNome(res.getString("nome"));
            cliente.setDtNasc(res.getDate("dtNasc"));
            cliente.setSalario(res.getDouble("salario"));
        } else {
            testSalvar();
        }

        return cliente;
    }

}
