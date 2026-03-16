package com.fabricio.exercicio.pet.service;

import com.fabricio.exercicio.pet.model.Pet;
import com.fabricio.exercicio.pet.repository.PetRepository;
import com.fabricio.exercicio.pet.view.PetView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetService {
    private final Scanner       scanner       = new Scanner(System.in);
    private final PetView       petView       = new PetView();
    private final PetRepository petRepository = new PetRepository();

    private List<Pet> pets = new ArrayList<>();

    public PetService() throws IOException {
        pets = petRepository.carregarPets();
    }

    public void cadastrarPet() throws IOException {
        try {
            int novoId = petRepository.proximoId();
            Pet pet    = petView.formularioCadastrarPet(novoId);

            boolean salvo = petRepository.salvarPet(pet);
            if (salvo) {
                pets.add(pet);
                System.out.println("Pet cadastrado com sucesso! ID: " + novoId);
            } else {
                System.out.println("Erro ao cadastrar pet!");
            }
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pet: " + e.getMessage());
        }
    }
    public void removerPet() throws IOException {
        if (pets.isEmpty()) {
            System.out.println("Nao ha pets cadastrados no sistema!");
            return;
        }

        System.out.print("Digite o nome do pet que deseja remover: ");
        String nome = scanner.nextLine().trim();

        Pet petEncontrado = null;
        for (Pet p : pets) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                petEncontrado = p;
                break;
            }
        }

        if (petEncontrado == null) {
            System.out.println("Pet nao encontrado com o nome: " + nome);
            return;
        }

        pets.remove(petEncontrado);

        boolean removidoDoArquivo = petRepository.removerPetDoArquivo(petEncontrado.getId());

        if (removidoDoArquivo) {
            System.out.println("Pet \"" + petEncontrado.getNome() + "\" (ID " + petEncontrado.getId() + ") removido com sucesso!");
        } else {
            System.out.println("Pet removido da memoria, mas nao encontrado no arquivo.");
        }
    }

    public void listarPets() throws IOException {
        if (pets.isEmpty()) {
            System.out.println("Nao ha pets cadastrados no sistema!");
            return;
        }
        System.out.println("===== Pets disponíveis para adoção =====");
        petRepository.lerArquivo();
        System.out.println("========================================");
    }
}
