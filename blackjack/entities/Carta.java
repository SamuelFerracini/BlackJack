
package blackjack.entities;

public class Carta {
    private String nipe;
    private String  tipo;
    private int valor;

    public Carta(String nipe, String tipo, int valor) {
        this.nipe = nipe;
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carta{" + "nipe=" + nipe + ", tipo=" + tipo + ", valor=" + valor + '}';
    }
    
    public String getNipe() {
        return nipe;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }
    
   
       
}
