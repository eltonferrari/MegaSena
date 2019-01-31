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

    private int concurso;
    private String data;
    private Numero n1;
    private Numero n2;
    private Numero n3;
    private Numero n4;
    private Numero n5;
    private Numero n6;
    private Jogo jogo;
    private int[] contador;

    public MegaSenaParcer(String ms) {
        LeituraJogo(ms);
    }

    private void LeituraJogo(String f) {
        try {
            Scanner scan = new Scanner(new File(f));
            scan.useDelimiter(";");
            Concurso jogo = null;
            List listaJogos = new ArrayList<>();
            int[] contagem = new int[60];
            
            while (scan.hasNext()) {
                String dados = scan.nextLine();
                String[] linha = dados.split(";");
                concurso = Integer.parseInt(linha[0]);
                n1 = Integer.parseInt(linha[2]);
                n2 = Integer.parseInt(linha[3]);
                n3 = Integer.parseInt(linha[4]);
                n4 = Integer.parseInt(linha[5]);
                n5 = Integer.parseInt(linha[6]);
                n6 = Integer.parseInt(linha[7]);
                jogo = new Jogo(n1, n2, n3, n4, n5, n6);
                numero = ordena(numero);
                
                contagem(numero);
                jogo = new Concurso(concurso,linha[1],numero);
                System.out.println(jogo);
                listaJogos.add(jogo);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MegaSenaParcer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void contagem(Numero numero) {
        int[] conta = new int[60];
        for (int i = 0; i < 60; i++) {
            conta[i] = 0; 
        }
        int[] list = new int[6];
        list[0] = numero.getN1();
        list[1] = numero.getN2();
        list[2] = numero.getN3();
        list[3] = numero.getN4();
        list[4] = numero.getN5();
        list[5] = numero.getN6();
        for (int i = 0; i < 6; i++) {
            conta[list[i] + 1]++; 
        }
    }
}