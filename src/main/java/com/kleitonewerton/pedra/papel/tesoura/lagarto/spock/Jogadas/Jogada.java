/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.pedra.papel.tesoura.lagarto.spock.Jogadas;

import java.util.List;

/**
 *
 * @author KleitonEwerton
 */
abstract public class Jogada {
    
    protected String opcao;
    protected List<String> perdePara;
    protected List<String> venceDe;
    
    public boolean empate(String jogadaOponente){
        return this.opcao.equals(jogadaOponente.toUpperCase());
    }
    public boolean loss(String jogadaOponente){
        return this.perdePara.contains(jogadaOponente.toUpperCase());
    } 
    public boolean win(String jogadaOponente){
        return this.venceDe.contains(jogadaOponente.toUpperCase());
        
    } 

    @Override
    public String toString() {
        return opcao;
    }
    abstract public String classGetSimpleName();
       
    
    
}
