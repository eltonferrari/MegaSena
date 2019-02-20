package megasena;

// @author Elton
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MegaSenaParcer {

    private int numeroConcurso;
    private String data;
    private int n1;
    private int n2;
    private int n3;
    private int n4;
    private int n5;
    private int n6;
    private Jogo jogo;
    private Jogo jogoOrdenado;                
    private int[] jogoContado = new int[60];   
    private int[] contagem = new int[60];
    int[] maiores = new int [60];
    int maior1, maiorI1 = 0;
    int maior2, maiorI2 = 0;
    int maior3, maiorI3 = 0;
    List listaJogos = new ArrayList<>();

    public MegaSenaParcer(String ms) {
        LeituraJogo(ms);
    }

    private void LeituraJogo(String f) {
        try {
            Scanner scan = new Scanner(new File(f));
            scan.useDelimiter(";");
            Jogo jogo, jogoOrdenado , jogoContado = null;
            while (scan.hasNext()) {
                String dados = scan.nextLine();
                String[] linha = dados.split(";");
                numeroConcurso = Integer.parseInt(linha[0]);
                n1 = Integer.parseInt(linha[2]);
                n2 = Integer.parseInt(linha[3]);
                n3 = Integer.parseInt(linha[4]);
                n4 = Integer.parseInt(linha[5]);
                n5 = Integer.parseInt(linha[6]);
                n6 = Integer.parseInt(linha[7]);
                jogo = new Jogo(n1, n2, n3, n4, n5, n6);
                jogoOrdenado = jogo.ordena();
                this.jogoContado = jogo.contaJogo(contagem, jogoOrdenado);
                Concurso concurso = new Concurso(numeroConcurso,linha[1],jogoOrdenado);
                System.out.println(concurso);
                listaJogos.add(jogo);                
            }            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MegaSenaParcer.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 60; i ++) {
            System.out.println("Nº: " + (i + 1) + " X " + jogoContado[i]);
        }
        
       maiores = jogoContado;
        for (int i = 0; i < 60; i++) {
            if (maiores[i] >= maior1) {
                maior3 = maior2;
                maiorI3 = maiorI2;
                maior2 = maior1;
                maiorI2 = maiorI1;
                maior1 = maiores[i];
                maiorI1 = i;
            }
            if ((maiores[i] >= maior2) && (maiores[i] <= maior1)) {
                maior3 = maior2;
                maiorI3 = maiorI2;
                maior2 = maiores[i];
                maiorI2 = i;
            }
            if ((maiores[i] >= maior3) && (maiores[i] <= maior2)) {
                maior3 = maiores[i];
                maiorI3 = i;
            }
        }
        System.out.println("Os 3 nºs mais sorteados são: " + (maiorI1 + 1) + ", " + (maiorI2 + 1) + " e " + (maiorI3 + 1) + ".");
        
        
        
                
        
        
        
                
        
        
        
        
       
    /*public String menores(int[] contagem){
        this.maiores = contagem;
        for (int i = 0; i < 60; i++) {
            if (this.maiores[i] <= menor1) {
                menor3 = menor2;
                menor2 = menor1;
                menor1 = i;
            }
            if ((this.maiores[i] <= menor2) && (this.maiores[i] >= menor1)) {
                menor3 = menor2;
                menor2 = i;
            }
            if ((this.maiores[i] <= menor3) && (this.maiores[i] >= menor2)) {
                maior3 = i;
            }
        }
        return "Os 3 nºs mais sorteados são: " + (menor1 + 1) + ", " + (menor2 + 1) + " e " + (menor3 + 1) + ".";
    }     */       
    
        
        
        
        
        
    }
}