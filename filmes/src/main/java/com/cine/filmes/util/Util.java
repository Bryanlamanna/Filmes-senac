package com.cine.filmes.util;

public class Util {

    

    public static boolean checkData(String titulo, String sinopse, String genero, String anoLancamento) {
        // Verifica se algum dos parâmetros é nulo ou vazio
        if (titulo == null || titulo.trim().isEmpty()) {
            return true;  // O título está vazio ou em branco
        }
        if (sinopse == null || sinopse.trim().isEmpty()) {
            return true;  // A sinopse está vazia ou em branco
        }
        if (genero == null || genero.trim().isEmpty()) {
            return true;  // O gênero está vazio ou em branco
        }
        if (anoLancamento == null || anoLancamento.trim().isEmpty()) {
            return true;  // O ano de lançamento está vazio ou em branco
        }
    
        // Se nenhum dos campos está vazio ou em branco, retorna false
        return false;
    }
    
}
