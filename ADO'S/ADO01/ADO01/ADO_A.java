package ADO01;

import javax.swing.JOptionPane;

public class ADO_A {

    public static int[] vetor;

    public static int[] CriaVetor(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + String.format("%dº ", (i + 1)) + "numero do vetor: "));
        }
        return vetor;
    }

    public static void ExibeVetor(int[] vetor) {
        String saida = "";

        for (int i = 0; i < vetor.length; i++) {
            saida += vetor[i];
            saida += "\n";
        }

        JOptionPane.showMessageDialog(null, saida);
    }

    public static void main(String[] args) {
        vetor = new int[10];

        vetor = CriaVetor(vetor);
        ExibeVetor(vetor);
    }
}
