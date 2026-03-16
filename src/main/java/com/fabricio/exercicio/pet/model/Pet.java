package com.fabricio.exercicio.pet.model;

public class Pet {
    private Integer id;
    private String  nome;
    private int     idade;
    private String  raca;
    private String  sexo;
    private String  cor;

    public Pet() {}

    public Pet(Integer id, String nome, int idade, String raca, String sexo, String cor) {
        this.id    = id;
        this.nome  = nome;
        this.idade = idade;
        this.raca  = raca;
        this.sexo  = sexo;
        this.cor   = cor;
    }

    // Getters e Setters
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String  getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public String  getRaca(){
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String  getSexo(){
        return sexo;
    }
    public void    setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String  getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Idade: " + idade +
               " | Raca: " + raca + " | Sexo: " + sexo + " | Cor: " + cor;
    }
}
