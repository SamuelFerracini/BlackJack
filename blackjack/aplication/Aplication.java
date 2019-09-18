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
        Baralho baralho = new Baralho( );
        baralho.embaralhar();
        ArrayList<Carta> maoJogador = new ArrayList<Carta>();
        maoJogador.add(baralho.removeCarta());
        maoJogador.add(baralho.removeCarta());
        Humano humano = new Humano(maoJogador, "Humano");
        ArrayList<Carta> maoBot = new ArrayList<Carta>();
        maoBot.add(baralho.removeCarta());
        maoBot.add(baralho.removeCarta());
        Bot bot = new Bot(maoBot);
        Jogo jogo = new Jogo(bot, humano, baralho);

    }
}
