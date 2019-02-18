/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author elton
 */
class Jogo {
    
    private int n1, n2, n3, n4, n5, n6, 
                maior1 = 0, maior2 = 0, maior3 = 0, 
                menor1 = 1000, menor2 = 1000, menor3 = 1000, 
                numeroMaior = 0, numeroMenor = 0;
    private int[] maiores, menores;
    private int[] conta = new int[60];
    private Jogo jogo;
        
    public Jogo() {
    }

    public Jogo(int n1, int n2, int n3, int n4, int n5, int n6) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.n6 = n6;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN4() {
        return n4;
    }

    public void setN4(int n4) {
        this.n4 = n4;
    }

    public int getN5() {
        return n5;
    }

    public void setN5(int n5) {
        this.n5 = n5;
    }

    public int getN6() {
        return n6;
    }

    public void setN6(int n6) {
        this.n6 = n6;
    }

    public Jogo ordena() {
        Jogo ordenado;
        int[] list = new int[6];
        list[0] = this.n1;
        list[1] = this.n2;
        list[2] = this.n3;
        list[3] = this.n4;
        list[4] = this.n5;
        list[5] = this.n6;
        Arrays.sort(list);
        ordenado = new Jogo(list[0],list[1],list[2],list[3],list[4],list[5]);
        return ordenado;
    }
        
    public int[] contaJogo(int[] contagem, Jogo jogo) {
        this.conta = contagem;
        this.jogo = jogo;
        int[] list = new int[6];
        list[0] = this.jogo.getN1();
        list[1] = this.jogo.getN2();
        list[2] = this.jogo.getN3();
        list[3] = this.jogo.getN4();
        list[4] = this.jogo.getN5();
        list[5] = this.jogo.getN6();
        for(int i = 0; i < 6; i++){
            conta[list[i] - 1] ++; 
        }
        return conta;
    }
    
    public String maiores(int[] contagem){
        this.conta = contagem;
        for (int i = 0; i < 60; i++) {
            if (this.conta[i] >= maior1) {
                maior3 = maior2;
                maior2 = maior1;
                maior1 = i;
            }
            if ((this.conta[i] >= maior2) && (this.conta[i] < maior1)) {
                maior3 = maior2;
                maior2 = i;
            }
            if ((this.conta[i] >= maior3) && (this.conta[i] < maior2)) {
                maior3 = i;
            }
        }
        this.maiores = new int[3];
        this.maiores[0] = maior1;
        this.maiores[1] = maior2;
        this.maiores[2] = maior3;
        return this.maiores;
    }            
    
    public int[] menores(int[] contagem){
        
        return this.conta;
    }

    @Override
    public String toString() {
        return n1 + ", " + 
               n2 + ", " + 
               n3 + ", " + 
               n4 + ", " + 
               n5 + ", " + 
               n6;
    }
}