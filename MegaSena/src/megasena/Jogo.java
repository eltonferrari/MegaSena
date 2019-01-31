/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;

import java.util.Arrays;

/**
 *
 * @author elton
 */
class Jogo {
    
    private Numero n1, n2, n3, n4, n5, n6;

    public Jogo() {
    }

    public Jogo(Numero n1, Numero n2, Numero n3, Numero n4, Numero n5, Numero n6) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.n6 = n6;
    }

    public Numero getN1() {
        return n1;
    }

    public void setN1(Numero n1) {
        this.n1 = n1;
    }

    public Numero getN2() {
        return n2;
    }

    public void setN2(Numero n2) {
        this.n2 = n2;
    }

    public Numero getN3() {
        return n3;
    }

    public void setN3(Numero n3) {
        this.n3 = n3;
    }

    public Numero getN4() {
        return n4;
    }

    public void setN4(Numero n4) {
        this.n4 = n4;
    }

    public Numero getN5() {
        return n5;
    }

    public void setN5(Numero n5) {
        this.n5 = n5;
    }

    public Numero getN6() {
        return n6;
    }

    public void setN6(Numero n6) {
        this.n6 = n6;
    }

    public Jogo ordena() {
        Jogo ordenado;
        Numero[] list = new Numero[6];
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

    @Override
    public String toString() {
        return "Jogo{" + "n1=" + n1 +
                       ", n2=" + n2 + 
                       ", n3=" + n3 + 
                       ", n4=" + n4 + 
                       ", n5=" + n5 + 
                       ", n6=" + n6 + 
                   '}';
    }
}