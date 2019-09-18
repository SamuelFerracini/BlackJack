package blackjack.entities;

import java.util.*;

public class Baralho {
    private ArrayList<Carta> baralho;

    public Baralho() {
        String naipes[] = {"♥", "♦", "♣", "♠"};
        String numeros[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "D", "V", "R"};
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        int tempValor;
        for (String valor : numeros) {
            for (String naipe : naipes) {
                if(valor.contains("V") || valor.contains("D") || valor.contains("R")){
                    tempValor =  10;
                }else if(valor.contains("A")){
                    tempValor = 1;
                }else{
                    tempValor = Integer.parseInt(valor);
                }                
                cartas.add(new Carta(naipe, valor, tempValor));
            }
        }

        this.baralho = cartas;
    }

     public void mostraBaralho(){
        for(Carta carta : baralho){
            System.out.println(carta);
        }
        System.out.println(baralho.size());
    }

     public void embaralhar(){
         Collections.shuffle(baralho, new Random());
     }
    
     
     public Carta removeCarta(){
         Carta carta = baralho.get(0); 
         baralho.remove(0);
         return carta;
     }
}
