/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ADO01;

import javax.swing.JOptionPane;

/**
 *
 * @author nicolas.vsilva2
 */
public class ADO_C {

    public static int[] vetorA;
    public static int[] vetorB;
    public static int[] vetorC;

    public static int[] CriaVetorA(int[] vetorA) {
        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + String.format("%dº ", (i + 1)) + "numero do vetor: "));
        }
        return vetorA;
    }

    public static int[] CriaVetorB(int[] vetorB) {
        for (int i = 0; i < vetorB.length; i++) {
            vetorB[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + String.format("%dº ", (i + 1)) + "numero do vetor: "));
        }
        return vetorB;
    }

    public static int[] CriaVetorC(int[] vetorA, int[] vetorB, int[] vetorC) {
        for (int i = 0; i < vetorC.length; i++) {
            vetorC[i] = vetorA[i] - vetorB[i];
        }
        return vetorC;
    }

    public static void ExibeVetores(int[] vetorA, int[] vetorB, int[] vetorC) {
        String saida1 = "";

        for (int i = 0; i < vetorA.length; i++) {
            saida1 += vetorA[i];
            saida1 += "      ";
            saida1 += vetorB[i];
            saida1 += "      ";
            saida1 += vetorC[i];
            saida1 += "\n";
        }

        JOptionPane.showMessageDialog(null, saida1);
    }

    public static void main(String[] args) {
        vetorA = new int[20];
        vetorB = new int[20];
        vetorC = new int[20];

        CriaVetorA(vetorA);
        CriaVetorB(vetorB);
        CriaVetorC(vetorA, vetorB, vetorC);
        ExibeVetores(vetorA, vetorB, vetorC);
    }
}
