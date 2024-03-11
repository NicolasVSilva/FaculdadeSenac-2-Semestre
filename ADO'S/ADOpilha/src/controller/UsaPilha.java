/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Pilha;

/**
 *
 * @author Nicolas
 */
public class UsaPilha {
    public static void main(String[] args) {
        int max = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos a lista possui?"));
        Pilha Alunos = new Pilha(max);
        int menu;
        while(true){
            menu = Integer.parseInt(JOptionPane.showInputDialog("*-MENU-*\n1- Push\n2- Listar\n3- Pop\n4- Destruir\n5- Exit"));
            
            switch(menu){
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome: ");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
                    Alunos.push(nome, idade);
                    break;
                case 2:
                    Alunos.listar();
                    break;
                case 3:
                    Alunos.pop();
                    break;
                case 4:
                    Alunos.destrutor();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
        
    }
}
