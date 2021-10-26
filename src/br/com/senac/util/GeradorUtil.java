/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author joao.costa3
 */
public class GeradorUtil {

    public static String gerarSenha() {
        String[] letras = {"a", "b",
            "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int tamanho = letras.length;
        String senha = "";
        int indice;
        for (int i = 0; i < 4; i++) {
            indice = (int) (Math.random() * tamanho);
            senha = senha + letras[indice];
        }
        return senha;
    }

    public static String gerarDataHoraAtual() {
        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter conversorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return conversorData.format(dataAtual);
    }
    
    public static String gerarNumero(int qtde) {
        String senha = "";
        int numero;
        for (int i = 0; i < qtde; i++) {
            numero = (int) (Math.random() * 10);
            senha += numero;
        }
        return senha;
    }

    public static String gerarCpf() {
        return gerarNumero(3) + "." + gerarNumero(3) + "." + gerarNumero(3)
                + "-" + gerarNumero(2);
    }

    public static String gerarCnpj() {
        return gerarNumero(2) + "." + gerarNumero(3) + "." + gerarNumero(3)
                + "/" + gerarNumero(4) + "-" + gerarNumero(2);
    }

    public static String gerarTelFixo() {
        return "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);
    }

    public static String gerarCelular() {
        return "(48)9" + gerarNumero(4) + "-" + gerarNumero(4);
    }

    public static String gerarCep() {
        return gerarNumero(2) + "." + gerarNumero(3) + "-" + gerarNumero(3);
    }

    public static String gerarNome() {
        String[] nomes = {"joão", "mariele", "matheus", "jeferson", "alisson",
            "willian", "vitor", "martyn", "vinicius", "jonatas", "karen", "braian",
            "geovani", "gabriel", "jeremias", "marcos", "rafael", "leonardo", "maria",
            "pedro"};
        return nomes[(int) (Math.random() * nomes.length)] + " "  + gerarSobrenome();
    }
    
    private static String gerarSobrenome(){
         String[] sobrenomes = {"silva", "costa", "borges", "souza", "oliveira",
            "santos", "siqueira", "rocha", "pereira", "bittencourt", "schutz", "pires",
            "smith", "daddario", "evans", "pine", "barnes", "parker", "stark",
            "banner"};
        return sobrenomes[(int) (Math.random() * sobrenomes.length)];
    }
    
    public static String gerarCidade() {
        String[] cidades = {"florianopolis", "palhoça", "biguaçu", "são jose", "imbituba",
            "penha", "bombinhas", "tubarão", "laguna", "criciuma", "chapeco"};
        return cidades[(int) (Math.random() * cidades.length)];
    }
    
    public static String gerarBairros() {
        String[] bairros = {"eldorado", "aquarius", "ponte do imaruim", "passa vinte", "barra",
            "enseada", "praia de fora", "pinheira", "monte verde", "saco grande", "cacupe"};
        return bairros[(int) (Math.random() * bairros.length)];
    }
    
    public static String Uf() {
        String[] bairros = {"SC", "PR", "SP", "RJ", "MG",
            "AC", "RO", "AP", "TO", "CE", "RN"};
        return bairros[(int) (Math.random() * bairros.length)];
    }

    public static double gerarSalario() {
        int numero = (int) (Math.random() * 100000);
        return numero;
    }
}
