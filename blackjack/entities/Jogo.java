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
        int inverteJogador;
        if (jogador.equals(bot)) {
            inverteJogador = 1;
        } else {
            inverteJogador = 2;
        }
        System.out.println("O jogador selecionado para comecar foi o " + jogador.getNome());
        while (true) {
            if (humano.getParou() == true && bot.getParou() == true) {
                mostraGanhador(humano, bot);
                return;
            }
            if (inverteJogador % 2 == 0) {
                if (!humano.getParou()) {
                    int resultadoJogada = jogada(humano, baralho);
                    if (resultadoJogada == 1) {
                        System.out.println("O humano bateu 21");
                        return;
                    }else if(resultadoJogada == 2){
                        System.out.println("O Bot ganhou!");
                        return;
                    }
                }

            } else {
                if (!bot.getParou()) {
                    int resultadoJogada = jogada(bot, baralho);
                    if (resultadoJogada == 1) {
                        System.out.println("O bot bateu 21");
                        return;
                    }
                    else if (resultadoJogada == 2) {
                        System.out.println("O Humano ganhou!");
                        return;
                    }
                }
            }

            inverteJogador++;
        }
    }

    public int jogada(Jogador jogador, Baralho baralho) {
        System.out.println("É a vez do " + jogador.getNome());
        if (jogador.getClass() != Bot.class) {
            System.out.println("O valor de suas cartas é: " + jogador.getSoma());
            System.out.println("Você deseja comprar uma carta do baralho? (1 - 0))");
        }

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
            if (jogador.getSoma() < 21) {
                return 0;
            } else if (jogador.getSoma() == 21) {
                return 1;
            }else{
                System.out.println("O jogador " + jogador.getNome() + " estourou com " + jogador.getSoma());
                return 2;
            }
        }
        if (resposta == 0) {
            jogador.setParou(Boolean.TRUE);
            System.out.println("O jogador " + jogador.getNome() + " parou!");
            return 0;
        }
        System.out.println("O jogador " + jogador.getNome() + " fez sua jogada");
        return 0;
    }

    public void mostraSoma(Jogador jogador) {
        System.out.println("O valor da sua mão é de " + jogador.getSoma());
    }

    public void mostraGanhador(Jogador jogador1, Jogador jogador2) {
        System.out.println(jogador1.getNome() + " " + jogador1.getSoma());
        System.out.println(jogador2.getNome() + " " + jogador2.getSoma());
        if (jogador1.getSoma() > jogador2.getSoma()) {
            System.out.println("O jogador " + jogador1.getNome() + " ganhou!! com " + jogador1.getSoma());
        } else if (jogador1.getSoma() < jogador2.getSoma()) {
            System.out.println("O jogador " + jogador2.getNome() + " ganhou!!" + jogador2.getSoma());
        } else {
            System.out.println("Empate!!");
        }
    }
}
