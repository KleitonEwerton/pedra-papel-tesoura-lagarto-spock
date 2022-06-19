/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.pedra.papel.tesoura.lagarto.spock;

import com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas.Jogada;
import static com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Sistema.numeroValido;
import static com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Sistema.scanner;
import static com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Sistema.selecoesValidas;
import static com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Sistema.typeJogada;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author KleitonEwerton
 */
public class ModePVP {

    private Map<String, Integer> jogadores = new HashMap<>();
    private Map<String, Jogada> rodada = new HashMap<>();
    private int bigValue;

    public void pvp() {

        System.out.println("Quantos participantes?");
        int participantes = numeroValido();

        for (int i = 0; i < participantes; i++) {

            System.out.println("Seu nome jogador " + (i + 1));
            jogadores.put("Jogador "+ (i+1) + ": "+scanner.next(), 0);
        } 
        for (String mapKey : jogadores.keySet()) {
            System.out.println("\n" + mapKey + " faça sua jogada");

            String jogada = selecoesValidas();
            if (jogada.equals("Q")) {
                return;
            }

            rodada.put(mapKey, typeJogada(jogada));
        }
        
        avaliaJogadas();
        ordena();
        print();
        vencedores();

    }

    private void avaliaJogadas() {
        for (String mapKey1 : rodada.keySet()) {
            for (String mapKey2 : rodada.keySet()) {
                if (rodada.get(mapKey1).win(rodada.get(mapKey2).toString())) {
                    jogadores.put(mapKey1, jogadores.get(mapKey1) + 1);
                }
            }
        }
    }

    private void ordena() {
        //Ordem crescente: pior desempenho para o maior desempenho
        jogadores = jogadores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }

    private void print() {
        for (String mapKey : jogadores.keySet()) {
            System.out.println("O jogador " + mapKey + " venceu de " + jogadores.get(mapKey) + " jogadores");
            this.bigValue = jogadores.get(mapKey);
        }
    }

    private void vencedores() {
        System.out.println("\nMaiores vencedores: ");
        for (String mapKey : jogadores.keySet()) {
            if (jogadores.get(mapKey) == this.bigValue) {
                System.out.println("Jogador " + mapKey + " com " + jogadores.get(mapKey) + " vitórias");
            }
        }
    }
}
