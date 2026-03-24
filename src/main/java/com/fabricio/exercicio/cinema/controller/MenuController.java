package com.fabricio.exercicio.cinema.controller;

import com.fabricio.exercicio.cinema.service.MovieService;
import com.fabricio.exercicio.cinema.view.MenuView;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    private final Scanner sc = new Scanner(System.in);
    private final MenuView view = new MenuView();
    private final MovieService movieService = new MovieService();

    int opcao;

    public void menuSelectOption() throws IOException, InputMismatchException {
            while(opcao != 5){
                try{
                    view.menuDisplay();
                    opcao = sc.nextInt();

                    if(opcao < 1 || opcao > 5){
                        System.out.println("Escolha um valor valido entre 1 e 5");
                    }
                    switch(opcao){
                        case 1:
                            movieService.saveMovie();
                            break;
                        case  2:
                            movieService.lerFilme();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                    }
                }catch(InputMismatchException e){
                    System.out.println("Escolher um valor valido entre 1 e 5");
                    sc.nextLine();
                }
            }
            sc.close();
    }
}


