/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas
 */
public class Pilha {
    
    public Object pessoa[][];
    int top;
    int max;
    int tam;
    
    public void push(String nome, int idade){
        if(tam >= max){
            JOptionPane.showMessageDialog(null, "Pilha Completa.");
            return;
        }
        top++;
        pessoa[top][0] = nome;
        pessoa[top][1] = idade;
        tam++;
    }
    
    public void listar(){
        if(tam==0){
            JOptionPane.showMessageDialog(null, "Pilha Vazia.");
            return;
        }
        String lista = "Nome/Idade:";
        for(int i = top;i>=0;i--){
            lista += String.format("\n%s, %d", pessoa[i][0],pessoa[i][1]);
        }
        JOptionPane.showMessageDialog(null, lista);
    }
    
    public void pop(){
        if(tam==0){
            JOptionPane.showMessageDialog(null, "Pilha Vazia.");
            return;
        }
        
        pessoa[top][0] = null;
        pessoa[top][1] = null;
        top--;
        tam--;
        JOptionPane.showMessageDialog(null, "Topo removido");
    }
    
    public void destrutor(){
        if(tam==0){
            JOptionPane.showMessageDialog(null, "Pilha Vazia.");
            return;
        }
        pessoa[top][0] = null;
        pessoa[top][1] = null;
        top--;
        tam--;
        destrutor();
    }
    
    public boolean vazio(){
        if(top==-1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean cheio(){
        if(tam==max){
            return true;
        }else{
            return false;
        }
    }
    
    public Pilha(int max){
        this.max = max;
        this.top = -1;
        pessoa = new Object[max][2];
    }
}
