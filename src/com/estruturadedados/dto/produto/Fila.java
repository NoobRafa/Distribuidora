package com.estruturadedados.dto.produto;

import javax.swing.JOptionPane;

public class Fila {

    private Produto fila[]; // Criar uma vetor de objetos do tipo produto
    private int tamanhoReal; // cria o atributo tamanho real que irá controlar o tam do vetor

    public Fila(int capacidade) { // Sobrecarga do construtor da Fila
        this.fila = new Produto[capacidade];
        this.tamanhoReal = 0;
    }

    public Fila() {
        this.fila = new Produto[1]; // É instanciado uma nova fila de tam 1.
        this.tamanhoReal = 0;// O tamanho é iniciado com zero
    }

    public Produto percorrerFila(Fila fi, int x) { 
        Produto p = new Produto(); //Cria-se um novo objeto do tipo produto

        p = fi.fila[x]; // Esse novo objeto vai receber o objeto da fila na posição x.

        return p; // retorna-se o objeto
    }

    private void aumentarCapacidade() {
        if (this.tamanhoReal == this.fila.length) { // Se o tam real da fila for = a o length dela
            Produto novaFila[] = new Produto[this.fila.length + 1]; // cria-se uma nova fila com o tam da fila antiga +1

            for (int i = 0; i < fila.length; i++) { // Repassa todo o conteudo da fila antiga para a nova
                novaFila[i] = this.fila[i];
            }

            this.fila = novaFila; // Agora a fila é novaFila
        }

    }

    public boolean adiciona(Produto p) {
        aumentarCapacidade();//Sempre verifica-se se a fila tem espaço para o novo elemento
        if (this.tamanhoReal < this.fila.length) { // Se o tam real for menor que o length da fila vai se inserir o elemento
            this.fila[this.tamanhoReal] = p;
            this.tamanhoReal++;
            return true;
        } else {
            return false;
        }
    }

    public int tamanhoReal() {
        return this.tamanhoReal;
    }

    public boolean filaVazia() {
        if (this.tamanhoReal > 0) {
            return false;
        } else {
            return true;
        }
    }

    public String imprimir() {
        if (filaVazia()) {
            String str = "Fila Vazia";
            return str;
        } else {
            String str = "";
            for (int i = 0; i < this.tamanhoReal; i++) {
                str += "Produto: " + this.fila[i].getNome() + "\t"
                        + "Cod. de Barras: " + this.fila[i].getCodigoDeBarras() + "\t"
                        + "Marca: " + this.fila[i].getMarca() + "\t"
                        + "Categoria: " + this.fila[i].getCategoria() + "\n";
            }
            return str;
        }

    }

    public void remover() {
        if (filaVazia()) {
            JOptionPane.showMessageDialog(null, "Fila vazia");
        } else {
            for (int i = 0; i < tamanhoReal - 1; i++) {
                this.fila[i] = this.fila[i + 1];
            }
            this.tamanhoReal--;
        }

    }

}
