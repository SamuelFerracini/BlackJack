package blackjack;

import java.util.*;
import javax.transaction.xa.XAResource;

public class Baralho {

    public List<Carta> cartas;

    Baralho() { }
    
    public Baralho(String[] valores, String[] naipes) {
        List<Carta> cartas = new ArrayList<Carta>();
        int tempValor;
        for (String valor : valores) {
            for (String naipe : naipes) {
                if(valor.contains("V") || valor.contains("D") || valor.contains("R")){
                    tempValor =  10;
                }else if(valor.contains("1")){
                    tempValor = 1;
                }else{
                    tempValor = Integer.parseInt(valor);
                }                
                cartas.add(new Carta(naipe, valor, tempValor));
            }
        }

        this.cartas = cartas;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
    
    
    public void mostraCartas(){
        for(Carta carta : cartas){
            System.out.println(carta.getNaipe() + " " + carta.getNumero() + "" + carta.getValor());
        }
    }

    
}


