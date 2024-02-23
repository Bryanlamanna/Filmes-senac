package com.cine.filmes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmeController {      

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
 