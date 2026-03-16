package com.fabricio.exercicio.pet.repository;

import com.fabricio.exercicio.pet.model.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PetRepository {
    private static final String ARQUIVO_PETS = "pets.txt";
    private static final String ARQUIVO_ID   = "pets_id.txt";

    public int proximoId() throws IOException {
        File arquivo = new File(ARQUIVO_ID);
        int id = 1;

        if (arquivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                String linha = br.readLine();
                if (linha != null && !linha.isBlank()) {
                    id = Integer.parseInt(linha.trim()) + 1;
                }
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, false))) {
            bw.write(String.valueOf(id));
        }

        return id;
    }
    public boolean salvarPet(Pet pet) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_PETS, true))) {
            bw.write(
                "id: "   + pet.getId()    + " | " +
                "Nome: " + pet.getNome()  + " | " +
                "Idade: "+ pet.getIdade() + " | " +
                "Raca: " + pet.getRaca()  + " | " +
                "Sexo: " + pet.getSexo()  + " | " +
                "Cor: "  + pet.getCor()
            );
            bw.newLine();
            return true;
        }
    }
    public void lerArquivo() throws IOException {
        File arquivo = new File(ARQUIVO_PETS);
        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("Nenhum pet cadastrado no arquivo.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

    public boolean removerPetDoArquivo(int id) throws IOException {
        File arquivo = new File(ARQUIVO_PETS);
        File temp    = new File("pets_temp.txt");

        if (!arquivo.exists()) return false;

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("id: " + id + " |")) {
                    encontrado = true;
                } else {
                    bw.write(linha);
                    bw.newLine();
                }
            }
        }

        arquivo.delete();
        temp.renameTo(arquivo);

        return encontrado;
    }

    public List<Pet> carregarPets() throws IOException {
        List<Pet> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO_PETS);
        if (!arquivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.isBlank()) continue;
                try {
                    String[] partes = linha.split("\\|");
                    int    id    = Integer.parseInt(partes[0].replace("id:", "").trim());
                    String nome  = partes[1].replace("Nome:", "").trim();
                    int    idade = Integer.parseInt(partes[2].replace("Idade:", "").trim());
                    String raca  = partes[3].replace("Raca:", "").trim();
                    String sexo  = partes[4].replace("Sexo:", "").trim();
                    String cor   = partes[5].replace("Cor:", "").trim();
                    lista.add(new Pet(id, nome, idade, raca, sexo, cor));
                } catch (Exception e) {
                    // linha malformada - ignora
                }
            }
        }
        return lista;
    }
}
