package com.fabricio.exercicio.cinema.model;

import com.fabricio.exercicio.cinema.enums.MovieEnum;

import java.time.LocalDate;

public class Movie {

    //Atributos
    private String titulo;
    private String director;
    private double rating;
    private LocalDate releaseDate;
    private MovieEnum genre;

    //Contrutores
    public Movie(){
    }
    public Movie(String titulo, String director, double rating, LocalDate releaseDate, MovieEnum genre) {
        this.titulo = titulo;
        this.director = director;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    //Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MovieEnum getGenre() {
        return genre;
    }

    public void setGenre(MovieEnum genre) {
        this.genre = genre;
    }

    //Metodo ToString Personalizado
    @Override
    public String toString() {
        return "titulo=" + titulo + ", director=" + director + ", rating=" + rating + ", release Date=" + releaseDate + ", genre=" + genre;
    }
}
