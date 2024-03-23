package com.mycompany.menurandom;

import java.util.Random;
import javax.swing.JOptionPane;

public class MenuRandom {

    static int opcao;
    static int quantidade;
    static Random gerar = new Random();
    static int[] numero;

    
    public static void Qnt() {
        int qnt;
        qnt = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de números desejada:"));
        numero = new int[qnt];
        
    }

    public static void Random () {
        for (int i = 0; i < numero.length ; i++) {
            numero[i] = gerar.nextInt(99);
        }
    }

    public static void Listar() {
        String saida = "";

        for (int i = 0; i < numero.length; i++) {
            saida += numero[i] + "\n";
        }

        String teste = "Numeros gerados: " + saida;
        JOptionPane.showMessageDialog(null, teste);

    }

    
    public static void Menu() {
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção:\n"
                    + "\n1 - Quantidade de números"
                    + "\n2 - Gerar número aleatório\n"
                    + "3 - Listar números\n"
                    + "4 - Sair"));

            switch (opcao) {
                case 1:
                         Qnt();

                    break;

                case 2:
                    Random();

                    break;

                case 3:
                    Listar();

                    break;

                case 4:
                              System.exit(0);
                    break;

            }
        } while (opcao != 4);
    }

    
    public static void main(String[] args) {

        Menu();

    }
}
