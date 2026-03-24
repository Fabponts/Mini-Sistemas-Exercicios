package com.fabricio.exercicio.cinema;

import com.fabricio.exercicio.cinema.controller.MenuController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController();
        menuController.menuSelectOption();

    }
}
