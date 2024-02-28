package com.cine.filmes;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cine.filmes.model.Filme;
import com.cine.filmes.controller.FilmeController;

@SpringBootApplication
public class FilmesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FilmesApplication.class, args);
		System.out.println("Hello World!");

		

        // Adicionando três filmes aleatórios à lista
        for (int i = 0; i < 9; i++) {
            Filme filme = criarFilmeAleatorio();
            FilmeController.listaFilmes.add(filme);
        }

        // Exibindo os filmes adicionados
        for (Filme filme : FilmeController.listaFilmes) {
            System.out.println(filme);
        }
    }

    // Método para criar um filme aleatório
    private static Filme criarFilmeAleatorio() {
        String[] titulos = {
            "Matrix",
            "Senhor dos Anéis",
            "Interestelar",
            "Pulp Fiction",
            "Jurassic Park",
            "Star Wars",
            "Indiana Jones",
            "O Wall Street",
            "Street 2",
            "Cidade de Deus",
            "O Poderoso Chefão",
            "Forrest Gump",
            "Titanic",
            "Avatar",
            "Clube da Luta",
            "De Volta para o Futuro",
            "O Silêncio dos Inocentes",
            "Gladiador",
            "A Origem",
            "O Rei Leão"
        };
        String[] generos = {"Ação", "Aventura", "Comédia", "Drama", "Ficção Científica"};
        int[] anosLancamento = {1999, 2001, 2010, 1994, 1993};

        Random random = new Random();
        String titulo = titulos[random.nextInt(titulos.length)];
        String genero = generos[random.nextInt(generos.length)];
        int anoLancamento = anosLancamento[random.nextInt(anosLancamento.length)];

        return new Filme(titulo, "", genero, String.valueOf(anoLancamento));
    }
	}


	