package com.mycompany.aula01;

import javax.swing.JOptionPane;

public class Aula01 {
	
	public static int pos = -1;
	public static String nome[] = new String[20];
	public static double nota1[] = new double[20];
	public static double nota2[] = new double[20];
	public static double media[] = new double[20];
	
	public static void ler(String nom, double n1, double n2) {
		
		if(pos==5) {
			return;
		}
		
		pos++;
		nome[pos] = nom;
		nota1[pos] = n1;
		nota2[pos] = n2;
		media[pos] = (n1+n2)/2;
	}
	
	public static void listar() {
		
		String saida = "";
		
		for(int i=0;i<=pos;i++) {
			saida += nome[i] + " " + media[i] + "\n";
		}
		
		JOptionPane.showMessageDialog(null, saida);
		
	}
	
	public static void main(String[] args) {
		String nome;
		double n1, n2;
		int alunos = 5;
		
		for(int i=0; i<alunos; i++) {
			nome = JOptionPane.showInputDialog("Digite o nome");
			n1 = Double.parseDouble(JOptionPane.showInputDialog("digite a nota 1"));
			n2 = Double.parseDouble(JOptionPane.showInputDialog("digite a nota 2"));
			
			ler(nome, n1, n2);
		}
		
		listar();
	}
}
