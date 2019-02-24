package megasena;

// @author Elton
 
public class Concurso {
    private int numeroConcurso;
    private String data;
    private Jogo jogo;

    public Concurso() {
    }

    public Concurso(int numeroConcurso, String data, Jogo jogo) {
        this.numeroConcurso = numeroConcurso;
        this.data = data;
        this.jogo = jogo;
    }

    public int getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setNumeroConcurso(int numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "Concurso nº " + numeroConcurso + 
               ", Data: " + data + 
               ", Dezenas: " + jogo;
    }      
}