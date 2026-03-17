package com.fabricio.exercicio.cinema.view;

public class MenuView {

    public void menuDisplay(){
        String menu = """
                ===================Bem vindo ao avaliador de filme pessoal===================
                ===================Selecione a ação que deseja realizar===================
                1-Inclua um titulo e avalie
                2-Listar seus filmes
                3-Buscar um filme por titulo
                4-Remover filme
                5- Sair do programa
                """;
        System.out.println(menu);
    }

}
