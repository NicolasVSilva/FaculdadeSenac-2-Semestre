package ADO01;

import javax.swing.JOptionPane;

public class ADO_D {

    public static int[] vetorA;
    public static int[] vetorB;

    public static int[] CriaVetorA(int[] vetorA) {
        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + String.format("%dº ", (i + 1)) + "numero do vetor: "));
        }
        return vetorA;
    }

    public static int[] CriaVetorB(int[] vetorA, int[] vetorB) {
        for (int i = 0; i < vetorB.length; i++) {
            vetorB[i] = (int) Math.pow(vetorA[i], 2);
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
        vetorA = new int[15];
        vetorB = new int[15];

        CriaVetorA(vetorA);
        CriaVetorB(vetorA, vetorB);
        ExibeVetores(vetorA, vetorB);
    }
}
