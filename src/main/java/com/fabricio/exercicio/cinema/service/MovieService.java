package com.fabricio.exercicio.cinema.service;

import com.fabricio.exercicio.cinema.enums.MovieEnum;
import com.fabricio.exercicio.cinema.model.Movie;
import com.fabricio.exercicio.cinema.repository.MovieRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieService {
    private MovieRepository movieRepository = new MovieRepository();
    private final Scanner scanner = new Scanner(System.in);
    private Movie movie;


    public void saveMovie() throws IOException {
        Movie movie = new Movie();
        try {
            System.out.println("Digite o nome do novo movie ");
            movie.setTitulo(scanner.nextLine());

            System.out.println("Qual é o diretor?");
            movie.setDirector(scanner.nextLine());


            System.out.println("De uma nota de 1 a 5");
            movie.setRating(scanner.nextDouble());
            scanner.nextLine();

            if (movie.getRating() > 5 || movie.getRating() <= 0) {
                System.out.println("Digite uma nota de 1 a 5");
                throw new InputMismatchException();
            }

            System.out.println("Data de lançamento do filme no formato (dd/MM/yyyy)");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            movie.setReleaseDate(LocalDate.parse(scanner.nextLine(), formatter));

            System.out.println("Defina o genero do filme");
            movie.setGenre(MovieEnum.valueOf(scanner.nextLine().toUpperCase()));

            movieRepository.salvarFilme(movie);
            System.out.println("Filme salvo com sucesso");

        } catch (InputMismatchException e) {
            System.out.println("Digite um valor valido por favor");
        }
    }

    public void lerFilme() throws IOException{
        movieRepository.lerFilme();
    }
}
