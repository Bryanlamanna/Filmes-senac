/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.filmes.model;

/**
 *
 * @author EvaGL
 */ 

 
public class Analise {
    private int id;
    private Filme filme;
    private String análise;
    private int nota;

    // Construtor
    public Analise(int id, Filme filme, String análise, int nota) {
        this.id = id;
        this.filme = filme;
        this.análise = análise;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getAnálise() {
        return análise;
    }

    public void setAnálise(String análise) {
        this.análise = análise;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    

}
