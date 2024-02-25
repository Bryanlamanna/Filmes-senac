package com.cine.filmes.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cine.filmes.model.Filme;
import com.cine.filmes.util.Util;

@Controller
public class FilmeController {      

    private List<Filme> listaFilmes = new ArrayList<>();

    @PostMapping("/cadastrar")
    public String cadastrarFilme(
            @RequestParam("titulo") String titulo,
            @RequestParam("sinopse") String sinopse,
            @RequestParam("genero") String genero,
            @RequestParam("anoLancamento") String anoLancamento,
            Model model) {
        
            Filme filme = new Filme(titulo, sinopse, genero, anoLancamento);
            
            if (!Util.checkData(titulo, sinopse, genero, anoLancamento)) {
                model.addAttribute("filmeCadastrado", true);
                listaFilmes.add(filme);    
                System.out.println("Filme adicionado: " + filme.getTitulo());
            } else {
                model.addAttribute("filmeCadastrado", false);
                System.out.println("Erro ao adicionar o         filme: " + filme.getTitulo());
            }                
       
        return "cadastro";
    }
 
     

    @GetMapping("/inicio")
    public String inicio(){
        return "index";
    }

    @GetMapping("/detalhes")
    public String detalhes(){
        return "detalhes";
    }

    @GetMapping("/cadastro")
    public String cadastro(){
        return "cadastro";
    }

    @GetMapping("/listar")
    public String listar(){
        return "listar";
    }

    
}
 