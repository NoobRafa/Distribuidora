/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estruturadedados.dao.produto;

import com.estruturadedados.dto.produto.Fila;
import com.estruturadedados.dto.produto.Produto;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Vieira
 */
public class Teste {
    public static void main(String[] args) {
        Fila fila = new Fila();
        
        int cont  = 4;
        
        while (cont > 0) {            
            Produto p = new Produto();
            String str = JOptionPane.showInputDialog(null, "Digite o nome do produto");
            p.setNome(str);
            str = JOptionPane.showInputDialog(null, "Digite o codigo de barras do produto");
            p.setCodigoDeBarras(Long.parseLong(str));
            str = JOptionPane.showInputDialog(null, "Digite a marca do produto");
            p.setMarca(str);
            str = JOptionPane.showInputDialog(null, "Digite o número da categoria do produto");
            p.setCategoria(Integer.parseInt(str));
            
            fila.adiciona(p);
            cont--;
        }
        
        ProdutoDAO x = new ProdutoDAO();
        
        x.inserirProdutos(fila);
        
        Fila teste = new Fila();
        
        teste = x.consultarEsteiraLimpeza();
        
        if (teste.filaVazia()) {
            System.out.println("Fila Vazia.");
        }else{
            int aux  = 0;
            
            while (aux < teste.tamanhoReal()) {                
                System.out.print("ID: " + teste.percorrerFila(teste, aux).getId() + "\t");
                System.out.print("NOME: " + teste.percorrerFila(teste, aux).getNome()+ "\t");
                System.out.print("COD. BARRAS: " + teste.percorrerFila(teste, aux).getCodigoDeBarras() + "\t");
                System.out.print("MARCA: " + teste.percorrerFila(teste, aux).getMarca() + "\t");
                System.out.print("CATEGORIA: " + teste.percorrerFila(teste, aux).getCategoria());
                System.out.println();
                aux++;
            }
        }
        
    }
    
}
