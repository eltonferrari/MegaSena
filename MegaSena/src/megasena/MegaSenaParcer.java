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
    private int n1;
    private int n2;
    private int n3;
    private int n4;
    private int n5;
    private int n6;
    private Numero numero;
    private int[] contador;

    public MegaSenaParcer(String ms) {
        LeituraJogo(ms);
    }

    private void LeituraJogo(String f) {
        try {
            Scanner scan = new Scanner(new File(f));
            scan.useDelimiter(";");
            Jogo jogo = null;
            List listaJogos = new ArrayList<>();
            int[] contagem = new int[60];
            
            while (scan.hasNext()) {
                String dados = scan.nextLine();
                String[] linhas = dados.split(";");
                concurso = Integer.parseInt(linhas[0]);
                n1 = Integer.parseInt(linhas[2]);
                n2 = Integer.parseInt(linhas[3]);
                n3 = Integer.parseInt(linhas[4]);
                n4 = Integer.parseInt(linhas[5]);
                n5 = Integer.parseInt(linhas[6]);
                n6 = Integer.parseInt(linhas[7]);
                numero = new Numero(n1, n2, n3, n4, n5, n6);
                numero = ordena(numero);
                contagem(numero);
                jogo = new Jogo(concurso,linhas[1],numero);
                System.out.println(jogo);
                listaJogos.add(jogo);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MegaSenaParcer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Numero ordena(Numero numero) {
        Numero ordenado;
        int[] list = new int[6];
        list[0] = numero.getN1();
        list[1] = numero.getN2();
        list[2] = numero.getN3();
        list[3] = numero.getN4();
        list[4] = numero.getN5();
        list[5] = numero.getN6();
        Arrays.sort(list);
        ordenado = new Numero(list[0],list[1],list[2],list[3],list[4],list[5]);
        return ordenado;
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