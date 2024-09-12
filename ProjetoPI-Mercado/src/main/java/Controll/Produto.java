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

public class Produto {
    private String NomeProduto;
    private String TipoUnidade;
    private String Categoria;
    private String Descricao;
    
    private String CodBarras;
    private int Quantidade;
    private Date DataValidade;
    private float Preco;

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }

    public String getTipoUnidade() {
        return TipoUnidade;
    }

    public void setTipoUnidade(String TipoUnidade) {
        this.TipoUnidade = TipoUnidade;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getCodBarras() {
        return CodBarras;
    }

    public void setCodBarras(String CodBarras) {
        this.CodBarras = CodBarras;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Date getDataValidade() {
        return DataValidade;
    }

    public void setDataValidade(Date DataValidade) {
        this.DataValidade = DataValidade;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public Produto() {
    }

    public Produto(String NomeProduto, String TipoUnidade, String Categoria, String Descricao, String CodBarras, int Quantidade, Date DataValidade, float Preco) {
        this.NomeProduto = NomeProduto;
        this.TipoUnidade = TipoUnidade;
        this.Categoria = Categoria;
        this.Descricao = Descricao;
        this.CodBarras = CodBarras;
        this.Quantidade = Quantidade;
        this.DataValidade = DataValidade;
        this.Preco = Preco;
    }
    
    
}
