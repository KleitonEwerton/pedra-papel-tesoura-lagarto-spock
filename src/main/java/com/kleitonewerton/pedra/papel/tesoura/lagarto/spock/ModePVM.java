/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.pedra.papel.tesoura.lagarto.spock;

import com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas.Jogada;
import static com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Sistema.autoSelect;
import static com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Sistema.selecoesValidas;
import static com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Sistema.typeJogada;

/**
 *
 * @author KleitonEwerton
 */
public class ModePVM {

    public static void pvm() {
        String jogada = "";
        while (true) {

            jogada = selecoesValidas();
            if (jogada.equals("Q")) 
                return;
            
            Jogada machine = autoSelect();
            System.out.println("\nA máquina escolheu " + machine.classGetSimpleName() + " e você escolheu " + typeJogada(jogada).classGetSimpleName());
            if (machine.empate(jogada)) {
                System.out.println("Empate");
            } else if (machine.loss(jogada)) {
                System.out.println("Parabens! Vitória");
            } else if (machine.win(jogada)) {
                System.out.println("Não foi dessa vez! Derrota");
            }

        }

    }
}
