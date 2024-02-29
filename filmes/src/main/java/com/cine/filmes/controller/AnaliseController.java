package com.cine.filmes.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cine.filmes.model.Analise;
import com.cine.filmes.model.Filme;

@Controller
public class AnaliseController {   
    
    // Lista de todas as an
    
    public static List<Analise> listaAnalise = new ArrayList<>();

    @PostMapping("/analisar")
    public String analisarFilme(
            @RequestParam("idFilme") int idFilme,
            @RequestParam("analise") String analiseBody,
            @RequestParam("nota") int nota,
            Model model) {

            Filme filme = FilmeController.encontrarFilmePorId(idFilme);    
            
            Analise analise = new Analise(filme, analiseBody, nota);
            listaAnalise.add(analise);
            System.out.println(analise.getAnalise());

            return "index";
}

    @GetMapping("/listar-analises-json")
    @ResponseBody
    public List<Analise> listarAnalisesJson() {
        return listaAnalise;
    }
    
}
 