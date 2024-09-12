/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controll;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Nicolas
 */

public class Validador {
    
    public static void verificaVazio(JTextField objValidar, JLabel desc){
        if(objValidar.getText().equals(objValidar.getName())){
            objValidar.setText("");
            objValidar.setForeground(Color.black);
            desc.setText("Digite o "+objValidar.getName());
        }else if(objValidar.getText().trim().equals("")){
            objValidar.setForeground(Color.lightGray);
            objValidar.setText(objValidar.getName());
            desc.setText("");
        }
    }
    
    public static void verificaNumero(java.awt.event.KeyEvent evt, JLabel desc, JTextField objValidar){
        char C = evt.getKeyChar();
        if((C<'0'||C>'9')&&(C!=KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            desc.setText("Digite apenas Numeros!!");
        }else{
            desc.setText("Digite o "+objValidar.getName());
        }
    }
    
    public static void verificaCodigoBarra(java.awt.event.KeyEvent evt, JLabel desc, JTextField objValidar){
        verificaNumero(evt, desc, objValidar);
        if(objValidar.getText().length()>13){
            evt.consume();
            desc.setText("Caracteres maximo para o "+objValidar.getName());
        }
    }
    
    public static void verificaCPF(java.awt.event.KeyEvent evt, JLabel desc, JTextField objValidar){
        verificaNumero(evt, desc, objValidar);
        if(objValidar.getText().length()>13){
            evt.consume();
            desc.setText("Caracteres maximo para CPF");
        }else if(objValidar.getText().length()==3||objValidar.getText().length()==7){
            objValidar.setText(objValidar.getText()+".");
        }else if(objValidar.getText().length()==11){
            objValidar.setText(objValidar.getText()+"-");
        }
    }
    
    public static void verificaCEP(java.awt.event.KeyEvent evt, JLabel desc, JTextField objValidar){
        verificaNumero(evt, desc, objValidar);
        if(objValidar.getText().length()>8){
            evt.consume();
            desc.setText("Caracteres maximo para CEP");
        }else if(objValidar.getText().length()==5){
            objValidar.setText(objValidar.getText()+"-");
        }
    }
    
    public static void verificaTelefone(java.awt.event.KeyEvent evt, JLabel desc, JTextField objValidar){
        verificaNumero(evt, desc, objValidar);
        if(objValidar.getText().length()>13){
            evt.consume();
            desc.setText("Caracteres maximo para Telefone");
        }else if(objValidar.getText().length()==0){
            objValidar.setText("(");
        }else if(objValidar.getText().length()==3){
            objValidar.setText(objValidar.getText()+")");
        }else if(objValidar.getText().length()==9){
            objValidar.setText(objValidar.getText()+"-");
        }
    }
    
    public static void verificaData(java.awt.event.KeyEvent evt, JLabel desc, JTextField objValidar){
        verificaNumero(evt, desc, objValidar);
        if(objValidar.getText().length()>9){
            evt.consume();
            desc.setText("Caracteres maximo para Data");
        }else if(objValidar.getText().length()==2||objValidar.getText().length()==5){
            objValidar.setText(objValidar.getText()+"/");
        }
    }
    
    public static void verificaPreco(java.awt.event.KeyEvent evt, JLabel desc, JTextField objValidar){
        verificaNumero(evt, desc, objValidar);
        char c = evt.getKeyChar();
        if(objValidar.getText().length()>8){
            evt.consume();
            desc.setText("Caracteres maximo para Preço");
        }else if(c==','||c=='.'){
            objValidar.setText(objValidar.getText()+'.');
        }
    }
    
    public static boolean verificaObrigatorioCliente(JTextField Nome, JTextField CPF, JTextField CEP,
            JTextField Cidade, JTextField Estado, JTextField Rua, JTextField Numero, JTextField Email, JComboBox Sexo){
       
        if(Nome.getText().trim().equals(Nome.getName())){
            JOptionPane.showMessageDialog(null, "Preencha o Nome");
            return false;
        }else if(CPF.getText().trim().equals(CPF.getName())){
            JOptionPane.showMessageDialog(null, "Preencha o CPF");
            return false;
        }else if(CPF.getText().length()!=14){
            JOptionPane.showMessageDialog(null, "Preencha o CPF completo");
            return false;
        }else if(CEP.getText().trim().equals(CEP.getName())){
            JOptionPane.showMessageDialog(null, "Preencha o CEP");
            return false;
        }else if(CEP.getText().length()!=9){
            JOptionPane.showMessageDialog(null, "Preencha o CEP completo");
            return false;
        }else if(Cidade.getText().trim().equals(Cidade.getName())){
            JOptionPane.showMessageDialog(null, "Preencha a Cidade");
            return false;
        }else if(Estado.getText().trim().equals(Estado.getName())){
            JOptionPane.showMessageDialog(null, "Preencha o Estado");
            return false;
        }else if(Rua.getText().trim().equals(Rua.getName())){
            JOptionPane.showMessageDialog(null, "Preencha a Rua");
            return false;
        }else if(Numero.getText().trim().equals(Numero.getName())){
            JOptionPane.showMessageDialog(null, "Preencha o numero");
            return false;
        }else if(Email.getText().trim().equals(Email.getName())){
            JOptionPane.showMessageDialog(null, "Preencha o Email");
            return false;
        }else if(Sexo.getSelectedItem().toString().trim().equals("GENERO")){
            JOptionPane.showMessageDialog(null, "Selecione o Sexo");
            return false;
        }else{
            return true;
        }
    }
    
    public static boolean verificaObrigatorioProduto(JTextField Nome, JTextField CodBarras, JTextField Preco,
                                    JTextField Quantidade, JComboBox TipoUnidade){
        
        if(Nome.getText().trim().equals("NomeProduto")){
            JOptionPane.showMessageDialog(null, "Digite o Nome do Produto");
            return false;
        }else if(CodBarras.getText().trim().equals("CodBarras")||CodBarras.getText().length()<13){
            JOptionPane.showMessageDialog(null, "Digite o Codigo de Barras");
            return false;
        }else if(Preco.getText().trim().equals("Preco")){
            JOptionPane.showMessageDialog(null, "Digite o Preco");
            return false;
        }else if(Quantidade.getText().trim().equals("Quantidade")){
            JOptionPane.showMessageDialog(null, "Digite a quantidade");
            return false;
        }else if(TipoUnidade.getSelectedItem().toString().equals("TIPO_UNIDADE")){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de unidade");
            return false;
        }else{
            return true;
        }
    }
}

