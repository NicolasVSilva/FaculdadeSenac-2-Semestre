/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;

/**
 *
 * @author Nicolas
 */

public class Venda {
    private int IdVenda;
    private int DataVenda;
    private String CPFCliente;
    private String TipoPagamento;
    private int NumParcdelas;
    private int ValorTotal;

    public int getIdVenda() {
        return IdVenda;
    }

    public void setIdVenda(int IdVenda) {
        this.IdVenda = IdVenda;
    }

    public int getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(int DataVenda) {
        this.DataVenda = DataVenda;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public String getTipoPagamento() {
        return TipoPagamento;
    }

    public void setTipoPagamento(String TipoPagamento) {
        this.TipoPagamento = TipoPagamento;
    }

    public int getNumParcdelas() {
        return NumParcdelas;
    }

    public void setNumParcdelas(int NumParcdelas) {
        this.NumParcdelas = NumParcdelas;
    }

    public int getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(int ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public Venda() {
    }
    
    
}
