/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.JOptionPane;
import model.Cad2;
/**
 *
 * @author Nicolas
 */
public class ClasseCad2 {
    public Cad2 primeiroNo;
    public Cad2 ultimoNo;
    public int cont;
    
    public ClasseCad2(){
        primeiroNo=null;
        ultimoNo=null;
        cont=0;
    }
    
    public void addCad2(String nome){
        cont++;
        Cad2 Estrutura = new Cad2();
        Estrutura.nome = nome;
        Estrutura.posicao = cont;
        
        if(primeiroNo==null){
            primeiroNo=Estrutura;
        }else{
            ultimoNo.ligaAnterior=Estrutura;
        }
        
        Estrutura.ligaAnterior=null;
        ultimoNo=Estrutura;
    }
    
    public void destrutor(){
        Cad2 temp = primeiroNo;
        
        while(temp!=null){
            temp.nome = null;
            temp.posicao = 0;
            temp = temp.ligaAnterior;
        }
        primeiroNo=null;
        ultimoNo=null;
        JOptionPane.showMessageDialog(null, "EStrutura Destruida");
    }
    
    public void plotCad(){
        Cad2 temp = primeiroNo;
        String saida = "";
        while(temp!=null){
            saida= (temp.nome + "\n"+ saida);
            temp = temp.ligaAnterior;
        }
        JOptionPane.showMessageDialog(null, saida);
    }
    
    public void vazio(){
        if(primeiroNo==null){
            JOptionPane.showMessageDialog(null, "Estrutura Vazia");
        }else{
            JOptionPane.showMessageDialog(null, "A estrutura conta com "+cont+" ligações");
        }
    }
    
    public void busca(int posicao){
        Cad2 tempo = primeiroNo;
        String saida01 = "";
        
        if(cont==0){
            JOptionPane.showMessageDialog(null, "Estrutura Vazia");
        }else if(posicao>cont){
            JOptionPane.showMessageDialog(null, "Posição Inesistente");
        }else{
            for(int i=0;i<=(cont-posicao);i++){
                saida01 = (tempo.nome + ", " + tempo.posicao);
                tempo = tempo.ligaAnterior;
            }
            JOptionPane.showMessageDialog(null, saida01);
        }
    }
    
    public static void main(String[] args) {
        String menu = "1- Adicionar\n2- Listar\n3- Buscar\n4- Deletar\n5- ConferirEstrutura\n6- EXIT";
        int escolha;
        
        ClasseCad2 obj2 = new ClasseCad2();
        while(true){
            escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch(escolha){
                case 1:
                    String dado = JOptionPane.showInputDialog("Digite o nome");
                    obj2.addCad2(dado);
                    break;
                case 2: 
                    obj2.plotCad();
                    break;
                case 3:
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição: "));
                    obj2.busca(posicao);
                    break;
                case 4:
                    obj2.destrutor();
                    break;
                case 5:
                    obj2.vazio();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
