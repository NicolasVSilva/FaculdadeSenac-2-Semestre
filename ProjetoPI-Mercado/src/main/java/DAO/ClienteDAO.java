/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import Controll.Cliente;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe feita para ligar o Controll.Cliente com o banco de dados
 * @author Nicolas
 */

public class ClienteDAO {
    public static String url = "jdbc:mysql://localhost:3306/MercadoPI";
    public static String usuario = "root";
    public static String senha = "Nicolasvs1";
    
    /**
     * Metodo para salvar dados
     * @param obj Recebe um objeto da classe Cliente
     * @return boolean true:sucesso false:falha
     */
    public static boolean salvar(Cliente obj){
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
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO cliente(nome, cpf, cep, cidade, estado, rua, email, numeroResidencia, telefone, dataNascimento, genero, estadoCivil) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            
            // 4 - passar parametros para o comando sql
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.getCPF());
            comandoSQL.setString(3, obj.getCEP());
            comandoSQL.setString(4, obj.getCidade());
            comandoSQL.setString(5, obj.getEstado());
            comandoSQL.setString(6, obj.getRua());
            comandoSQL.setString(7, obj.getEmail());
            comandoSQL.setInt(8, obj.getNumero());
            comandoSQL.setString(9, obj.getTelefone());
            java.sql.Date sqlDate = new java.sql.Date(obj.getDatanascimento().getTime());
            comandoSQL.setDate(10, sqlDate);
            comandoSQL.setString(11, obj.getGenero());
            comandoSQL.setString(12, obj.getEstadoCivil());
            
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
     * @param obj Recebe um objeto da classe Cliente
     * @return boolean true:sucesso false:falha
     */
    public static boolean alterar(Cliente obj){
        boolean retorno = false;
        
        Connection conexao = null;
        
        
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, cep = ?, cidade = ?, estado = ?, rua = ?, email = ?, numeroResidencia = ?, telefone = ?, dataNascimento = ?, genero = ?, estadoCivil = ? WHERE cpf=?");
            
            // 4 - passar parametros para o comando sql
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.getCPF());
            comandoSQL.setString(3, obj.getCEP());
            comandoSQL.setString(4, obj.getCidade());
            comandoSQL.setString(5, obj.getEstado());
            comandoSQL.setString(6, obj.getRua());
            comandoSQL.setString(7, obj.getEmail());
            comandoSQL.setInt(8, obj.getNumero());
            comandoSQL.setString(9, obj.getTelefone());
            java.sql.Date sqlDate = new java.sql.Date(obj.getDatanascimento().getTime());
            comandoSQL.setDate(10,sqlDate);
            comandoSQL.setString(11, obj.getGenero());
            comandoSQL.setString(12, obj.getEstadoCivil());
            comandoSQL.setString(13, obj.getCPF());
           
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
     * @param cpf Recebe o respectivo cpf da ocorrencia a ser excluida
     * @return boolean true:sucesso false:falha
     */
    public static boolean excluir(String cpf){
        boolean retorno = false;
        
        Connection conexao = null;
        
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
            
            // 4 - passar parametros para o comando sql
            comandoSQL.setString(1, cpf);
            
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
     * @return ArrayList Lista de Clientes
     */
    public static ArrayList<Cliente> listar(){
        ArrayList<Cliente> lstNotas = new ArrayList<>();
        
        Connection conexao = null;
        ResultSet rs = null;
        
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente");
            
            // 4 - Executar comando
            
            rs = comandoSQL.executeQuery();
            
            //Enquanto houver linha no SELECT add o objeto na lista de retorno
            //nome, cpf, cep, cidade, estado, rua, email, numeroResidencia, telefone, dataNascimento
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String rua = rs.getString("rua");
                String email = rs.getString("email");
                int numeroResidencia = rs.getInt("numeroResidencia");
                String telefone = rs.getString("telefone");
                Date dataNascimento = rs.getDate("dataNascimento");
                String genero = rs.getString("genero");
                String estadoCivil = rs.getString("estadoCivil");
                
                
                Cliente item = new Cliente(nome, cpf, cep, cidade, estado, rua, email, estadoCivil, genero, numeroResidencia, telefone, dataNascimento);
                lstNotas.add(item);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstNotas;
    }
    
    /**
     * Metodo para listar todos os registros do tabela com base em um filtro definido
     * @param cpfx Valor utilizado como filtro para a busca
     * @return ArrayList Lista de Clientes
     */
    public static ArrayList<Cliente> buscarNumero(String cpfx){
        ArrayList<Cliente> lstNotas = new ArrayList<>();
        
        Connection conexao = null;
        ResultSet rs = null;
        
        try {
            // 1 - carregar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2 - Abrir conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            
            // 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf=?");
            
            comandoSQL.setString(1, cpfx);
            
            // 4 - Executar comando
            
            rs = comandoSQL.executeQuery();
            
            //Enquanto houver linha no INSERT add o objeto na lista de retorno
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String rua = rs.getString("rua");
                String email = rs.getString("email");
                int numeroResidencia = rs.getInt("numeroResidencia");
                String telefone = rs.getString("telefone");
                Date dataNascimento = rs.getDate("dataNascimento");
                String genero = rs.getString("genero");
                String estadoCivil = rs.getString("estadoCivil");
                
                Cliente item = new Cliente(nome, cpf, cep, cidade, estado, rua, email, estadoCivil, genero, numeroResidencia, telefone, dataNascimento);
                lstNotas.add(item);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lstNotas;
    }
}

