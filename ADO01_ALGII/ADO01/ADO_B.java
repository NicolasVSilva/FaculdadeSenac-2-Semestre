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
public class ADO_B {

    public static int[] vetorA;
    public static int[] vetorB;
    public static int mult = 3;

    public static int[] CriaVetorA(int[] vetorA) {
        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + String.format("%dº ", (i + 1)) + "numero do vetor: "));
        }
        return vetorA;
    }

    public static int[] CriaVetorB(int[] vetorA, int[] vetorB, int mult) {
        for (int i = 0; i < vetorB.length; i++) {
            vetorB[i] = vetorA[i] * mult;
        }
        return vetorB;
    }

    public static void ExibeVetores(int[] vetorA, int[] vetorB) {
        String saida1 = "";

        for (int i = 0; i < vetorA.length; i++) {
            saida1 += vetorA[i];
            saida1 += "      ";
            saida1 += vetorB[i];
            saida1 += "\n";
        }

        JOptionPane.showMessageDialog(null, saida1);
    }

    public static void main(String[] args) {
        vetorA = new int[8];
        vetorB = new int[8];

        vetorA = CriaVetorA(vetorA);
        vetorB = CriaVetorB(vetorA, vetorB, mult);
        ExibeVetores(vetorA, vetorB);
    }
}
