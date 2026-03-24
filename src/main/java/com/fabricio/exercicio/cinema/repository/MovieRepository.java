package com.fabricio.exercicio.cinema.repository;

import com.fabricio.exercicio.cinema.model.Movie;

import java.io.*;

public class MovieRepository {
    private final String ARQUIVO_MOVIE = "movie.txt";

    public void salvarFilme(Movie movie) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_MOVIE, true))) {
            bw.write(
                            "Titulo do filme: " + movie.getTitulo()  + " | " +
                            "Diretor: "+ movie.getDirector() + " | " +
                            "Avaliação: " + movie.getRating()  + " | " +
                            "Data de Lançamento: " + movie.getReleaseDate()  + " | " +
                            "Genero: "  + movie.getGenre()
            );
            bw.newLine();
        }
    }
    public void lerFilme() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_MOVIE))) {
            String linha;
            while((linha = br.readLine()) != null){
                System.out.println(linha);
            }
        }
        System.out.println("---------------FIM DA LISTA---------------");
    }
}
