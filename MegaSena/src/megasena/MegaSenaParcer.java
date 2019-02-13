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
        int maior = 0;
        int menor = 1000;
        int numeroMaior = 0;
        int numeroMenor = 0;
            
        for (int i = 0; i < 60; i ++) {
            if (jogoContado[i] > maior){
                maior = jogoContado[i];
                numeroMaior = i + 1;
            }
            if (jogoContado[i] < menor){
                menor = jogoContado[i];
                numeroMenor = i + 1;
            }
        }
        System.out.println("Nº  mais jogado: " + numeroMaior + ", " + maior + " vezes");
        System.out.println("Nº menos jogado: " + numeroMenor + ", " + menor + " vezes");
    }
}