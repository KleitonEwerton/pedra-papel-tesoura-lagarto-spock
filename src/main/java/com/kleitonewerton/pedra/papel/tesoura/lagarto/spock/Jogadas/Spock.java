/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author KleitonEwerton
 */
public class Spock extends Jogada{
    
    public Spock(){
        this.opcao = "S";
        this.venceDe = new ArrayList<>(Stream.of("T", "R").collect(Collectors.toList()));
        this.perdePara = new ArrayList<>(Stream.of("P", "L").collect(Collectors.toList()));
    }
    @Override
    public String classGetSimpleName() {
        return Spock.class.getSimpleName();
    }
    
}
