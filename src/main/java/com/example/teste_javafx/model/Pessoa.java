package com.example.teste_javafx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Pessoa {

    private int ID;
    private String nome;
    private float altura;
    private float peso;
    private float imc;

    //****************************************


    public Pessoa(int ID, String nome, float altura, float peso, float imc) {
        this.ID = ID;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
    }

    public Pessoa() {
    }

    //****************************************


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    //****************************************

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }

    //****************************************

    public float calcularIMC(){
        this.imc = this.peso / (altura * altura);
        return this.imc;
    }

    //****************************************

    public String classificacaoIMC(){
        String classificacao;

        if (this.imc < 18.5){
            return "Abaixo do peso";
        } else if (this.imc < 25) {
            return "Peso normal";
        } else if (this.imc < 30) {
            return "Sobrepeso";
        }else if (this.imc < 35) {
            return "Obesidade Grau 1";
        } else if (this.imc < 40) {
            return "Obesidade Grau 2";
        }else {
            return "Obesidade Grau 3";
        }
    }
}
