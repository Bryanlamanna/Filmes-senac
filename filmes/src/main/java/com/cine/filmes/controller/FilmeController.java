package com.cine.filmes.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cine.filmes.model.Analise;
import com.cine.filmes.model.Filme;
import com.cine.filmes.util.Util;

@Controller
public class FilmeController {   
    
    @GetMapping("/detalhes/{id}")
public String exibirDetalhes(@PathVariable("id") int id, Model model) {
    Filme filmeSelecionado = null;
    for (Filme filme : listaFilmes) {
        if (filme.getId() == id) {
            filmeSelecionado = filme;
            break;
        }
    }
    if (filmeSelecionado != null) {
        model.addAttribute("filme", filmeSelecionado);
        return "detalhes";
    } else {
        // Tratar o caso em que o filme não é encontrado
        return "erro";
    }
}

    // Lista de todas as análises
    public static List<Analise> listaAnalise = new ArrayList<>();

    // Lista de todos os filmes
    public static List<Filme> listaFilmes = new ArrayList<>();
     
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
               
            } else {
                model.addAttribute("filmeCadastrado", false);
            }                
       
        return "cadastro";
    }
 
    @GetMapping("/listar-filmes-json")
    @ResponseBody
    public List<Filme> listarFilmesJson() {
        return listaFilmes;
    }


    @PostMapping("/analisar")
    public String analisarFilme(
            @RequestParam("filme") Filme filme,
            @RequestParam("analise") String analiseBody,
            @RequestParam("nota") int nota,
            Model model) {
                Analise analise = new Analise(filme, analiseBody, nota);

                listaAnalise.add(analise);

                return "detalhes";
            }

    @GetMapping("/listar-analises-json")
    @ResponseBody
    public List<Analise> listarAnalisesJson() {
        return listaAnalise;
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

    public Filme encontrarFilmePorId(int id) {
        // Verifica se o ID está dentro dos limites da lista
        if (id >= 0 && id < listaFilmes.size()) {
            // Retorna o filme na posição do índice especificado
            return listaFilmes.get(id);
        } else {
            // Se o ID estiver fora dos limites da lista, retorna null ou lança uma exceção, dependendo dos requisitos do seu aplicativo
            return null; // ou lançar uma exceção de índice inválido
        }
    }
    
}
 