package com.exercicis;

import java.util.ArrayList;
import java.util.Random;

public class Exercici0010 {

    public static ArrayList<Integer> generarNumerosAleatoris(int quantitat, int min, int max) {
        Random random = new Random();
        ArrayList<Integer> arr =new ArrayList<>();
        for (int i = 0; i < quantitat;i++){
            arr.add(random.nextInt(min,max));
        }
        return arr;
    }

    public static ArrayList<Integer> multiplicarPerDos(ArrayList<Integer> llista) {
        ArrayList<Integer> multiplicarPerDos = new ArrayList<>();
        for (int numbers : llista){
            multiplicarPerDos.add(numbers*2);
        }
        return multiplicarPerDos;
    }

    public static ArrayList<Integer> filtrarImparells(ArrayList<Integer> llista) {
        ArrayList<Integer> llistaFiltrarImparells = new ArrayList<>();
        for (int numbers : llista){
            if (numbers%2!=0){
                llistaFiltrarImparells.add(numbers);
            }
        }
        return llistaFiltrarImparells;
    }

    public static ArrayList<Double> dividirPerDos(ArrayList<Integer> llista) {
        ArrayList<Double> llistaDividirPerDos= new ArrayList<>();
        for (int numbers : llista){
            llistaDividirPerDos.add(numbers/2.0);
        }
        return llistaDividirPerDos;
    }

    public static void main(String[] args) {
        ArrayList<Integer> llistaAleatoria = generarNumerosAleatoris(10, 0, 99);
        System.out.println("Llista inicial: " + llistaAleatoria);
        ArrayList<Integer> llistaMultiplicada = multiplicarPerDos(llistaAleatoria);
        System.out.println("Llista multiplicada per 2: " + llistaMultiplicada);
        ArrayList<Integer> llistaImparells = filtrarImparells(llistaAleatoria);
        System.out.println("Llista només amb números imparells: " + llistaImparells);
        ArrayList<Double> llistaDividida = dividirPerDos(llistaImparells);
        System.out.println("Llista imparells dividits per 2: " + llistaDividida);
    }
}
