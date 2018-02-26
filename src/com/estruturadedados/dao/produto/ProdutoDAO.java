package com.estruturadedados.dao.produto;

import com.estruturadedados.dto.conexao.ConexaoUtil;
import com.estruturadedados.dto.produto.Fila;
import com.estruturadedados.dto.produto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO { //Classe Responsável pela inserção e consulta no bd.

    public void inserirProdutos(Fila fila) { // inserção de produtos no BD, usa-se uma fila
        try {
            int contador = 0; // Contador inicia-se com zero.
            int tamanho = fila.tamanhoReal(); // tam vai receber o tam real da fila.

            Connection connection = new ConexaoUtil().getInstance().getConnection(); // Abre-se a conexão

            while (contador < tamanho) { // Enquanto o contador for menor que o tamanho, insere-se os produtos

                switch (fila.percorrerFila(fila, contador).getCategoria()) { // Verifica-se qual categoria é o produto
                    case 1: {
                        String sql = "INSERT INTO esteiraLimpeza(nome, codBarras, marca, categoria)"
                                + "values (?,?,?,?) "; // String de conexão
                        PreparedStatement statement = connection.prepareStatement(sql); // PrepareStatament faz a ponte entre o java e o mysql
                        statement.setString(1, fila.percorrerFila(fila, contador).getNome());// Inserção do atributo nome
                        statement.setString(2, Long.toString(fila.percorrerFila(fila, contador).getCodigoDeBarras()));// Inserção do atributo codBarras
                        statement.setString(3, fila.percorrerFila(fila, contador).getMarca());// Inserção do atributo Marca
                        statement.setString(4, Integer.toString(fila.percorrerFila(fila, contador).getCategoria()));// Inserção do atributo categoria
                        statement.execute();
                        break;
                    }
                    case 2: {
                        String sql = "INSERT INTO esteiraAlimento(nome, codBarras, marca, categoria)"
                                + "values (?,?,?,?) ";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, fila.percorrerFila(fila, contador).getNome());
                        statement.setString(2, Long.toString(fila.percorrerFila(fila, contador).getCodigoDeBarras()));
                        statement.setString(3, fila.percorrerFila(fila, contador).getMarca());
                        statement.setString(4, Integer.toString(fila.percorrerFila(fila, contador).getCategoria()));
                        statement.execute();
                        break;
                    }
                    case 3: {
                        String sql = "INSERT INTO esteiraBebida(nome, codBarras, marca, categoria)"
                                + "values (?,?,?,?) ";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, fila.percorrerFila(fila, contador).getNome());
                        statement.setString(2, Long.toString(fila.percorrerFila(fila, contador).getCodigoDeBarras()));
                        statement.setString(3, fila.percorrerFila(fila, contador).getMarca());
                        statement.setString(4, Integer.toString(fila.percorrerFila(fila, contador).getCategoria()));
                        statement.execute();
                        break;
                    }
                    default: {
                        String sql = "INSERT INTO despache(nome, codBarras, marca)"
                                + "values (?,?,?) ";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, fila.percorrerFila(fila, contador).getNome());
                        statement.setString(2, Long.toString(fila.percorrerFila(fila, contador).getCodigoDeBarras()));
                        statement.setString(3, fila.percorrerFila(fila, contador).getMarca());
                        statement.execute();
                        break;
                    }
                }
                contador++;

            }

            connection.close(); // Fecha a conexão

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Fila consultarEsteiraLimpeza() {// Metodo para retornar a fila de objetos do BD.

        Fila consulta = new Fila(); // Cria-se uma nova fila.

        try {

            Connection connection = new ConexaoUtil().getInstance().getConnection(); //Cria a conexão

            String sql = "SELECT * from esteiraLimpeza"; // Cria o comando SQL

            PreparedStatement statement = connection.prepareStatement(sql); // Ponte entre o java e o SQL

            ResultSet resultset = statement.executeQuery(); // Retorna uma tabela com todos os valores da tabela.

            while (resultset.next()) {// Enquanto houver linhas na tabela, será recuperado os valores
                Produto p = new Produto(); // cria-se um novo objeto produto
                p.setId(resultset.getInt("id")); // recebe o id.
                p.setNome(resultset.getString("nome"));// recebe o nome.
                p.setCodigoDeBarras(resultset.getLong("codBarras"));// recebe o codBarras.
                p.setMarca(resultset.getString("marca"));// recebe a marca
                p.setCategoria(resultset.getInt("categoria"));// recebe a categoria.
                consulta.adiciona(p); // adiciona o objeto a fila.
            }

            connection.close(); // Fecha a conexão

        } catch (Exception e) {
            e.printStackTrace();
        }

        return consulta;

    }

    public Fila consultarEsteiraAlimento() {
        Fila consulta = new Fila();

        try {

            Connection connection = new ConexaoUtil().getInstance().getConnection();

            String sql = "SELECT * from esteiraAlimento";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                Produto p = new Produto();
                p.setId(resultset.getInt("id"));
                p.setNome(resultset.getString("nome"));
                p.setCodigoDeBarras(resultset.getLong("codBarras"));
                p.setMarca(resultset.getString("marca"));
                p.setCategoria(resultset.getInt("categoria"));
                consulta.adiciona(p);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return consulta;

    }

    public Fila consultarEsteiraBebidas() {
        Fila consulta = new Fila();

        try {

            Connection connection = new ConexaoUtil().getInstance().getConnection();

            String sql = "SELECT * from esteiraBebida";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                Produto p = new Produto();
                p.setId(resultset.getInt("id"));
                p.setNome(resultset.getString("nome"));
                p.setCodigoDeBarras(resultset.getLong("codBarras"));
                p.setMarca(resultset.getString("marca"));
                p.setCategoria(resultset.getInt("categoria"));
                consulta.adiciona(p);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return consulta;

    }

    public Fila consultarEsteiraDespache() {
        Fila consulta = new Fila();

        try {

            Connection connection = new ConexaoUtil().getInstance().getConnection();

            String sql = "SELECT * from despache";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                Produto p = new Produto();
                p.setId(resultset.getInt("id"));
                p.setNome(resultset.getString("nome"));
                p.setCodigoDeBarras(resultset.getLong("codBarras"));
                p.setMarca(resultset.getString("marca"));
                consulta.adiciona(p);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return consulta;

    }

    public void resetarEsteiraLimpeza() {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();

            String sql = "ALTER TABLE esteiraLimpeza auto_increment = 1";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void resetarEsteiraAlimento() {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();

            String sql = "ALTER TABLE esteiraAlimento auto_increment = 1";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
      public void resetarEsteiraBebidas() {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();

            String sql = "ALTER TABLE esteiraBebida auto_increment = 1";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public void resetarDespache() {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();

            String sql = "ALTER TABLE despache auto_increment = 1";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
