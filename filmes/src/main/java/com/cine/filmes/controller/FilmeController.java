package com.cine.filmes.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cine.filmes.model.Filme;
import com.cine.filmes.util.Util;

@Controller
public class FilmeController {   

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

    @GetMapping("/inicio")
    public String inicio(){
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastro(){
        return "cadastro";
    }

    @GetMapping("/listar")
    public String listar(){
        return "listar";
    }

    public static Filme encontrarFilmePorId(int id) {
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
 