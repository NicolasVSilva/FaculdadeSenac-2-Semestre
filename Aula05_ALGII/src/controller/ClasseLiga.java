/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.JOptionPane;
import model.Cad;
/**
 *
 * @author Nicolas
 */
public class ClasseLiga {
    public Cad primeiroNo;
    public Cad ultimoNo;
    public int cont;
    
    void ClasseLiga(){ //Construtor especalizado
        primeiroNo=null;
        ultimoNo=null;
        cont=0;
    }
    
    public void addCad(String dado){
        Cad newCad = new Cad();
        newCad.dado = dado; //Alimenta os dados do Objeto
        
        if(primeiroNo==null){
            primeiroNo = newCad;
        }else{
            ultimoNo.liga = newCad; //liga ao proximo objeto
        }
        
        newCad.liga = null; // liga do ultimo objeto aponta para null
        ultimoNo = newCad;  // novo objeto se torna o ultimo criado
        cont++;
    }
    
    public void destrutor(){
        Cad temp = primeiroNo;
        
        while(temp!=null){
            temp.dado = null;
            temp = temp.liga;
        }
        primeiroNo=null;
        ultimoNo=null;
        JOptionPane.showMessageDialog(null, "EStrutura Destruida");
    }
    
    public void plotCad(){
        Cad temp = primeiroNo;
        String saida = "";
        while(temp!=null){
            saida+= (temp.dado + "\n");
            temp = temp.liga;
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
        Cad tempo = primeiroNo;
        String saida01 = "";
        
        if(cont==0){
            JOptionPane.showMessageDialog(null, "Estrutura Vazia");
        }else if(posicao>cont){
            JOptionPane.showMessageDialog(null, "Posição Inesistente");
        }else{
            for(int i=0;i<posicao;i++){
                saida01 = (tempo.dado);
                tempo = tempo.liga;
            }
            JOptionPane.showMessageDialog(null, saida01);
        }
    }
    
    public static void main(String[] args) {
        String menu = "1- Adicionar\n2- Listar\n3- Buscar\n4- Deletar\n5- ConferirEstrutura\n6- EXIT";
        int escolha;
        
        ClasseLiga obj1 = new ClasseLiga();
        while(true){
            escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch(escolha){
                case 1:
                    String dado = JOptionPane.showInputDialog("Digite o nome");
                    obj1.addCad(dado);
                    break;
                case 2: 
                    obj1.plotCad();
                    break;
                case 3:
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição: "));
                    obj1.busca(posicao);
                    break;
                case 4:
                    obj1.destrutor();
                    break;
                case 5:
                    obj1.vazio();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}





/*
(Pessoas):
    -Nome = Nicolas

    -Ligação = (Pessoas):
            -Nome = luiz

            -Ligação = (Pessoas):
                    -Nome = Pedro

                    -Ligação = NULL
*/