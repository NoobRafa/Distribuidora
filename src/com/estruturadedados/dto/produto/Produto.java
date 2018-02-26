/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estruturadedados.dto.produto;

/**
 *
 * @author Rafael Vieira
 */
public class Produto {
    private int id; // Cria-se o atributo id
    private String nome;// Cria-se o atributo nome
    private long codigoDeBarras; // Cria-se o atributo codBarras
    private String marca; // Cria-se o atributo marca
    private int categoria; // Cria-se o atributo categoria
    
    // Em seguida cria-se todos os métodos gets e sets dos atributos
    
    //Get - Retorna o valor do atributo
    //Set - Insere valor ao atributo
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codigoDeBarras
     */
    public long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    /**
     * @param codigoDeBarras the codigoDeBarras to set
     */
    public void setCodigoDeBarras(long codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
