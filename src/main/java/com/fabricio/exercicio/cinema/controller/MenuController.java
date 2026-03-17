package com.fabricio.exercicio.cinema.controller;

import com.fabricio.exercicio.cinema.view.MenuView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    private final Scanner sc = new Scanner(System.in);
    private final MenuView view = new MenuView();

    int opcao;

    public void menuSelectOption(){
            while(opcao != 5){
                try{
                    view.menuDisplay();
                    opcao = sc.nextInt();

                    if(opcao < 1 || opcao > 5){
                        System.out.println("Escolha um valor valido entre 1 e 5");
                    }
                    switch(opcao){
                        case 1:
                            break;
                        case  2:
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


