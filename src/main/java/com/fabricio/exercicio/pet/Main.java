package com.fabricio.exercicio.pet;

import com.fabricio.exercicio.pet.controller.MenuController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController();
        menuController.chosenOption();
    }
}
