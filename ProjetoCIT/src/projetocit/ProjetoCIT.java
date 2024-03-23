package projetocit;

import javax.swing.JOptionPane;
/**
 *
 * @author Nicolas
 */
public class ProjetoCIT {

    public static int lerTamanho() {
        while (true) {
            try {
                int tam = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de valores N: "));
                if (tam >= 1 && tam <= 10) {
                    return tam;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor digite um valor valido");
            } catch (Exception e) {
            }
        }
    }

    public static int[] criaVetor(int tamanho) {
        int vetor[] = new int[tamanho];
        boolean controlador;

        for (int i = 0; i < tamanho; i++) {
            controlador = true;
            while (controlador) {
                try {
                    vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite a expressão T: "));
                    controlador = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor digite um valor valido");
                } catch (Exception e) {
                }
            }
        }
        return vetor;
    }

    public static double[] separaValor(int[] vetor) {
        double[] potencia = new double[vetor.length];
        int expoente;
        int mod = 10;
        String elemento;

        for (int i = 0; i < vetor.length; i++) {
            elemento = Integer.toString(vetor[i]);
            switch (elemento.length()) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Expressão Invalida!!!");
                    System.exit(0);
                    break;
                case 2:
                    expoente = vetor[i] % mod;
                    potencia[i] = Math.pow(((vetor[i]/mod)-(expoente/mod)), expoente);
                    break;
                case 3:
                    expoente = vetor[i] % mod;
                    potencia[i] = Math.pow(((vetor[i]/mod)-(expoente/mod)), expoente);
                    break;
                case 4:
                    expoente = vetor[i] % mod;
                    potencia[i] = Math.pow(((vetor[i]/mod)-(expoente/mod)), expoente);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Expressão Invalida!!!");
                    System.exit(0);
                    break;
            }
        }
        return potencia;
    }

    public static int somaVetor(int[] vetor) {
        double valor[] = separaValor(vetor);
        int soma = 0;

        for (double N : valor) {
            soma += N;
        }
        if (soma > Math.pow(10, 9)) {
            JOptionPane.showMessageDialog(null, "Expressão Invalida");
            System.exit(0);
        }
        return soma;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int tamanho = lerTamanho();
        int vetor[] = criaVetor(tamanho);
        int soma = somaVetor(vetor);

        JOptionPane.showMessageDialog(null, soma);
    }
}
