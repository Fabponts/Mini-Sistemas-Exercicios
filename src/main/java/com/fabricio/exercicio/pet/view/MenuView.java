package com.fabricio.exercicio.pet.view;

public class MenuView {

    public void displayMenu(){
        System.out.println("-----Bem vindos ao sistema de cadastro adote seu pet------");
        System.out.println("Qual serviço abaixo gostaria de realizar?");
        String menu = """
                1.Cadastrar pet para adoção
                2.Remover pet (ja foi adotado)
                3.Listar pets disponiveis para adoção
                4. Sair do sistema
                """;
        System.out.println(menu);
    }
}
