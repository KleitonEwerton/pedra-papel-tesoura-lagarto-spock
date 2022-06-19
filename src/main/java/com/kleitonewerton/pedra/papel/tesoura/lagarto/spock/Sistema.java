/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.pedra.papel.tesoura.lagarto.spock;

import com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas.Tesoura;
import com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas.Spock;
import com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas.Pedra;
import com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas.Papel;
import com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas.Lagarto;
import com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas.Jogada;
import static com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.ModePVM.pvm;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KleitonEwerton
 */
public class Sistema {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static List<String> listJogadasPossiveis = new ArrayList<>();

    public static void main(String[] args) {
        listJogadasPossiveis.add("R");
        listJogadasPossiveis.add("P");
        listJogadasPossiveis.add("T");
        listJogadasPossiveis.add("L");
        listJogadasPossiveis.add("S");

        initialMenu();
    }

    public static Jogada autoSelect() {

        int rand = random.nextInt(5);

        switch (rand) {

            case (0):
                return typeJogada("R");
            case (1):
                return typeJogada("P");
            case (2):
                return typeJogada("T");
            case (3):
                return typeJogada("L");
            case (4):
                return typeJogada("S");
        }

        return null;
    }

    public static Jogada typeJogada(String jogada) {

        switch (jogada.toUpperCase()) {
            case ("R"):
                return new Pedra();
            case ("P"):
                return new Papel();
            case ("T"):
                return new Tesoura();
            case ("L"):
                return new Lagarto();
            case ("S"):
                return new Spock();
        }
        return null;
    }

    public static void initialMenu() {

        while (true) {
            System.out.println("\nA) PVP (jogador vs jogador)\nB) PVM (jogador vs maquina)\nC) SAIR");
            String selection = scanner.next();
            switch (selection.toUpperCase()) {
                case "A":
                    ModePVP pvp = new ModePVP();
                    pvp.pvp();
                    return;
                case "B":
                    pvm();
                    return;
                case "C":
                    return;
            }
        }
    }

    public static void opcoes() {
        System.out.println("\nHora de jogar");
        System.out.println("Escolha:\n  Pedra(R)\n  Papel(P)\n  Tesoura(T)\n  Lagarto(L)\n  Spock(S)\n  Sair (Q)");
    }

    public static boolean jogadaPossivel(String jogada) {
        return listJogadasPossiveis.contains(jogada);
    }

    public static String selecoesValidas() {

        while (true) {
            opcoes();
            String jogada = scanner.next().toUpperCase();
            if (jogada.toUpperCase().equals("Q")) {
                return "Q";
            }
            if (!Sistema.jogadaPossivel(jogada)) {
                System.out.println("\nJogada inválida");
            } else {
                return jogada.toUpperCase();
            }

        }
    }

    public static int numeroValido() {
        while (true)
        try {
            int numero = Integer.parseInt(scanner.next());
            return numero;
        } catch (Exception e) {
            System.out.println("Numero inválido");
        }
    }
}
