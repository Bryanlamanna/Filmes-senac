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

    @PostMapping("/editar")
    public String salvarEdicao(
            @RequestParam("idFilme") int filmeIndex,
            @RequestParam("titulo") String titulo,
            @RequestParam("sinopse") String sinopse,
            @RequestParam("genero") String genero,
            @RequestParam("anoLancamento") String anoLancamento,
            Model model) {
        
        // Verifica se o índice do filme é válido
        if (filmeIndex >= 0 && filmeIndex < listaFilmes.size()) {
            // Atualiza os detalhes do filme existente
            Filme filme = listaFilmes.get(filmeIndex);
            filme.setTitulo(titulo);
            filme.setSinopse(sinopse);
            filme.setGenero(genero);
            filme.setAnoLancamento(anoLancamento);
        } else {
            // Se o índice for inválido, redireciona para uma página de erro
            return "error";
        }

        // Adiciona um atributo ao modelo indicando que a edição foi salva
        model.addAttribute("edicaoSalva", true);
        // Redireciona de volta para a página que lista os filmes após salvar a edição do filme.
        return "/index";
    }

    @PostMapping("/excluir")
    public String excluirFilme(@RequestParam("idFilme") int filmeIndex, Model model) {
    if (filmeIndex >= 0 && filmeIndex < listaFilmes.size()) {
        listaFilmes.remove(filmeIndex);
        model.addAttribute("filmeExcluido", true);
        // Você pode adicionar uma mensagem de sucesso ou redirecionar para outra página aqui, se necessário.
    } else {
        // Trate o índice inválido adequadamente, por exemplo, redirecionando para uma página de erro.
        return "error";
    }
    // Redireciona de volta para a página que lista os filmes após excluir o filme.
    return "/index";
    
}


     
    @PostMapping("/cadastrar")
    public String cadastrarFilme(
            @RequestParam("titulo") String titulo,
            @RequestParam("sinopse") String sinopse,
            @RequestParam("genero") String genero,
            @RequestParam("anoLancamento") String anoLancamento,
            Model model) {
        
            Filme filme = new Filme(titulo, sinopse, genero, anoLancamento);
            
            if (!Util.checkData(titulo, sinopse, genero, anoLancamento)) {
                listaFilmes.add(filme);    
               
            } else {
                model.addAttribute("filmeCadastrado", false);
            }                
            model.addAttribute("filmeCadastrado", true);

        return "index";
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
        return "index";
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
 