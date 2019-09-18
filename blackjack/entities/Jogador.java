
package blackjack.entities;
import java.util.*;

public class Jogador {
    private ArrayList<Carta>mao;
    private Integer soma = 0;
    private String nome;
    private Boolean parou = false;

    public String getNome() {
        return nome;
    }

    public Jogador(ArrayList<Carta> mao, String nome) {
        this.mao = mao;
        this.nome = nome;
        somaValores();
    }

    public void setParou(Boolean parou) {
        this.parou = parou;
    }

    public Boolean getParou() {
        return parou;
    }

    public Integer getSoma() {
        return soma;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }
    
    public void adicionaCarta(Carta carta){
        this.mao.add(carta);
    }
    
    
    public void somaValores(){
        soma = 0;
        for (Carta carta : mao) {
            soma += carta.getValor();
        }
    }
    
    public void mostraCartas(){
        for (Carta carta : mao) {
            System.out.print(carta.getNipe() + carta.getValor());
            
        }
        System.out.println();
    }
    
    public int jogadaBot(){
        if(getSoma() >= 18)
            return 0;
        return 1;
    }
    
}
