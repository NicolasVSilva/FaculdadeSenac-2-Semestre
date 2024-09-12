/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controll.Cliente;
import Controll.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class ProdutoDAO {
       public static String url = "jdbc:mysql://localhost:3306/MercadoPI";
    public static String usuario = "root";
    public static String senha = "Nicolasvs1";
    
    /**
     * Metodo para salvar dados
     * @param obj Recebe um objeto da classe Produto
     * @return boolean true:sucesso false:falha
     */
    public static boolean salvar(Produto obj){
        boolean retorno = false;
        
        Connection conexao = null;
        
        /**
         * Try catch para caso erros ocorram
         */
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produto(nome, tipoUnidade, categoria, descricao, codBarras, quantidade, dataValidade, preco) VALUES(?,?,?,?,?,?,?,?)");
            
            // 4 - passar parametros para o comando sql
            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setString(2, obj.getTipoUnidade());
            comandoSQL.setString(3, obj.getCategoria());
            comandoSQL.setString(4, obj.getDescricao());
            comandoSQL.setString(5, obj.getCodBarras());
            comandoSQL.setInt(6, obj.getQuantidade());
            java.sql.Date sqlDate = new java.sql.Date(obj.getDataValidade().getTime());
            comandoSQL.setDate(7, sqlDate);
            comandoSQL.setFloat(8, obj.getPreco());
            
            
            
            // 5 - executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                //Gravou com sucesso
                retorno = true;
            }else{
                //Gravaçao incompleta
                retorno = false;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
    /**
     * Metodo para alterar dados salvos
     * @param obj Recebe um objeto da classe Produto
     * @return boolean true:sucesso false:falha
     */
    public static boolean alterar(Produto obj){
        boolean retorno = false;
        
        Connection conexao = null;
        
        
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produto SET nome = ?, tipoUnidade = ?, categoria = ?, descricao = ?, codBarras = ?, quantidade = ?, dataValidade = ?, preco = ? WHERE codBarras=?");
            
            // 4 - passar parametros para o comando sql
            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setString(2, obj.getTipoUnidade());
            comandoSQL.setString(3, obj.getCategoria());
            comandoSQL.setString(4, obj.getDescricao());
            comandoSQL.setString(5, obj.getCodBarras());
            comandoSQL.setInt(6, obj.getQuantidade());
            java.sql.Date sqlDate = new java.sql.Date(obj.getDataValidade().getTime());
            comandoSQL.setDate(7, sqlDate);
            comandoSQL.setFloat(8, obj.getPreco());
            comandoSQL.setString(9, obj.getCodBarras());
           
            // 5 - executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                //Gravou com sucesso
                retorno = true;
            }else{
                //Gravaçao incompleta
                retorno = false;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
    /**
     * Metodo para excluir dados
     * @param cod Recebe o respectivo codBarras da ocorrencia a ser excluida
     * @return boolean true:sucesso false:falha
     */
    public static boolean excluir(int cod){
        boolean retorno = false;
        
        Connection conexao = null;
        
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM produto WHERE codBarras = ?");
            
            // 4 - passar parametros para o comando sql
            comandoSQL.setInt(1, cod);
            
            // 5 - executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                //Gravou com sucesso
                retorno = true;
            }else{
                //Gravaçao incompleta
                retorno = false;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
    /**
     * Metodo para listar todos os registros do tabela
     * @return ArrayList Lista de Produtos
     */
    public static ArrayList<Produto> listar(){
        ArrayList<Produto> lstProdutos = new ArrayList<>();
        
        Connection conexao = null;
        ResultSet rs = null;
        
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto");
            
            // 4 - Executar comando
            
            rs = comandoSQL.executeQuery();
            
            //Enquanto houver linha no SELECT add o objeto na lista de retorno
            while(rs.next()){
                String nome = rs.getString("nome");
                String tipoUnidade = rs.getString("tipoUnidade");
                String categoria = rs.getString("categoria");
                String descricao = rs.getString("descricao");
                String codBarras = rs.getString("codBarras");
                int quantidade = rs.getInt("quantidade");
                Date dataValidade = rs.getDate("dataValidade");
                float preco = rs.getFloat("preco");
                
                
                Produto item = new Produto(nome, tipoUnidade, categoria, descricao, codBarras, quantidade, dataValidade, preco);
                lstProdutos.add(item);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstProdutos;
    }
    
    /**
     * Metodo para listar todos os registros do tabela com base em um filtro definido
     * @param cat Valor utilizado como filtro para a busca
     * @return ArrayList Lista de Produtos
     */
    public static ArrayList<Produto> buscarNumero(String cat){
        ArrayList<Produto> lstProdutos = new ArrayList<>();
        
        Connection conexao = null;
        ResultSet rs = null;
        
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE categoria=?");
            
            comandoSQL.setString(1, cat);
            
            // 4 - Executar comando
            
            rs = comandoSQL.executeQuery();
            
            //Enquanto houver linha no INSERT add o objeto na lista de retorno
            while(rs.next()){
                String nome = rs.getString("nome");
                String tipoUnidade = rs.getString("tipoUnidade");
                String categoria = rs.getString("categoria");
                String descricao = rs.getString("descricao");
                String codBarras = rs.getString("codBarras");
                int quantidade = rs.getInt("quantidade");
                Date dataValidade = rs.getDate("dataValidade");
                float preco = rs.getFloat("preco");
                
                
                Produto item = new Produto(nome, tipoUnidade, categoria, descricao, codBarras, quantidade, dataValidade, preco);
                lstProdutos.add(item);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lstProdutos;
    }
}
