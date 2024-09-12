/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;

import java.util.Date;

/**
 *
 * @author Nicolas
 */
public class Cliente {
    private String Nome;
    private String CPF;
    private String CEP;
    private String Cidade;
    private String Estado;
    private String Rua;
    private String Email;
    private String EstadoCivil;
    private String Genero;
    
    private int Numero;
    private String Telefone;
    private Date Datanascimento;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public Date getDatanascimento() {
        return Datanascimento;
    }

    public void setDatanascimento(Date Datanascimento) {
        this.Datanascimento = Datanascimento;
    }

    public Cliente() {
    }

    public Cliente(String Nome, String CPF, String CEP, String Cidade, String Estado, String Rua, String Email, String EstadoCivil, String Genero, int Numero, String Telefone, Date Datanascimento) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.CEP = CEP;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.Rua = Rua;
        this.Email = Email;
        this.EstadoCivil = EstadoCivil;
        this.Genero = Genero;
        this.Numero = Numero;
        this.Telefone = Telefone;
        this.Datanascimento = Datanascimento;
    }
    
    
    
}
