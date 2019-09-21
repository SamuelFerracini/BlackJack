package aplication;

import blackjack.entities.Baralho;
import blackjack.entities.Bot;
import blackjack.entities.Carta;
import blackjack.entities.Humano;
import blackjack.entities.Jogo;
import java.util.ArrayList;
import java.util.List;

public class Aplication {

    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.embaralhar();
        Humano humano = new Humano(baralho.DistribuiCartas(), "Humano");
        Bot bot = new Bot(baralho.DistribuiCartas());
        Jogo jogo = new Jogo(bot, humano, baralho);

    }
}
