package ADO01;

import javax.swing.JOptionPane;

public class ADO_E {

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
            if (i < vetorA.length) {
                vetorC[i] = vetorA[i];
            } else {
                vetorC[i] = vetorB[i-vetorA.length];
            }
        }
        return vetorC;
    }

    public static void ExibeVetores(int[] vetorA, int[] vetorB, int[] vetorC) {
        String saida1 = "";

        for (int i = 0; i < vetorC.length; i++) {
            saida1 += vetorC[i];
            saida1 += "\n";
        }

        JOptionPane.showMessageDialog(null, saida1);
    }

    public static void main(String[] args) {
        vetorA = new int[15];
        vetorB = new int[15];
        vetorC = new int[30];

        vetorA = CriaVetorA(vetorA);
        vetorB = CriaVetorB(vetorB);
        vetorC = CriaVetorC(vetorA, vetorB, vetorC);
        ExibeVetores(vetorA, vetorB, vetorC);
    }
}
