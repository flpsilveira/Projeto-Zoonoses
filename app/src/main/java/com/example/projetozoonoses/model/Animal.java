package com.example.projetozoonoses.model;

public class Animal {

    private String Características;
    private String Castrado;
    private String Cor;
    private String Foto; // ver se nao é String
    private String Idade;
    private String Nome;
    private String Observação;
    private String Raça;
    private String Sexo;
    private String Vacina;

    public String getCaracterísticas() {
        return Características;
    }

    public void setCaracterísticas(String características) {
        Características = características;
    }

    public String getObservação() {
        return Observação;
    }

    public void setObservação(String observação) {
        Observação = observação;
    }

    public String getCastrado() {
        return Castrado;
    }

    public void setCastrado(String castrado) {
        Castrado = castrado;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        Cor = cor;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String idade) {
        Idade = idade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }


    public String getRaça() {
        return Raça;
    }

    public void setRaça(String raça) {
        Raça = raça;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getVacina() {
        return Vacina;
    }

    public void setVacina(String vacina) {
        Vacina = vacina;
    }
}
