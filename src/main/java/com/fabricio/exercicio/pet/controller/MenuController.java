package com.fabricio.exercicio.pet.controller;

import com.fabricio.exercicio.pet.service.PetService;
import com.fabricio.exercicio.pet.view.MenuView;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {

    private final MenuView   view;
    private final PetService petService;
    private final Scanner    sc = new Scanner(System.in);
    private int opcao = 0;

    public MenuController() throws IOException {
        this.view       = new MenuView();
        this.petService = new PetService();
    }

    public void chosenOption() throws IOException {
        while (opcao != 4) {
            view.displayMenu();
            try {
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> petService.cadastrarPet();
                    case 2 -> petService.removerPet();
                    case 3 -> petService.listarPets();
                    case 4 -> {
                        System.out.println("Obrigado por utilizar nosso serviço!");
                        System.exit(0);
                    }
                    default -> System.out.println("Opcao invalida! Escolha entre 1 e 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Insira um numero valido entre 1 e 4.");
                sc.nextLine(); // limpa o buffer
            }
        }
    }
}
