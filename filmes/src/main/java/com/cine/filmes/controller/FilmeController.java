package com.cine.filmes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cine.filmes.model.Filme;

@Controller
public class FilmeController {      

    private List<Filme> listaFilmes = new ArrayList<>();

     @PostMapping("/cadastrar")
    public String cadastrarFilme(@RequestParam String titulo, 
                                 @RequestParam String sinopse, 
                                 @RequestParam String genero, 
                                 @RequestParam int anoLancamento,
                                 Model model) {
        Filme filme = new Filme(titulo, sinopse, genero, anoLancamento);
        listaFilmes.add(filme);
        model.addAttribute("mensagem", "Filme cadastrado com sucesso!");
        return "redirect:/cadastrar"; // Redireciona para o formulário de cadastro
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "index";
    }

    @GetMapping("/detalhes")
    public String detalhes(){
        return "detalhes";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "cadastrar";
    }

    @GetMapping("/listar")
    public String listar(){
        return "listar";
    }
}
 