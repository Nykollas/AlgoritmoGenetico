/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogeneticojava;
import java.util.Vector;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AlgoritmoGenetico {
    private int tamCromossomo=0,numGeracoes,tamPopulacao,
                 probMutacao,qtdeCruzamentos;
    private double capacidade = 0;
    private Vector populacao;
    private Vector<Produto> produtos = new Vector();
    private Vector<Integer> roleta = new Vector();
    //--------------------------------
    private void carregaArquivo(){
       String csvFile = "dados.csv";
        String line = "";
        String[] produto = null;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                produto = line.split(",");
                Produto prod = new Produto();
                prod.setDescrição(produto[0]);
                prod.setPeso(Double.parseDouble(produto[1]));
                prod.setValor(Double.parseDouble(produto[2]));
                produtos.add(prod);
                prod.show();
                this.tamCromossomo++;
            }// fim percurso no arquivo
            
            System.out.println("Tamanho do cromossomo:"+this.tamCromossomo);
           // this.tamCromossomo = desc_items.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //-------------------------
    private Vector criaCromossomo(){
        Vector cromossomo = new Vector();
        for(int i=0;i<this.tamCromossomo;i++){
            if(Math.random()<0.6)
                 cromossomo.add(0);
            else
                cromossomo.add(1);
        }// fim for
           return cromossomo;
    }
  //---------------------------------- 
    private void criaPopulacao(){
       populacao = new Vector();
       for(int i=0; i<this.tamPopulacao;i++)
           populacao.add(criaCromossomo());
    }
    //----------------------------------
    /* private double fitness(Vector cromossomo) {
        
    }
    //--------------------------------------
     protected int obterMelhor(){

    }// fim funcao
    //-------------------------------------------------    
     protected int obterPior(){
       
    }// fim funcao
    //------------------------------------------------
     private Vector cruzamento(){
         
     }
     //---------------------------------------------
     private void mutacao(Vector filho){
       
     }
     //------------------------------------------
    
    //---------------------------------------------
     private int torneio(){
        
        
     }
    //-------------------------------------
     private void novaPopulacao(){
       
     }
     //--------------------------------
     private void operadoresGeneticos(){
         
     }*/
   //------------------------------------------  
    public void mostraPopulacao(){
        System.out.println("População\n"+populacao);
    }
    //-------------------------
    public void executaAG(){ 
           criaPopulacao();
           mostraPopulacao();
    }   // fim executa
    //--------------------------
    public AlgoritmoGenetico(int numGeracoes,
            int tamPopulacao,int probMutacao,int qtdeCruzamentos, double capacidade){
         this.numGeracoes = numGeracoes;
         this.tamPopulacao = tamPopulacao;
         this.probMutacao = probMutacao;
         this.qtdeCruzamentos = qtdeCruzamentos;
         this.capacidade = capacidade;
         this.carregaArquivo();
         
    }
    //----------------------------

}// fim classe
