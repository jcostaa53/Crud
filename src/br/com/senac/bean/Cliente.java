/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joao.costa3
 */
public class Cliente implements Serializable {

    private Integer id;
    private String nome;
    private Date dtNasc;
    private double salario;

    public Cliente() {
    }

    public Cliente(String nome, Date dtNasc, double salario) {
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
