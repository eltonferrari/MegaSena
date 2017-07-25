package megasena;

// @author Elton
 
public class Jogo {
    private int concurso;
    private String data;
    private Numero numero;

    public Jogo(int concurso, String data, Numero numero) {
        this.concurso = concurso;
        this.data = data;
        this.numero = numero;
    }

    public int getConcurso() {
        return concurso;
    }

    public void setConcurso(int concurso) {
        this.concurso = concurso;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return concurso + " - Data: " + data + 
                        " - Números: " + numero.getN1() + 
                        " - " + numero.getN2() + 
                        " - " + numero.getN3() + 
                        " - " + numero.getN4() + 
                        " - " + numero.getN5() + 
                        " - " + numero.getN6();
    }    
}