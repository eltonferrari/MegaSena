package megasena;

// @author elton

public class Numero {
    
    private int n;
    
    public Numero(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Numero{" + "n=" + n + '}';
    }
}