/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estruturadedados.dao.produto;

import com.estruturadedados.dto.produto.Fila;

/**
 *
 * @author Rafael Vieira
 */
public class Teste2 {
    
    public static void main(String[] args) {
        
        ProdutoDAO x = new ProdutoDAO();
        
        Fila teste = new Fila();
        
        teste  =  x.consultarEsteiraLimpeza();
        
        for (int i = 0; i < teste.tamanhoReal(); i++) {
            System.out.println("ID: " + teste.percorrerFila(teste, i).getId());
            System.out.println("Nome:" + teste.percorrerFila(teste, i).getNome());
            System.out.println("Marca:" + teste.percorrerFila(teste, i).getMarca());
        }
        
    }
    
}
