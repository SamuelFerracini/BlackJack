package blackjack.entities;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    public Jogador sorteiaJogador(Jogador bot, Jogador humano) {
        if (Math.random() <= 0.5) {
            return bot;
        }
        return humano;
    }

    public Jogo(Jogador bot, Jogador humano, Baralho baralho) {
        Jogador jogador = sorteiaJogador(bot, humano);
        int trigger;
        if (jogador.equals(bot)) {
            trigger = 1;
        } else {
            trigger = 2;
        }
        System.out.println("O jogador selecionado para comecar foi o " + jogador.getNome());
        while (true) {
            if (humano.getParou() == true && bot.getParou() == true) {
                System.out.println(humano.getSoma());
                System.out.println(bot.getSoma());

            }
            if (trigger % 2 == 0) {
                if (humano.getParou()) {
                    System.out.println("O humano parou com " + humano.getSoma());

                    break;
                }
                if (jogada(humano, baralho)) {
                    System.out.println("O humano estourou com " + humano.getSoma());
                    break;
                }

            } else {
                if (bot.getParou()) {
                    System.out.println("O bot perdeu com " + bot.getSoma());
                    break;
                }
                if (jogada(bot, baralho)) {
                    System.out.println("O bot estourou com " + bot.getSoma());
                    break;
                }
            }

            trigger++;
        }

    }

    public boolean jogada(Jogador jogador, Baralho baralho) {
        System.out.println("É a vez do " + jogador.getNome());
        System.out.println("O valor de suas cartas é: " + jogador.getSoma());
        System.out.println("Você deseja comprar uma carta do baralho? (1 - 0))");
        int resposta;
        Scanner sc = new Scanner(System.in);
        if (jogador.getNome() == "Bot") {
            resposta = jogador.jogadaBot();
        } else {
            resposta = sc.nextInt();
        }
        if (resposta == 1) {
            Carta cartaSacada = baralho.removeCarta();
            jogador.adicionaCarta(cartaSacada);
            jogador.somaValores();
            if (jogador.getSoma() > 21) {
                return true;
            } else if (jogador.getSoma() == 21) {
                return false;
            }
        }
        if (resposta == 0) {
            jogador.setParou(Boolean.TRUE);
        }
        return false;
    }

    public void mostraSoma(Jogador jogador) {
        System.out.println("O valor da sua mão é de " + jogador.getSoma());
    }
}
