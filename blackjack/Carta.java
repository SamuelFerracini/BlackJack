package blackjack;

public class Carta {
    private String naipe;
    private String numero;
    private int valor; // A-1,2,3,4,5,6,7,8,9,10,V-10,D-10,R-10
    
 
    public Carta(String naipe, String numero, int valor) {
        this.naipe = naipe;
        this.numero = numero;
        this.valor = valor;
    }

    public String getNumero() {
        return numero;
    }

    public String getNaipe() {
        return naipe;
    }

    public int getValor() {
        return valor;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public void setValor(int valor) {
        this.valor = valor;
    } 
     
}


