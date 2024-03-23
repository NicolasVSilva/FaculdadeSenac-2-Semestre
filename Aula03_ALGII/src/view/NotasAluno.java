/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JOptionPane;


/**
 *
 * @author nicolas.vsilva2
 */
public class NotasAluno {
    
    public static Aluno tabAluno[];
    public static int pos = -1;
    
    public static void menu(){
        String saida = "";
         saida+= "1 - Criar registro de alunos.\n";
         saida+= "2 - Inserir alunos.\n";
         saida+= "3 - Consultar alunos.\n";
         saida+= "4 - Sair";
         
           int escolha = 0;
           
           do{
               escolha = Integer.parseInt(JOptionPane.showInputDialog(null, saida));
               if(escolha < 1 || escolha > 4){
                   JOptionPane.showMessageDialog(null, "Opção invalida");
               }else{
                   
                   switch(escolha){
                       case 1:
                           criaAlunos();
                           break;
                       case 2:
                           inserirAluno();
                           break;
                       case 3: 
                           listaAlunos();
                           break;
                       case 4:
                           break;
                   }
                   
               }
               
           }while(escolha != 4);
           
        
        
    }
    
    public static void criaAlunos(){
        int tot= Integer.parseInt(JOptionPane.showInputDialog("Quantos Alunos Temos: "));
        tabAluno = new Aluno[tot];
    }
    
    public static void inserirAluno(){
        pos++;
        tabAluno[pos] = new Aluno();
        tabAluno[pos].setNome(JOptionPane.showInputDialog("Digite o nome do aluno: "));
        tabAluno[pos].setP1(Integer.parseInt(JOptionPane.showInputDialog("Nota P1: ")));
        tabAluno[pos].setP2(Integer.parseInt(JOptionPane.showInputDialog("Nota P2: ")));
        tabAluno[pos].setAdo(Integer.parseInt(JOptionPane.showInputDialog("Nota ADO: ")));
        tabAluno[pos].setMedia();
    }
    
    public static void listaAlunos(){
        String lista = "";
        
        for(int i=0;i<tabAluno.length;i++){
            
            if(tabAluno[i].getNome()== null){
                i=tabAluno.length;
            }
            
            lista += tabAluno[i].getNome();
            lista += String.format("%.2f", tabAluno[i].getMedia());
            lista += "\n";
        }
        
        JOptionPane.showMessageDialog(null, lista);
    }
    
    
    public static void main(String[] args) {
        menu();
    }
}



/*
1 - digite a quantidade de alunos
2 - inserir alunos
3 - consultar alunos
4 - sair
*/