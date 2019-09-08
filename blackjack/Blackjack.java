package blackjack;
import java.util.*;

public class Blackjack {

    public static void main(String[] args) {
        //A-1,2,3,4,5,6,7,8,9,10,V-10,D-10,R-10
        // ♥, ♦, ♣, ♠
            String[] valores = new String[]{"A-1","2","3","4","5","6","7","8","9","10","V","D","R"};
            String[] naipes = new String[]{"♥", "♦", "♣", "♠"};
            Baralho baralho = new Baralho(valores, naipes);
            baralho.mostraCartas();
    }
    
}
