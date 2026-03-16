package com.fabricio.exercicio.pet.view;

import com.fabricio.exercicio.pet.model.Pet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PetView {
    private final Scanner sc = new Scanner(System.in);

    // Agora recebe o ID gerado pelo repositório
    public Pet formularioCadastrarPet(int id) {
        Pet pet = new Pet();
        pet.setId(id);

        try {
            System.out.print("Digite o nome do pet: ");
            pet.setNome(sc.nextLine().trim());

            System.out.print("Digite a idade: ");
            pet.setIdade(sc.nextInt());
            sc.nextLine(); // limpa o buffer

            System.out.print("Digite a raca: ");
            pet.setRaca(sc.nextLine().trim());

            System.out.print("Digite o sexo (M/F): ");
            pet.setSexo(sc.nextLine().trim());

            System.out.print("Digite a cor: ");
            pet.setCor(sc.nextLine().trim());

        } catch (InputMismatchException e) {
            sc.nextLine(); // limpa o buffer em caso de erro
            throw new InputMismatchException("Valor inválido digitado no formulário.");
        }

        return pet;
    }
}
